package org.yjcycc.authority.common.constant;

/**
 * 机构类型
 */
public enum BranchType {

    branch_type_1("branch_type_1", 1, "公司"),
    branch_type_2("branch_type_2", 2, "部门"),
    branch_type_3("branch_type_3", 3, "小组"),
    branch_type_4("branch_type_4", 4, "其他"),
    ;

    private String label;
    private Integer value;
    private String name;

    BranchType(String label, Integer value, String name) {
        this.label = label;
        this.value = value;
        this.name = name;
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public BranchType getByLabel(String label) {
        for (BranchType lc : BranchType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc;
            }
        }
        return null;
    }

    public Integer getValueByLabel(String label) {
        for (BranchType lc : BranchType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getValue();
            }
        }
        return null;
    }

    public String getNameByLabel(String label) {
        for (BranchType lc : BranchType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getName();
            }
        }
        return null;
    }

}
