package com.ssm.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @projectName: mrzhao_ssm
 * @className : Permission
 * 类 的 描 述  ：创建资源权限，，实体类 ！
 **/
public class Permission implements Serializable {
    private String id;
    private String permissionName;      //资源权限名称
    private String url;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
