package com.runtrend.antigameapi.exception;

import lombok.Data;

/**
 * @author GanZY
 * @Title: MyException
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2620:11
 */

@Data
public class MyException extends RuntimeException {

    private String code;  //异常状态码

    private String message;  //异常信息

    private String method;   //发生的方法，位置等

    private String descinfo;   //描述

}
