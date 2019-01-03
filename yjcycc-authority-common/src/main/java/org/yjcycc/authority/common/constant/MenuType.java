package org.yjcycc.authority.common.constant;

/**
 * 菜单类型
 */
public enum MenuType {

    menu_type_1("menu_type_1", 1, "菜单"),
    menu_type_2("menu_type_2", 2, "操作"),
    ;

    private String label;
    private Integer value;
    private String name;

    MenuType(String label, Integer value, String name) {
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

    public MenuType getByLabel(String label) {
        for (MenuType lc : MenuType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc;
            }
        }
        return null;
    }

    public Integer getValueByLabel(String label) {
        for (MenuType lc : MenuType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getValue();
            }
        }
        return null;
    }

    public String getNameByLabel(String label) {
        for (MenuType lc : MenuType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getName();
            }
        }
        return null;
    }
    
}
