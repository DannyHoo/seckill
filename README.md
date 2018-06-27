# 秒杀场景模拟项目(自学用途)

1、maven项目结构搭建

2、集成SpringDataJPA；集成MyBatis

3、集成Spring；配置Spring事务：声明式事务、编程式事务（service层封装framework-service）；

4、集成日志框架Logback；AOP管理日志(framework-log)

5、集成缓存（framework-cache）

6、集成消息队列(framework-mq)

7、支持分布式锁（service层封装framework-service）


# 项目启动参数整理

1、【配置文件】项目启动环境

```-DenvType=dev/test/online ```

2、【日志】是否在控制台打印日志，默认false
  
```-DisOpenSystemOutLog=true/false ```

3、【获取分布式锁】部署方式是单机还是集群，默认standalone

```-DdeployType=standalone/cluster ```

