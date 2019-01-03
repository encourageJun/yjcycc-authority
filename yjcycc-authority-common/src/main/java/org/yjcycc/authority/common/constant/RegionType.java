package org.yjcycc.authority.common.constant;

/**
 * 区域类型
 */
public enum RegionType {

    region_type_1("region_type_1", 1, "国家"),
    region_type_2("region_type_2", 2, "省/直辖市"),
    region_type_3("region_type_3", 3, "地市"),
    region_type_4("region_type_4", 4, "区县"),
    ;

    private String label;
    private Integer value;
    private String name;

    RegionType(String label, Integer value, String name) {
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

    public RegionType getByLabel(String label) {
        for (RegionType lc : RegionType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc;
            }
        }
        return null;
    }

    public Integer getValueByLabel(String label) {
        for (RegionType lc : RegionType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getValue();
            }
        }
        return null;
    }

    public String getNameByLabel(String label) {
        for (RegionType lc : RegionType.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getName();
            }
        }
        return null;
    }

}
