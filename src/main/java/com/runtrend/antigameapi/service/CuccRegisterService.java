package com.runtrend.antigameapi.service;

import com.runtrend.antigameapi.pojo.SubscribeBean;
import org.springframework.stereotype.Service;


@Service
public interface CuccRegisterService {


    void add(SubscribeBean subscribeBean);
    boolean check(String ad);
    void delete(String ad);

    String getPhone(String ad);
}
