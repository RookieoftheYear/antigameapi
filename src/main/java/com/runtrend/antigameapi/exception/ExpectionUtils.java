package com.runtrend.antigameapi.exception;

import com.runtrend.antigameapi.pojo.RegisterReply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

/**
 * @author GanZY
 * @Title: ExpectionUtils
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2622:39
 */
@Slf4j
public class ExpectionUtils {

    public static RegisterReply Catch(BindingResult bindingResult){

        RegisterReply registerReply = new RegisterReply();
        return Optional.of(bindingResult.hasErrors())
                .filter(x -> x)
                .map(x -> {
                    FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
                    registerReply.setReturnCode("0").setReturnMsg(error.getDefaultMessage());
//                    result.put("returnCode", "0");
//                    result.put("returnMsg", error.getDefaultMessage());
                    log.info("=== API Error : {} ===", error.getDefaultMessage());
                    return registerReply;
                })
                .orElse(null);
//        if (bindingResult.hasErrors()){
//            FieldError error = (FieldError) bindingResult.getAllErrors().get(0);
//            result.put("returnCode","0");
//            result.put("returnMsg",error.getDefaultMessage());
//            log.debug("");
//            return result;
//        }
    }
}
