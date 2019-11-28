package com.runtrend.antigameapi.exception;

import com.runtrend.antigameapi.pojo.RegisterReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GanZY
 * @Title: MyControllerAdvice
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2620:09
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
    //e.tostring().split(":")[0
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RegisterReply myExceptionHandler(Exception e){
        RegisterReply registerReply = new RegisterReply();
        registerReply.setReturnCode("0").setReturnMsg(e.getClass().toString());
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        log.info(" Exception: {}",e.getMessage());
        return registerReply;
    }


}
