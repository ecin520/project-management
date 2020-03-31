package com.pytap.project.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ecin520
 * @date 2020/3/26 23:00
 */
public class JsonUtil {

    public static JSONObject backInfo(Integer code, String info) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", info);
        return jsonObject;
    }

    public static JSONObject success() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("message", "操作成功");
        return jsonObject;
    }

    public static JSONObject fail() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 400);
        jsonObject.put("message", "操作失败");
        return jsonObject;
    }

}
