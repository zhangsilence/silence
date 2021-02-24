#启动文件配置信息，Nacos动态配置不可用时启用。
server:
  port: 8090
  max-http-header-size: 2097152
spring:
  application:
    name: SpringCloudAlibaba-Sentinel-Test
  profiles:
    active: dev 
  cloud:
#nacos 注册信息配置和动态配置  
    nacos:
      discovery:
        server-addr: localhost:8848
      config:
        server-addr: ${spring.cloud.nacos.discovery.server-addr}
        file-extension: yaml
        group: DEFAULT_GROUP
        enabled: true
#sentinel 注册信息配置和动态规则获取配置    
    sentinel:
      transport:
        dashboard: localhost:8080
        port: 8099
      datasource:
        ds2:
          nacos:
            server-addr: ${spring.cloud.nacos.discovery.server-addr}
            dataId: ${spring.application.name}
            groupId: DEFAULT_GROUP
            data-type: json
            rule-type: flow
#数据库链接
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/lemon?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
    username: root
    password: 123456
    driverClassName: com.mysql.cj.jdbc.Driver
#mybatis:
  mapper-locations: classpath*:/mapper/**.xml
restTemplate:
  readTimeout: 5000
  connectTimeout: 5000

