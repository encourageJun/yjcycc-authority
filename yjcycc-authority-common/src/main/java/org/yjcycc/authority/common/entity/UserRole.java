package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;


/**
 * 用户角色类
 */
@Alias("UserRole")
public class UserRole extends BaseEntity {

    private User user;

    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
