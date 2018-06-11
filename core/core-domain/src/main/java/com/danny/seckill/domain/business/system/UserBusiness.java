package com.danny.seckill.domain.business.system;

import com.danny.seckill.framework.util.RSAUtil;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserBusiness
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-01-07 22:03:59
 */
@Component
public class UserBusiness {

    /**
     * 用私钥解密经过RSA加密后的密码
     *
     * @param password
     * @param privateKey
     * @return
     * @throws Exception
     */
    public String decryptPassword(String password, String privateKey) throws Exception {
        String decryptedPassword = RSAUtil.decrypt(RSAUtil.loadPrivateKey(privateKey), RSAUtil.strToBase64(password));
        return decryptedPassword;
    }

}
