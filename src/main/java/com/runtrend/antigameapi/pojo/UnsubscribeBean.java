package com.runtrend.antigameapi.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author GanZY
 * @Title: UnsubscribeBean
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2622:22
 */
@Data
public class UnsubscribeBean {
    @NotBlank(message = "ad is empty...")
    String ad;
    String seqid;
}
