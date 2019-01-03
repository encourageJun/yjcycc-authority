package org.yjcycc.authority.web.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.yjcycc.authority.common.entity.Dict;
import org.yjcycc.authority.service.api.IDictService;
import org.yjcycc.tools.redis.RedisUtils;
import org.yjcycc.tools.zk.rmi.RMIClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 */
public class DictUtils {

    private static IDictService dictService = (IDictService) RMIClient.getRemoteService(IDictService.class);

    public static final String CACHE_DICT_MAP = "dictCacheMap";


    public static List<Dict> getDictList(String type) {
        try {
            Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>) RedisUtils.get(CACHE_DICT_MAP);
            dictMap = null;
            if (dictMap == null) {
                dictMap = Maps.newHashMap();
                for (Dict dict : dictService.findList(new Dict())) {
                    List<Dict> dictList = dictMap.get(dict.getType());
                    if (dictList != null) {
                        dictList.add(dict);
                    } else {
                        dictMap.put(dict.getType(), Lists.newArrayList(dict));
                    }
                }
                RedisUtils.put(CACHE_DICT_MAP, dictMap);
            }
            List<Dict> dictList = dictMap.get(type);
            if (dictList == null) {
                dictList = Lists.newArrayList();
            }
            return dictList;
        } catch (Exception e) {

        }
        return Lists.newArrayList();
    }


    public static Dict getDict(Integer value, String type) {
        if (StringUtils.isNotBlank(type) && value != null) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict;
                }
            }
        }
        return new Dict();
    }

    public static String getDictLabel(Integer value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && value != null) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    public static String getDescription(Integer value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && value != null) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getDescription();
                }
            }
        }
        return defaultValue;
    }

    public static String getDictLabels(String values, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")) {
                valueList.add(getDictLabel(Integer.parseInt(value), type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    public static Integer getDictValue(String label, String type, Integer defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (Dict dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    public static List<Dict> getDictList(String type, String remarks) {

        List<Dict> dictList = getDictList(type);
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }

        List<Dict> list = Lists.newArrayList();
        if (StringUtils.isNotBlank(remarks)) {
            for (Dict dict : dictList) {
                if (dict.getDescription().indexOf(remarks) >= 0) {
                    list.add(dict);
                }
            }
        }

        return list;
    }

    public static List<Dict> getContractDictList(String type, String remarks) {

        List<Dict> dictList = getDictList(type);
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }

        List<Dict> list = Lists.newArrayList();
        if (StringUtils.isNotBlank(remarks)) {
            for (Dict dict : dictList) {
                if (dict.getDescription().equals(remarks)) {
                    list.add(dict);
                }
            }
        }

        return list;
    }

    /*public static List<Dict> getDictListAndFilter(String type, String filterStr) {
        String[] ss = filterStr.split("#");
        List<Dict> tmpdicts = getDictList(type);
        if (tmpdicts == null) {
            return tmpdicts;
        }
        List<Dict> result = Lists.newArrayList();
        for (Dict dict : tmpdicts) {
            if (ArrayUtils.contains(ss, dict.getValue())) {
                continue;
            }
            result.add(dict);
        }
        return result;
    }*/

    public static List<Dict> getDictListByValues(String type, String values) {
        String[] split = values.split(",");
        List<Dict> tmpdicts = getDictList(type);
        if (tmpdicts == null || split == null) {
            return tmpdicts;
        }

        List<Dict> result = Lists.newArrayList();
        for (Dict dict : tmpdicts) {
            if (ArrayUtils.contains(split, dict.getValue())) {
                result.add(dict);
            }
        }
        return result;
    }

    public static Map<String, Dict> getDictLabelMapByValues(String type, String values) {
        Map<String, Dict> map = new HashMap<>();
        List<Dict> list = getDictListByValues(type, values);
        if (list != null && list.size() > 0) {
            for (Dict d : list) {
                map.put(d.getLabel(), d);
            }
        }
        return map;
    }

    /**
     * 检测字典值是否在此字典的可用范围内
     *
     * @param value
     * @param type
     * @return
     */
    public static boolean checkAvailable(Integer value, String type) {
        if (value == null || StringUtils.isBlank(type)) {
            return false;
        }
        List<Dict> list = getDictList(type);
        if (list == null || list.size() == 0) {
            return false;
        }
        for (Dict d : list) {
            if (d.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getDictLabelList(String type) {
        List<Dict> dictList = getDictList(type);

        List<String> labelList = Lists.newArrayList();
        for (Dict dict : dictList) {
            labelList.add(dict.getLabel());
        }
        return labelList;
    }

    /*public static List<List<Dict>> getDictListStartWith(String type) {
        List<List<Dict>> result = Lists.newArrayList();
        if (StringUtils.isBlank(type)) {
            return result;
        }
        Dict typeQuery = new Dict();
        typeQuery.setType(type);
        List<String> typeList = dictService.findTypeListStartWith(typeQuery);
        if (typeList == null || typeList.isEmpty()) {
            return result;
        }
        for (String typeR : typeList) {
            result.add(getDictList(typeR));
        }
        return result;
    }*/

    /*public static List<String> getDictRemarksStartWith(String value,String type) {
        List<String> result = Lists.newArrayList();
        if (StringUtils.isBlank(type)) {
            return result;
        }
        List<Dict> dictList = getDictList(type);
        for(Dict dict : dictList){
            if(dict.getValue().startsWith(value)){
                result.add(dict.getRemarks());
            }
        }
        return result;
    }*/

    public static List<Dict> getDictListAndRemove(String type,String values){
        String[] split = values.split(",");
        List<Dict> tmpdicts = getDictList(type);
        if(tmpdicts == null || split == null){
            return tmpdicts;
        }

        List<Dict> result = Lists.newArrayList();
        for (Dict dict:tmpdicts){
            if(ArrayUtils.contains(split, dict.getValue())){
                continue;
            }
            result.add(dict);
        }
        return result;
    }

	public static List<Integer> getDictValueList(String type){
		List<Dict> dictList = getDictList(type);
		List<Integer> valueList = Lists.newArrayList();
		for (Dict dict: dictList) {
			valueList.add(dict.getValue());
		}
		return valueList;
	}
}
