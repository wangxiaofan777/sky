package com.wxf.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdGenerator {
    @Id
    private String bizTag;
    private long maxId;
    private int step;

    // Constructors, Getters, Setters...
}