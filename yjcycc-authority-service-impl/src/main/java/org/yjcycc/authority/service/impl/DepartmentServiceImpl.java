package org.yjcycc.authority.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjcycc.authority.common.entity.Department;
import org.yjcycc.authority.service.api.IDepartmentService;
import org.yjcycc.authority.service.mapper.DepartmentMapper;
import org.yjcycc.tools.common.service.impl.BaseServiceImpl;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private void initMapper(DepartmentMapper departmentMapper) {
        this.setBaseMapper(departmentMapper);
    }

}
