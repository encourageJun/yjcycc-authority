package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;


/**
 * 区域
 */
@Alias("Region")
public class Region extends BaseEntity {

    private Long parentId; // 上级区域

    private Integer regionType; // 区域类型, 1国家 2省/直辖市 3地市 4区县, 数据字典: RegionType

    private String name; // 区域名

    private String code; // 区域编码

    private String path; // 路径

    private String description; // 描述

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
