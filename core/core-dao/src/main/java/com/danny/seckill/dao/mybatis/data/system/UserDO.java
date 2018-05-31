package com.danny.seckill.dao.mybatis.data.system;

import com.danny.seckill.dao.mybatis.data.BaseDO;

import java.util.Date;

public class UserDO extends BaseDO{

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

    public UserDO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public UserDO setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getRealname() {
        return realname;
    }

    public UserDO setRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public UserDO setIdcardno(String idcardno) {
        this.idcardno = idcardno;
        return this;
    }

    public String getMobileno() {
        return mobileno;
    }

    public UserDO setMobileno(String mobileno) {
        this.mobileno = mobileno;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public UserDO setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public UserDO setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserDO setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public UserDO setDistrictid(Long districtid) {
        this.districtid = districtid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserDO setStatus(Integer status) {
        this.status = status;
        return this;
    }

}