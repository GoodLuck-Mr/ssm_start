package com.ssm.utils;

import java.util.UUID;

/**
 * @projectName: mrzhao_ssm
 * @className : UuidUtils
 * 类 的 描 述  ：id转换工具类 ！
 **/
public class UuidUtils {
    public static String creatUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
