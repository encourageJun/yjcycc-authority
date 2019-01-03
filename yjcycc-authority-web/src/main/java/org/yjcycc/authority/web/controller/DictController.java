package org.yjcycc.authority.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yjcycc.authority.common.entity.Dict;
import org.yjcycc.authority.service.api.IDictService;
import org.yjcycc.tools.zk.rmi.RMIClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/dict")
public class DictController {

    @ResponseBody
    @RequestMapping(value = "/listdata")
    public Map<String, Object> getListData(String type) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功");

        IDictService service = (IDictService) RMIClient.getRemoteService(IDictService.class);

        try {
            Dict dict = new Dict();
            dict.setType(type);
            List<Dict> list = service.findList(dict);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
