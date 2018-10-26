package com.danny.seckill.domain.glue.system;

import com.danny.seckill.dao.mybatis.dao.system.UserMapper;
import com.danny.seckill.dao.mybatis.data.system.UserDO;
import com.danny.seckill.domain.business.system.UserBusiness;
import com.danny.seckill.domain.glue.base.BaseGlue;
import com.danny.seckill.framework.core.PropertyPlaceholder;
import com.danny.seckill.framework.util.ListUtil;
import com.danny.seckill.framework.util.MD5Util;
import com.danny.seckill.framework.util.StringUtil;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.system.UserParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dannyhoo
 * @Title: UserGlue
 * @Description:
 * @Created on 2018-01-07 22:04:08
 */
@Component
public class UserGlue extends BaseGlue {

    @Autowired
    private UserBusiness userBusiness;
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param userParameter
     * @return
     * @throws Exception
     */
    public User register(UserParameter userParameter) throws Exception {
        UserDO userDO = convertIgnoreNullProperty(userParameter, UserDO.class);
        String password = userBusiness.decryptPassword(userParameter.getPassword(), PropertyPlaceholder.getProperty("rsaPrivateKey"));
        String salt = StringUtil.getStringRandom(8);
        userDO.setPassword(MD5Util.md5HexTwoSourceAndSalt(password, salt))
                .setSalt(salt);
        userMapper.insert(userDO);
        if (userDO.getId() == null) {
            return null;
        }
        return convertIgnoreNullProperty(userDO, User.class);
    }

    /**
     * 用户登录
     *
     * @param
     * @return
     * @throws Exception
     */
    public User login(UserParameter userParameter) throws Exception {
        UserDO userFound = findUserDOByUserName(userParameter.getUsername());
        if (userFound != null) {
            //用私钥解密前端传来的加密后的密码
            String password = userBusiness.decryptPassword(userParameter.getPassword(), PropertyPlaceholder.getProperty("rsaPrivateKey"));
            //对解密后的密码进行加盐加密处理，并与数据库中加盐加密的密码进行比较
            String md5Password = MD5Util.md5HexTwoSourceAndSalt(password, userFound.getSalt());
            if (userFound.getPassword().equals(md5Password)) {
                return convertIgnoreNullProperty(userFound, User.class);
            }
        }
        return null;
    }

    private UserDO findUserDOByUserName(String userName) {
        List<UserDO> userDOList = userMapper.selectByUserName(userName);
        if (ListUtil.isEmpty(userDOList)) return null;
        return userDOList.get(0);
    }

    public User findByUserName(String userName) {
        List<UserDO> userDOList = userMapper.selectByUserName(userName);
        if (ListUtil.isEmpty(userDOList)) return null;
        UserDO userDO = userDOList.get(0);
        return convertIgnoreNullProperty(userDO, User.class);
    }

    public User saveUser(UserParameter userParameter) {
        UserDO userDO = convertIgnoreNullProperty(userParameter, UserDO.class);
        int insertResult = userMapper.insert(userDO);
        return convertIgnoreNullProperty(userDO, User.class);
    }

}
