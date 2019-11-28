package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GanZY
 * @Title: UserAdMapper
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2714:40
 */
@Repository
@Mapper
public interface UserAdMapper {

    @Delete({"delete from t_user_ad where master_phone=#{masterPhone}"})
    void delete(String masterPhone);

    @Select({"select mobile from t_user_ad where master_phone = #{phone}"})
    List<String> selecttUserPhoneNums(@Param("phone") String phone);
}
