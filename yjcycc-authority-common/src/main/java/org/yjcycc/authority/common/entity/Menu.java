package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;


/**
 * 菜单
 */
@Alias("Menu")
public class Menu extends BaseEntity {

    private Long parentId; // 上级菜单

    private Integer menuType; // 菜单类型, 默认1, 1菜单2操作, 数据字典: MenuType

    private String path; // 路径

    private String name; // 菜单名

    private String url; // 链接

    private String authoritySymbol; // 权限符

    private String picUrl; // 图片

    private Integer sort; // 排序

    private String description; // 描述

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthoritySymbol() {
        return authoritySymbol;
    }

    public void setAuthoritySymbol(String authoritySymbol) {
        this.authoritySymbol = authoritySymbol;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
