package com.wxf.sky.flink;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.io.FileInputFormat;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.io.IOException;
import java.time.Duration;

/**
 * @author Wxf
 * @since 2024-09-25 10:10:52
 **/
public class WaterMarkMain {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);


        DataStreamSource<String> source = env.readFile(new FileInputFormat<String>() {
            @Override
            public boolean reachedEnd() throws IOException {

                return true;
            }

            @Override
            public String nextRecord(String s) throws IOException {
                return "";
            }
        }, null);

        source.assignTimestampsAndWatermarks(WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(20)));
    }
}
