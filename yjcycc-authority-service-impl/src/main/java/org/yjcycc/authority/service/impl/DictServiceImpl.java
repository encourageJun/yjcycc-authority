package org.yjcycc.authority.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjcycc.authority.common.entity.Dict;
import org.yjcycc.authority.service.api.IDictService;
import org.yjcycc.authority.service.mapper.DictMapper;
import org.yjcycc.tools.common.service.impl.BaseServiceImpl;

import java.util.List;

@Service("dictService")
public class DictServiceImpl extends BaseServiceImpl<Dict> implements IDictService {

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private void initBaseMapper() {
        setBaseMapper(dictMapper);
    }

    @Override
    public List<Dict> getDictList(String type) {
        Dict dict = new Dict();
        dict.setType(type);
        return dictMapper.findList(dict);
    }

}
