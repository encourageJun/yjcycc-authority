package org.yjcycc.authority.service.impl;

import org.springframework.stereotype.Service;
import org.yjcycc.authority.common.entity.Role;
import org.yjcycc.authority.service.api.IRoleService;
import org.yjcycc.tools.common.service.impl.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
}
