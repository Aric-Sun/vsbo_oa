package com.github.aricSun.vsbo_oa.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author AricSun
 * @date 2021.01.11 17:34
 */
public class SessionUtils {
    public static Integer getEId(HttpSession session){
        if (session != null){
            // 获取当前用户id
            HashMap empMap = (HashMap) session.getAttribute("map");
            return (Integer) empMap.get("eId");
        } else {
            return null;
        }
    }
}
