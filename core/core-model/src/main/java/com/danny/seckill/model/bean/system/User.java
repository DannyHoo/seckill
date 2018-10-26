package com.danny.seckill.model.bean.system;

import com.danny.seckill.model.bean.BaseBean;

import java.util.Date;

/**
 * @author dannyhoo
 * @Title: User
 * @Description:
 * @Created on 2018-05-30 22:46:08
 */
public class User extends BaseBean {
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

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getRealname() {
        return realname;
    }

    public User setRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public User setIdcardno(String idcardno) {
        this.idcardno = idcardno;
        return this;
    }

    public String getMobileno() {
        return mobileno;
    }

    public User setMobileno(String mobileno) {
        this.mobileno = mobileno;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public User setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public User setDistrictid(Long districtid) {
        this.districtid = districtid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
