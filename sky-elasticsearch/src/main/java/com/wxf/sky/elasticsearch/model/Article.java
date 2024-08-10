package com.wxf.sky.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

/**
 * @author Wxf
 * @since 2024-08-10 16:49:03
 **/
@Document(indexName = "article")
public class Article {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Keyword)
    private String category;

    @Field(type = FieldType.Integer)
    private Integer count;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Date)
    private LocalDateTime createTime;
}
