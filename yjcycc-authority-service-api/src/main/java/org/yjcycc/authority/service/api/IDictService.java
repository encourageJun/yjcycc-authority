package org.yjcycc.authority.service.api;

import org.yjcycc.authority.common.entity.Dict;
import org.yjcycc.tools.common.service.BaseService;

import java.rmi.RemoteException;
import java.util.List;

public interface IDictService extends BaseService<Dict> {

    List<Dict> getDictList(String type) throws RemoteException;

}
