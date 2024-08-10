package com.wxf.sky.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Wxf
 * @since 2024-08-10 16:38:13
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {


    private String username;

    private Integer age;
}
