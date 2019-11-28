package com.runtrend.antigameapi.service.impl;

import com.runtrend.antigameapi.dao.CuccRegisterMapper;
import com.runtrend.antigameapi.pojo.SubscribeBean;
import com.runtrend.antigameapi.service.CuccRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author GanZY
 * @Title: CuccRegisterServiceImpl
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2619:30
 */
@Service
@RequiredArgsConstructor
public class CuccRegisterServiceImpl implements CuccRegisterService {

    private final CuccRegisterMapper cuccRegisterMapper;

    @Override
    public void add(SubscribeBean subscribeBean) {
        cuccRegisterMapper.insert(subscribeBean);

    }

    @Override
    public boolean check(String ad) {
        return Optional.of(cuccRegisterMapper.countByMac(ad))
                .filter(x -> x > 0).isPresent();
    }

    @Override
    public void delete(String ad) {

        cuccRegisterMapper.deleteByPrimaryKey(ad);

    }

    @Override
    public String getPhone(String ad) {
        return cuccRegisterMapper.getMphone(ad);
    }
}
