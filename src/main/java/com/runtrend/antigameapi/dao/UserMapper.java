package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author GanZY
 * @Title: UserMapper
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2714:38
 */
@Mapper
@Repository
public interface UserMapper {



    @Delete({"delete from t_user where id = #{id}"})
    void delete(String id);

    @Select({"select id from t_user where username = #{userName}"})
    String getID(String userName);

    @Select({"select remark1 from t_user where username = #{userName}"})
    String getRemark(String userName);
}
