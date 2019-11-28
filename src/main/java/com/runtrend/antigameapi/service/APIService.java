package com.runtrend.antigameapi.service;

import com.runtrend.antigameapi.pojo.RegisterReply;
import com.runtrend.antigameapi.pojo.SubscribeBean;
import com.runtrend.antigameapi.pojo.UnsubscribeBean;

/**
 * @author GanZY
 * @Title: RegisterService
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2611:35
 */
public interface APIService {

    RegisterReply subscribe(SubscribeBean subscribeBean);

    RegisterReply unsubscribe(UnsubscribeBean unsubscribeBean);
//    void insert(RegisterBean registerBean);
}
