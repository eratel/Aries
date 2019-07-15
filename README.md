# ERatel Aries
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/ABHSY/Aries)
[![Maven Central](https://img.shields.io/maven-central/v/com.nepxion/discovery.svg?label=maven%20central)](https://github.com/ABHSY/Aries)
[![Javadocs](http://www.javadoc.io/badge/com.nepxion/discovery-plugin-framework.svg)](https://github.com/ABHSY/Aries)
[![Build Status](https://travis-ci.org/Nepxion/Discovery.svg?branch=master)](https://github.com/ABHSY/Aries)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8e39a24e1be740c58b83fb81763ba317)](https://github.com/ABHSY/Aries)

Aries 是一款超轻量级灰度框架，针对现有的SpringCloud微服务部署痛点，解决多部署问题。可以让你在机器中单独启动一个服务，解决本机调试使用启动多个服务的痛苦。

## 解决的痛点
- 作为一个开发人员，当你准备修复一个bug时，或者开发时。需要启动多个服务进行开发，前端联调服务巨卡。导致联调效率低下。
- 作为一个运维人员，测试环境被无意的注册，测试无法正常工作。
- 作为一个测试人员，希望可以实现金丝雀测试，完成单个功能点测试，一个循序渐进过程。


## 功能简介
- Aries是在 Spring Cloud框架基础上，实现的微服务金丝雀发布框架。兼容 Spring Cloud Gateway和Zuul，下面说一下他的功能特性
  - 具有极大的灵活性 - 易于在Aries进行二次开发
  - 具有极简的易用性 - 只需要引入相关的包同时规则里含有了对应的配置，该功能将自然启动

## 快速开始
- 使用postMan进行测试 网关使用SpringCloud Zuul 直接在pom文件中依赖
- SpringRequest Header 中传入参数为 strategyVersion = xxx 为你定义的版本号
```xml
        <dependency>
            <groupId>com.github.eratel</groupId>
            <artifactId>aries-zuul</artifactId>
            <version>1.0</version>
        </dependency>
```
- Server 服务直接依赖 直接在pom文件中依赖
```xml
        <dependency>
            <groupId>com.github.eratel</groupId>
            <artifactId>aries-start-server</artifactId>
            <version>1.0</version>
        </dependency>

```
- Server 配置Eureka元数据  strategyVersion 为你的版本号
```yaml
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
    metadata-map:
     strategyVersion: xxx
```
- 至此配置已经完成

## 测试阶段
![Alt text](https://github.com/ABHSY/Aries/blob/master/doc/2.jpg)


## MVN 中央仓库 jar包查找
![Alt text](https://github.com/ABHSY/Aries/blob/master/doc/3.jpg)


## 架构图
![Alt text](https://github.com/ABHSY/Aries/blob/master/doc/doc.jpg)


## 规则示例
- 下载源码查看及简示例
  - aries-example-eureka
  - aries-example-server
  - aries-example-zuul


## 使用方式

- :warning:特别注意：网关与普通server引入jar不是同一个jar。需要进行区别~
- :warning:特别注意：已经放入到MVN中央仓库  搜索com.github.eratel
```xml
        <dependency>
            <groupId>com.github.eratel</groupId>
            <artifactId>aries-zuul</artifactId>
            <version>1.0.0</version>
        </dependency>
```

```xml
        <dependency>
            <groupId>com.github.eratel</groupId>
            <artifactId>aries-start-server</artifactId>
            <version>1.0.0</version>
        </dependency>

```
## 关于开源
- LICENSE 使用  Apache License Version 2.0, January 2004  
- 二次开发，或开发新需求，拓展，请联系作者。在本开源基础上进行开发，烦请告知。

## 关于我 
### 更多消息请关注我的公众号 OR 添加我的微信发送暗号+群就可拉入微信群
![Alt text](https://github.com/ABHSY/Aries/blob/master/doc/1.jpg)
![Alt text](https://github.com/ABHSY/Aries/blob/master/doc/4.jpg)