package com.wxf.sky.repository;

import com.wxf.sky.entity.IdGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdGeneratorRepository extends JpaRepository<IdGenerator, String> {
    IdGenerator findByBizTag(String bizTag);
}