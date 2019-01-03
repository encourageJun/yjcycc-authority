package org.yjcycc.authority.common.constant;

/**
 * 职位
 */
public enum Job {

    job_1("job_1", 1, "总裁"),
    job_2("job_2", 2, "总经理"),
    job_3("job_3", 3, "部门经理"),
    job_4("job_4", 4, "组长"),
    job_5("job_5", 5, "高级技术员"),
    job_6("job_6", 6, "中级技术员"),
    job_7("job_7", 7, "初级技术员"),
    job_8("job_8", 8, "普通员工"),

    ;

    private String label;
    private Integer value;
    private String name;

    Job(String label, Integer value, String name) {
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

    public Job getByLabel(String label) {
        for (Job lc : Job.values()) {
            if (lc.getLabel().equals(label)) {
                return lc;
            }
        }
        return null;
    }

    public Integer getValueByLabel(String label) {
        for (Job lc : Job.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getValue();
            }
        }
        return null;
    }

    public String getNameByLabel(String label) {
        for (Job lc : Job.values()) {
            if (lc.getLabel().equals(label)) {
                return lc.getName();
            }
        }
        return null;
    }
    
}
