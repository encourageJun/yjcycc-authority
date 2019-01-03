package org.yjcycc.authority.service.impl;

import org.springframework.stereotype.Service;
import org.yjcycc.authority.common.entity.User;
import org.yjcycc.authority.service.api.IUserService;
import org.yjcycc.tools.common.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
}
