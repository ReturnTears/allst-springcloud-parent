# SpringCloud
```text
1、分布式属性
2、服务注册中心

Eureka Server
127.0.0.1 AllstCloudEurekaServerA 对应8761
127.0.0.1 AllstCloudEurekaServerB 对应8762

Eureka Client细节
heart beat 1/30s -> 90s 失效
push

Eureka Server细节
服务下线
失效剔除 1/60s -> 90s 注销实例
自我保护
   建议生成环境打开自我保护机制

ribbon负载均衡策略
轮询策略
随机策略
重试策略
最小连接数策略
可用过滤策略
区域权衡策略

Hystrix 熔断器
雪崩效应解决方案：
  服务熔断
  服务降级
  服务限流

服务提供者处理超时，熔断，返回错误信息：
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Apr 22 23:27:50 CST 2021
There was an unexpected error (type=Internal Server Error, status=500).
findResumeOpenStateTimeOut timed-out and fallback failed.
com.netflix.hystrix.exception.HystrixRuntimeException: findResumeOpenStateTimeOut timed-out and fallback failed.

Hystrix舱壁模式
  

GateWay网关


Nacos数据模型(领域模型)
Namespace 包含  Group  包含 Service/DataId
Namespace：命名空间，对不同的环境进行隔离, 不同的命名空间是隔离的， 其中的服务不能相互调用
Group：分组
Service：某一个服务
DataId：某个项目的具体配置集文件
```

# Error
```text
查看所有端口和PID: netstat -ano
对应的端口对应的PID  输入指令找到对应的进程: tasklist | findstr pid
杀掉该进程: taskkill /f /t /im java.exe 
```

# Remark
```text
在缺少.iml文件项目下运行mvn idea:module命令，完成后将自动生成.iml文件
"spring-cloud": {
    "Finchley.M2": "Spring Boot >=2.0.0.M3 and <2.0.0.M5",
    "Finchley.M3": "Spring Boot >=2.0.0.M5 and <=2.0.0.M5",
    "Finchley.M4": "Spring Boot >=2.0.0.M6 and <=2.0.0.M6",
    "Finchley.M5": "Spring Boot >=2.0.0.M7 and <=2.0.0.M7",
    "Finchley.M6": "Spring Boot >=2.0.0.RC1 and <=2.0.0.RC1",
    "Finchley.M7": "Spring Boot >=2.0.0.RC2 and <=2.0.0.RC2",
    "Finchley.M9": "Spring Boot >=2.0.0.RELEASE and <=2.0.0.RELEASE",
    "Finchley.RC1": "Spring Boot >=2.0.1.RELEASE and <2.0.2.RELEASE",
    "Finchley.RC2": "Spring Boot >=2.0.2.RELEASE and <2.0.3.RELEASE",
    "Finchley.SR4": "Spring Boot >=2.0.3.RELEASE and <2.0.999.BUILD-SNAPSHOT",
    "Finchley.BUILD-SNAPSHOT": "Spring Boot >=2.0.999.BUILD-SNAPSHOT and <2.1.0.M3",
    "Greenwich.M1": "Spring Boot >=2.1.0.M3 and <2.1.0.RELEASE",
    "Greenwich.SR5": "Spring Boot >=2.1.0.RELEASE and <2.1.15.BUILD-SNAPSHOT",
    "Greenwich.BUILD-SNAPSHOT": "Spring Boot >=2.1.15.BUILD-SNAPSHOT and <2.2.0.M4",
    "Hoxton.SR4": "Spring Boot >=2.2.0.M4 and <2.3.1.BUILD-SNAPSHOT",
    "Hoxton.BUILD-SNAPSHOT": "Spring Boot >=2.3.1.BUILD-SNAPSHOT"
}
https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-dependencies
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-parent

```