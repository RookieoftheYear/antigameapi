package com.runtrend.antigameapi.service;

import java.util.List;

/**
 * @author GanZY
 * @Title: SendMessageService
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2717:01
 */
public interface SendMessageService {

    void sendMessage(List<String> phoneList,String ad);

    List<String> listPhone(String ad);
}
