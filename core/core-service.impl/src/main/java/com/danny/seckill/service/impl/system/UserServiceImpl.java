package com.danny.seckill.service.impl.system;

import com.danny.seckill.domain.glue.system.UserGlue;
import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.service.CallbackResult;
import com.danny.seckill.framework.service.ServiceCallbackAction;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.service.impl.BaseServiceImpl;
import com.danny.seckill.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author dannyhoo
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:50:48
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserGlue userGlue;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 用户注册
     *
     * @param userParameter
     * @return
     */
    @Override
    public CommonResult<User> register(final UserParameter userParameter) {
        final String bizAction = "register";
        CallbackResult callbackResult = this.getServiceTemplate().execute(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getCheckParameterEmptyResult(userParameter, "email","username", "password");
            }

            @Override
            public CallbackResult executeAction() {
                try {
                    User userFound=userGlue.findByUserName(userParameter.getUsername());
                    if (userFound!=null){
                        return getFailureCallbackResult(ResultStatusEnum.USER_ALREADY_EXIST);
                    }
                    User user=userGlue.register(userParameter);
                    if (user!=null){
                        return getSuccessCallbackResult(user);
                    }else{
                        return getFailureCallbackResult();
                    }
                }catch (Exception e){
                    return getUnknowSystemErrorCallbackResult();
                }
            }
        });
        return getCommonResult(callbackResult);
    }

    /**
     * 用户登录
     *
     * @param userParameter
     * @return
     */
    @Override
    public CommonResult<User> login(final UserParameter userParameter) {
        final String bizAction = "login";
        CallbackResult callbackResult = this.getServiceTemplate().execute(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getCheckParameterEmptyResult(userParameter, "username", "password");
            }

            @Override
            public CallbackResult executeAction() {
                try {
                    User user=userGlue.login(userParameter);
                    if (user!=null){
                        return getSuccessCallbackResult(user);
                    }else{
                        return getFailureCallbackResult(ResultStatusEnum.USERNAME_OR_PASSWORD_INVALID);
                    }
                }catch (Exception e){
                    return getUnknowSystemErrorCallbackResult();
                }
            }
        });
        return getCommonResult(callbackResult);
    }

    @Override
    public CommonResult<User> findByUserName(final UserParameter userParameter) {
        final String bizAction = "findByUserName";

        User user = userGlue.findByUserName(userParameter.getUsername());
        CommonResult<User> userCommonResult = new CommonResult<>();
        userCommonResult.setBusinessObject(user).setBusinessResult(ResultStatusEnum.SUCCESS);
        return userCommonResult;
    }

    @Override
    public CommonResult<User> saveUser(final UserParameter userParameter) {
        final String bizAction = "saveUser";
        CallbackResult callbackResult = this.getServiceTemplate().execute(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getSuccessCallbackResult();
            }

            @Override
            public CallbackResult executeAction() {
                try {
                    User user = userGlue.saveUser(userParameter);
                    return getSuccessCallbackResult(user);
                } catch (Exception e) {
                    return getFailureCallbackResult();
                }
            }
        });
        return this.getCommonResult(callbackResult);
    }

    public CommonResult<User> updateUserByUserName(final UserParameter userParameter) {
        User user = (User) this.transactionTemplate.execute(new TransactionCallback<User>() {
            @Override
            public User doInTransaction(TransactionStatus status) {
                User user = null;
                // 数据库操作1
                user = userGlue.saveUser(userParameter);
                // 数据库操作2
                if (true) {//需要回滚
                    status.setRollbackOnly();
                }
                return user;
            }
        });
        User userFound = userGlue.findByUserName(userParameter.getUsername());
        return null;
    }

}
