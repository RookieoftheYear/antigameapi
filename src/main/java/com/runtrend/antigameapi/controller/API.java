package com.runtrend.antigameapi.controller;

import com.runtrend.antigameapi.exception.ExpectionUtils;
import com.runtrend.antigameapi.pojo.RegisterReply;
import com.runtrend.antigameapi.pojo.SubscribeBean;
import com.runtrend.antigameapi.pojo.UnsubscribeBean;
import com.runtrend.antigameapi.service.APIService;
import com.runtrend.antigameapi.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author GanZY
 * @Title: API
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2611:25
 */

@RestController
@Slf4j
@RequiredArgsConstructor
public class API {
    private final APIService apiService;
    private final SendMessageService sendMessageService;
    @RequestMapping("/subscribeAction")
    public RegisterReply subscribe(@Valid SubscribeBean bean, BindingResult bindingResult) {

        return Optional.ofNullable(ExpectionUtils.Catch(bindingResult))
                .orElseGet(() -> apiService.subscribe(bean));

    }
    @RequestMapping("/unsubscribeAction")
    public RegisterReply unSubscribe(@Valid UnsubscribeBean bean, BindingResult bindingResult) {
        List<String> phoneList = sendMessageService.listPhone(bean.getAd());
        RegisterReply registerReply = Optional.ofNullable(ExpectionUtils.Catch(bindingResult))
                .orElseGet(() -> apiService.unsubscribe(bean));
        Optional.of(registerReply.getReturnCode())
                .filter("0"::equals)
                .orElseGet(() ->{
                    sendMessageService.sendMessage(phoneList, bean.getAd());
                    return "";
                });

        return registerReply;
    }

    public static void main(String[] args) {
    }

}
