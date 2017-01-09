package com.example.controller;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class UserController {


    /**
     *
     * @param token  登录token必须
     * @param returnURL 返回给用户的URL必须
     *   返回：验证成功  重定向returnURL 验证失败 重定向到认证中心登录页面
     */
    public void  authCheck(String token,String returnURL){

    }


    /**
     *
     * @param localId 本地会话ID 可选
     *         返回 1 首页  2 ”ok“字符串
     */
    public void authLogout(String localId){

    }
}
