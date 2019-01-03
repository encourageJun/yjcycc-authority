package org.yjcycc.authority.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yjcycc.authority.common.entity.Department;
import org.yjcycc.authority.service.api.IDepartmentService;
import org.yjcycc.tools.common.Pager;
import org.yjcycc.tools.zk.rmi.RMIClient;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    private Logger logger = Logger.getLogger(DepartmentController.class);

    /**
     * 跳转投注页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model) {
        IDepartmentService service = (IDepartmentService) RMIClient.getRemoteService(IDepartmentService.class);

        return "department/list";
    }

    @ResponseBody
    @RequestMapping(value = "/listdata")
    public Map<String, Object> getListData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "0");
        map.put("msg", "成功");

        IDepartmentService service = (IDepartmentService) RMIClient.getRemoteService(IDepartmentService.class);

        try {
            Map<String,Object> paramMap = new HashMap<String, Object>();
            Pager<Department> pager = service.findPager(paramMap, 1, 30);
            map.put("count", pager.getTotalCount());
            map.put("data", pager.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
