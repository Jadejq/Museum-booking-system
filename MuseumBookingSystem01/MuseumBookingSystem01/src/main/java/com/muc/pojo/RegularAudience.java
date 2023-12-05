package com.muc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegularAudience {
    private String docType;//证件类型
    private String id;//证件号
    private String name;//姓名
    private String phone;//用户手机号
    private String regularAudienceNo;//常用观众唯一编号
}
