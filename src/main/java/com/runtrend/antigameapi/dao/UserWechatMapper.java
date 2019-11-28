package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author GanZY
 * @Title: UserWechat
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2714:34
 */
@Mapper
@Repository
public interface UserWechatMapper {

    @Delete({"delete from t_user_wechat where openid= #{openID}"})
    void delete(String openID);
}
