package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;


/**
 * 用户
 */
@Alias("User")
public class User extends BaseEntity {

    private String loginName; // 登录名

    private String passwd; // 密码

    private String realName; // 姓名

    private String nick; // 昵称

    private Integer job; // 职位, 1ceo 2总经理 3部门经理 4组长 5高级技术员 6中级技术员 7初级技术员 8普通员工, 数据字典:Job

    private String email; // 电子邮箱

    private String qq; // qq号码

    private String wechat; // 微信号

    private String phone; // 手机号码

    private String address; // 联系地址

    private String path; // 路径

    private String description; // 描述

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
