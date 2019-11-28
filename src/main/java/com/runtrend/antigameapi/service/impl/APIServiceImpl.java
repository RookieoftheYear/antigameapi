package com.runtrend.antigameapi.service.impl;

import com.runtrend.antigameapi.dao.*;
import com.runtrend.antigameapi.pojo.Huawei;
import com.runtrend.antigameapi.pojo.RegisterReply;
import com.runtrend.antigameapi.pojo.SubscribeBean;
import com.runtrend.antigameapi.pojo.UnsubscribeBean;
import com.runtrend.antigameapi.service.APIService;
import com.runtrend.antigameapi.service.CuccRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author GanZY
 * @Title: RegisterServiceImpl
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2617:37
 */
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class APIServiceImpl implements APIService {

    private final CuccRegisterService cuccRegisterService;
    private final UserAcountMapper userAcountMapper;
    private final BusinessMapper businessMapper;
    private final PluginsMapper pluginsMapper;
    private final UserAdMapper userAdMapper;
    private final UserChildMapper userChildMapper;
    private final UserMapper userMapper;
    private final UserWechatMapper userWechatMapper;

    @Override

    public RegisterReply subscribe(SubscribeBean subscribeBean) {
        RegisterReply registerReply = new RegisterReply();
        String ponmodel = subscribeBean.getPonmodel();
        String ad = subscribeBean.getAd();
        String mac = Optional.of(subscribeBean.getMac())
                .filter(x -> !EnumUtils.isValidEnum(Huawei.class, ponmodel) && x.endsWith("0"))
                .orElseGet(() -> subscribeBean.getMac().substring(0, subscribeBean.getMac().length() - 1) + "C");

        Optional.of(cuccRegisterService.check(ad))
                .filter(x -> !x)
                .map(y -> {
                    cuccRegisterService.add(subscribeBean);
                    userAcountMapper.insert(subscribeBean.getMphone(), ad, mac);
                    registerReply.setReturnCode("1").setReturnMsg("业务办理成功");
                    return registerReply;
                })
                .orElseGet(() -> {
                    registerReply.setReturnCode("0").setReturnMsg("已办理过业务");
                    return registerReply;

                });


        businessMapper.insert("注册", subscribeBean.toString(), registerReply.toString(), DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        log.info("=== {} 订购办理业务：{} ====", ad, registerReply.getReturnMsg());
        return registerReply;
    }

    @Override
    public RegisterReply unsubscribe(UnsubscribeBean unsubscribeBean) {
        RegisterReply registerReply = new RegisterReply();
        String ad = unsubscribeBean.getAd();
        Optional.of(cuccRegisterService.check(ad))
                .filter(x -> !x)
                .map(y -> {
                    registerReply.setReturnCode("0").setReturnMsg("未办理业务");
                    return registerReply;
                })
                .orElseGet(() -> {
                    String phone = cuccRegisterService.getPhone(ad);
                    String id = userMapper.getID(phone);
                    String remark = userMapper.getRemark(phone);
                    pluginsMapper.delete(ad);
                    userChildMapper.delete(id);
                    userMapper.delete(id);
                    userAcountMapper.deleteByAd(ad);
                    userAdMapper.delete(phone);
                    userWechatMapper.delete(remark);
                    cuccRegisterService.delete(ad);
                    registerReply.setReturnCode("1").setReturnMsg("业务退订成功");
                    return registerReply;

                });

        businessMapper
                .insert("注销", unsubscribeBean.toString(), registerReply.toString(), DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        log.info("=== {} 退订办理业务：{} ====", ad, registerReply.getReturnMsg());
        return registerReply;
    }

    public static void main(String[] args) {
        SubscribeBean subscribeBean = new SubscribeBean();
        subscribeBean.setPonmodel("HG6543C1");
        String ponmodel = subscribeBean.getPonmodel();
        subscribeBean.setMac("dwadwadw0");
        String mac = Optional.of(subscribeBean.getMac())
                .filter(x -> !EnumUtils.isValidEnum(Huawei.class, ponmodel) && x.endsWith("0"))
                .orElseGet(() -> subscribeBean.getMac().substring(0, subscribeBean.getMac().length() - 1) + "C");
        System.out.println(mac);

        String data = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
//        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(data);
        RuntimeException exception = new RuntimeException();
        Throwable cause = exception.getCause();
        System.out.println(exception.getClass().toString());
    }

}
