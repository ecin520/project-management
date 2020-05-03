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
        jsonObject.put("code", 403);
        jsonObject.put("message", "操作失败");
        return jsonObject;
    }

    /**
     * 登陆成功返回Json
     * */
    public static JSONObject loginSuccess(Integer code, String info, Object user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("token", info);
        jsonObject.put("user", user);
        return jsonObject;
    }

    /**
     * 返回对象
     * */
    public static JSONObject backObject(Integer code, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("content", object);
        return jsonObject;
    }

}
