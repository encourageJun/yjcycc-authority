package org.yjcycc.authority.service.impl;

import org.springframework.stereotype.Service;
import org.yjcycc.authority.common.entity.Menu;
import org.yjcycc.authority.service.api.IMenuService;
import org.yjcycc.tools.common.service.impl.BaseServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {
}
