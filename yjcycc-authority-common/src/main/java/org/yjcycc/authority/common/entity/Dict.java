package org.yjcycc.authority.common.entity;

import org.apache.ibatis.type.Alias;
import org.yjcycc.tools.common.entity.BaseEntity;

/**
 * 数据字典 Entity
 */
@Alias("Dict")
public class Dict extends BaseEntity {

    /**
     * 父级id, 默认0, 0表示空
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private Integer value;

    /**
     * '类型, 对应枚举类型
     */
    private String type;

    /**
     * 标签, 对应枚举名name()
     */
    private String label;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序(升序)
     */
    private Integer sort;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
