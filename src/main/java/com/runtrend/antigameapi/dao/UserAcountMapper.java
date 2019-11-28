package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GanZY
 * @Title: UserAcountMapper
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2620:49
 */

@Mapper
@Repository
public interface UserAcountMapper {

    @Insert({"INSERT INTO t_ad_account(mobile,ad_account,mac) VALUES(#{mobile},#{ad_account},#{mac})"})
    void insert(@Param("mobile") String mobile, @Param("ad_account") String adAccount, @Param("mac") String mac);
    @Delete("DELETE FROM t_ad_account WHERE ad_account =  #{num}")
    void deleteByAd(String ad);

    @Select({"select mobile from t_ad_account WHERE mac =  #{mac}"})
    List<String> getMobileByMac(String mac);

    @Select({"select mobile from t_ad_account WHERE ad_account =  #{ad}"})
    List<String> getMobileByAd(String ad);
}
