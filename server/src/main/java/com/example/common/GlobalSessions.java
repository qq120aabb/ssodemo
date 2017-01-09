package com.example.common;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class GlobalSessions {

    //存放所有全局会话
    private static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

    public static void addSession(String sessionId, HttpSession session) {
        sessions.put(sessionId, session);
    }

    public static void delSession(String sessionId) {
        sessions.remove(sessionId);
    } //根据id得到session

    public static HttpSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

}
