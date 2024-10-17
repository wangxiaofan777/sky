CREATE TABLE id_generator (
                              biz_tag VARCHAR(64) NOT NULL PRIMARY KEY, -- 业务标识
                              max_id BIGINT NOT NULL,                   -- 当前最大ID
                              step INT NOT NULL,                        -- 号段大小
                              update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
