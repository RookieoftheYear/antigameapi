package com.runtrend.antigameapi.dao;

import com.runtrend.antigameapi.pojo.SubscribeBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CuccRegisterMapper {
    @Delete({
            "delete from cucc_register",
            "where ad = #{ad,jdbcType=VARCHAR}"
    })
    void deleteByPrimaryKey(String ad);

    @Insert({
            "insert into cucc_register (ad, mac, ",
            "contactman, contactphone, ",
            "mphone, seqid, ponmodel)",
            "values (#{ad,jdbcType=VARCHAR}, #{mac,jdbcType=VARCHAR}, ",
            "#{contactman,jdbcType=VARCHAR}, #{contactphone,jdbcType=VARCHAR}, ",
            "#{mphone,jdbcType=VARCHAR}, #{seqid,jdbcType=VARCHAR}, #{ponmodel,jdbcType=VARCHAR})"
    })
    void insert(SubscribeBean record);

    @Select("select count(*) from cucc_register where ad = #{ad}")
    int countByMac(String ad);


    @Select("select mphone from cucc_register where ad = #{ad}")
    String getMphone(String ad);
}