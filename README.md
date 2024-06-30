# sky

## 1. 版本

* Springboot： 2.7.18
* MySQL：8.0.30
* RockerMQ：5.2.0

## 2. 系统架构

```plantuml

```

## 3. 启动服务

```shell
docker-compose up -d
```

* 创建topic

```shell
docker exec -it rmqbroker bash
sh mqadmin updatetopic -t TestTopic -c DefaultCluster
```
## 停止服务

```shell
docker-compose down
```