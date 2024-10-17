package com.wxf.sky.service;

import com.wxf.sky.entity.IdGenerator;
import com.wxf.sky.entity.Segment;
import com.wxf.sky.repository.IdGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class IdGeneratorService {

    @Autowired
    private IdGeneratorRepository idGeneratorRepository;

    // 获取下一个号段
    @Transactional
    public Segment getNextSegment(String bizTag) {
        // 根据业务标识查找记录
        IdGenerator idGenerator = idGeneratorRepository.findByBizTag(bizTag);

        if (idGenerator == null) {
            // 如果是新业务线，初始化记录
            idGenerator = new IdGenerator(bizTag, 0L, 100); // 初始max_id为0, step为100
        }

        // 获取当前的max_id，并分配号段
        long currentMaxId = idGenerator.getMaxId();
        long newMaxId = currentMaxId + idGenerator.getStep();

        // 更新数据库中的最大ID
        idGenerator.setMaxId(newMaxId);
        idGeneratorRepository.save(idGenerator);

        // 返回号段
        return new Segment(currentMaxId + 1, newMaxId);
    }
}
