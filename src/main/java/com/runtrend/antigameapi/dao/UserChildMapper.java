package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author GanZY
 * @Title: UserChild
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2714:33
 */
@Repository
@Mapper
public interface UserChildMapper {

    @Delete({"delete from t_user_child where userid = #{userID}"})
    void delete(String userID);

}
