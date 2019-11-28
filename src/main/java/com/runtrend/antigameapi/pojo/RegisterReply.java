package com.runtrend.antigameapi.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author GanZY
 * @Title: RegisterReply
 * @ProjectName antigameapi
 * @Description: TODO
 * @date 2019/11/2611:33
 */
@Data
@Accessors(chain = true)
public class RegisterReply {
    String returnCode;
    String returnMsg;
}
