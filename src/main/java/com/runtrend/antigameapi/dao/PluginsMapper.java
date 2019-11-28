package com.runtrend.antigameapi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author GanZY
 * @Title: PluginsMapper
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2714:31
 */
@Repository
@Mapper
public interface PluginsMapper {
    @Delete({"delete from t_plugins where ad_account= #{ad}"}
    )
    void delete(String ad);
}
