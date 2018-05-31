package com.danny.seckill.model.param.system;

import com.danny.seckill.model.param.BaseParameter;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserParameter
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-05-30 22:45:18
 */
public class UserParameter extends BaseParameter{

    private String username;

    private String password;

    private String salt;

    private String realname;

    private String idcardno;

    private String mobileno;

    private String email;

    private String address;

    private Integer sex;

    private Integer age;

    private String portrait;

    private Date birthday;

    private Long districtid;

    private Integer status;

    public String getUsername() {
        return username;
    }

    public UserParameter setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserParameter setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public UserParameter setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getRealname() {
        return realname;
    }

    public UserParameter setRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public UserParameter setIdcardno(String idcardno) {
        this.idcardno = idcardno;
        return this;
    }

    public String getMobileno() {
        return mobileno;
    }

    public UserParameter setMobileno(String mobileno) {
        this.mobileno = mobileno;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserParameter setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserParameter setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public UserParameter setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserParameter setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public UserParameter setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserParameter setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public UserParameter setDistrictid(Long districtid) {
        this.districtid = districtid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserParameter setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
