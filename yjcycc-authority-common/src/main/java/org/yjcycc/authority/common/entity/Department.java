package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;


/**
 * 部门
 */
@Alias("Department")
public class Department extends BaseEntity {

    private Long parentId; // 上级部门

    private Long regionId; // 所属区域

    private Integer branchType; // 机构类型, 1公司 2部门 3项目组 4其他, 数据字典: BranchType

    private String name; // 部门名称

    private String identifier; // 部门标识

    private Long mainHead; // 主要负责人, 用户id

    private Long deputyHead; // 副负责人, 用户id

    private String path; // 路径

    private String pathCn; // 中文路径

    private Integer sort; // 排序

    private String description; // 描述

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getBranchType() {
        return branchType;
    }

    public void setBranchType(Integer branchType) {
        this.branchType = branchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getMainHead() {
        return mainHead;
    }

    public void setMainHead(Long mainHead) {
        this.mainHead = mainHead;
    }

    public Long getDeputyHead() {
        return deputyHead;
    }

    public void setDeputyHead(Long deputyHead) {
        this.deputyHead = deputyHead;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathCn() {
        return pathCn;
    }

    public void setPathCn(String pathCn) {
        this.pathCn = pathCn;
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
