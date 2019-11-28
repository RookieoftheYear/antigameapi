package com.runtrend.antigameapi.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author GanZY
 * @Title: RegisterBean
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2611:22
 */
@Data
public class SubscribeBean {


        @NotBlank(message = "fail:ad is empty...")
        String ad;
        @NotBlank(message = "fail:mac is empty...")
        String mac;
        @NotBlank(message = "fail:ponmodel is empty...")
        String ponmodel;
        @NotBlank(message = "fail:mphone is empty")
        String mphone;
        String seqid;
        String contactman;
        String contactphone;
}
