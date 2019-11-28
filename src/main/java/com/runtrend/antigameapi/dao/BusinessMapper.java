package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author GanZY
 * @Title: BusinessMapper
 * @ProjectName antigame
 * @Description: TODO
 * @date 2019/9/2711:14
 */

@Repository
@Mapper
public interface BusinessMapper {

    @Insert({"INSERT into t_114_business values(#{flag},#{request},#{response},#{time})"})
    void insert(@Param("flag") String flag,
               @Param("request") String requset,
               @Param("response") String response,
               @Param("time") String time);
}
