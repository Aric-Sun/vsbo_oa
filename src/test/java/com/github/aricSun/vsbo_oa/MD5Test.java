package com.github.aricSun.vsbo_oa;

import com.github.aricSun.vsbo_oa.utils.MD5Util;
import org.junit.Test;

/**
 * @author AricSun
 * @date 2021.01.07 10:27
 */
public class MD5Test {

    @Test
    public void testMD5(){
        System.out.println(MD5Util.md5("111111"));
    }
}
