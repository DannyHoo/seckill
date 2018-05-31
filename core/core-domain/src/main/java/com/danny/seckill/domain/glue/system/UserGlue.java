package com.danny.seckill.domain.glue.system;

import com.danny.seckill.dao.mybatis.dao.system.UserMapper;
import com.danny.seckill.dao.mybatis.data.system.UserDO;
import com.danny.seckill.domain.business.system.UserBusiness;
import com.danny.seckill.domain.glue.base.BaseGlue;
import com.danny.seckill.framework.util.collection.ListUtil;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author huyuyang@lxfintech.com
 * @Title: UserGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:04:08
 */
@Component
public class UserGlue extends BaseGlue {


    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param
     * @return
     * @throws Exception
     */
    /*public UserDO login(UserParameter userParameter) throws Exception {
        UserDO loginResult = null;

        UserDO userFound = findByUserName(userParameter);
        if (userFound != null) {
            String password = userBusiness.decryptPassword(userParameter.getPassword(), getRsaPrivateKey());
            String md5Password = MD5Util.md5HexTwoSourceAndSalt(password, userFound.getSalt());
            if (userFound.getPassword().equals(md5Password)) {
                loginResult = userFound;
            }
        }
        return loginResult;
    }*/

    public User findByUserName(String userName) {
        List<UserDO> userDOList = userMapper.selectByUserName(userName);
        if (ListUtil.isEmpty(userDOList)) return null;
        UserDO userDO=userDOList.get(0);
        return convertIgnoreNullProperty(userDO,User.class);
    }

    public User saveUser(UserParameter userParameter) {
        UserDO userDO=convertIgnoreNullProperty(userParameter,UserDO.class);
        int insertResult= userMapper.insert(userDO);
        return convertIgnoreNullProperty(userDO,User.class);
    }

    /**
     * 用户注册
     *
     * @param userParameter
     * @return
     * @throws Exception
     */
    /*public UserDO register(UserParameter userParameter) throws Exception {
        UserDO user = new UserDO();
        String password = userBusiness.decryptPassword(userParameter.getPassword(), getRsaPrivateKey());
        String salt = Generator.getStringRandom(8);
        user.setEmail(userParameter.getEmail())
                .setUserName(userParameter.getUserName())
                .setSalt(salt)
                .setPassword(MD5Util.md5HexTwoSourceAndSalt(userParameter.getPassword(), salt));
        UserDO userDO = convertIgnoreNullProperty(user, UserDO.class);
        userDO = userDAO.save(userDO);
        user = convertIgnoreNullProperty(userDO, UserDO.class);
        return user;
    }*/
}
