package com.wxf.sky.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户 Model
 *
 * @author Wxf
 * @since 2024-07-28 19:49:35
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String username;

    private Integer age;

    private Integer gender;

    private String remark;


}
