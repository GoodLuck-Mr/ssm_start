package com.ssm.domain;

import com.ssm.utils.UuidUtils;
import java.io.Serializable;
import java.util.List;

/**
 * @projectName: mrzhao_ssm
 * @className : Role
 * 类 的 描 述  ：创建角色实体类 ！
 **/
public class Role implements Serializable {
    private String id;
    private String roleName;                   //角色名
    private String roleDesc;                   // 角色描述
    private List<Permission> permissions;
    private List<UserInfo> users;

    public String getId() {
        return UuidUtils.creatUUID();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
