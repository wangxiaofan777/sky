package com.wxf.sky.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.wxf.sky.elasticsearch.model.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wxf
 * @since 2024-08-10 15:31:53
 **/
@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void createIndex() throws IOException {
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(new CreateIndexRequest("test"), RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    @Test
    void checkIndex() throws IOException {
        boolean existsed = restHighLevelClient.indices().exists(new GetIndexRequest("test"), RequestOptions.DEFAULT);
        System.out.println(existsed);
    }

    @Test
    void deleteIndex() throws IOException {
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(new DeleteIndexRequest("test"), RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse);
    }


    @Test
    public void bulkTest() throws IOException {
        BulkRequest request = new BulkRequest();

        List<User> list = new ArrayList<>();
        list.add(new User("大一", 18));
        list.add(new User("大二", 19));
        list.add(new User("大三", 17));
        list.add(new User("大四", 11));
        list.add(new User("大五", 12));
        list.add(new User("大六", 13));
        list.add(new User("大七", 14));
        list.add(new User("大八", 15));
        list.add(new User("大九", 16));

        // 不设置id就会随机生成
        // 批处理请求
        for (int i = 0; i < list.size(); i++) {
            // 批量更新、删除也在这里操作
            request.add(new IndexRequest("test4")
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.status());
    }


    @Test
    void scroll() throws IOException {
        Scroll scroll = new Scroll(TimeValue.timeValueSeconds(60));

        SearchRequest searchRequest = new SearchRequest("test4");
        searchRequest.scroll(scroll);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query();
        sourceBuilder.from(0);
        sourceBuilder.size(1);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 游标
        String scrollId = searchResponse.getScrollId();

        SearchHit[] searchHits = searchResponse.getHits().getHits();

        while (searchHits != null && searchHits.length > 0) {
            for (SearchHit searchHit : searchHits) {
                System.out.println(searchHit.getSourceAsString());
            }

            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
            scrollRequest.scroll(scroll);
            SearchResponse response = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
            // 刷新ID
            scrollId = response.getScrollId();
            searchHits = response.getHits().getHits();
            System.out.println(searchHits.length);
        }


    }


    @Test
    void aggTest() throws IOException {
        SearchRequest searchRequest = new SearchRequest("test4");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.aggregation(AggregationBuilders.max("max_age").field("age"));
        searchSourceBuilder.aggregation(AggregationBuilders.min("min_age").field("age"));
        searchSourceBuilder.aggregation(AggregationBuilders.sum("sum_age").field("age"));

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        Aggregation maxAge = searchResponse.getAggregations().get("max_age");
        Aggregation minAge = searchResponse.getAggregations().get("min_age");
        Aggregation sumAge = searchResponse.getAggregations().get("sum_age");

        SearchHit[] searchHits = searchResponse.getHits().getHits();

        System.out.println(searchHits);
    }

}
