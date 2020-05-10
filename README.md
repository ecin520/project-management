### 项目地址

管理前台ui：[https://github.com/ecin520/project-admin](https://github.com/ecin520/project-admin)

web前台：[https://github.com/ecin520/project-web](https://github.com/ecin520/project-web)

后台地址：[https://github.com/ecin520/project-management](https://github.com/ecin520/project-management)

### 简介

项目管理系统，使用现阶段主流技术SpringBoot、MyBatis、MySql、Redis等，采用Docker容器化部署。

| 技术            | 说明               |
| --------------- | ------------------ |
| SpringBoot      | 容器+MVC框架       |
| Spring Security | 权限框架           |
| MyBatis         | ORM框架            |
|MyBatisGenerator |    mybatis逆向工程，代码生成器    |
| Swagger-UI      | 文档生成器         |
| PageHelper      | 物理分页插件       |
| Redis           | 分布式缓存         |
| Docker          | 容器化部署         |
| Druid           | 数据库连接池       |
| JWT             | JWT登陆支持        |
| Lombok          | 强大的简化代码插件 |


### 项目特点
使用SpringSecurity特点和本项目紧密联系，权限控制精细到每一个接口，精细到用户的每一个操作，使用了 用户-附加权限 额外的权限关系表，在保证基本的权限控制前提下，使得权限操作更具有灵活性。

### 模块分类
![image.png](http://106.15.200.82/source/1589080189239.jpg)
###### admin
管后台模块，管理核心模块
###### common
公共模块，提供公共工具类和代码生成器生成的mapper和model
###### loggin
日志模块，使用注解代理日志，捕获所有请求及异常
###### security
SpringSecurity安全模块
###### web
web模块，提供web用户接口与操作

### web操作界面

###### 登录
![screencapturelocalhost8080login1589081179868.png](http://106.15.200.82/source/1589081220241.jpg)

###### 首页
![image.png](http://106.15.200.82/source/1589081352337.jpg)

###### 通知
![image.png](http://106.15.200.82/source/1589081614540.jpg)

###### 项目创建
![image.png](http://106.15.200.82/source/1589081711682.jpg)

###### 项目展示页面
![image.png](http://106.15.200.82/source/1589081674313.jpg)

###### 任务操作页面（项目管理员）
![image.png](http://106.15.200.82/source/1589081769785.jpg)
![image.png](http://106.15.200.82/source/1589081797408.jpg)
![image.png](http://106.15.200.82/source/1589081816908.jpg)

###### 任务审核
![051011412442_0TIM截图20200510114017.png](http://106.15.200.82/source/1589082131487.jpg)

###### 任务操作页面
![image.png](http://106.15.200.82/source/1589082188695.jpg)
![screencapturelocalhost8080taskdetail1589082205399.png](http://106.15.200.82/source/1589082229929.jpg)

###### 抽屉功能
![image.png](http://106.15.200.82/source/1589082292321.jpg)

###### 指定项目用户邀请
![image.png](http://106.15.200.82/source/1589081569015.jpg)


### 后台管理ui

###### 用户管理
![image.png](http://106.15.200.82/source/1589082369287.jpg)
![image.png](http://106.15.200.82/source/1589082406546.jpg)

###### 角色管理
![image.png](http://106.15.200.82/source/1589082436721.jpg)
![image.png](http://106.15.200.82/source/1589082452960.jpg)

###### 权限管理
![image.png](http://106.15.200.82/source/1589082476446.jpg)

###### 日志管理
![image.png](http://106.15.200.82/source/1589082517639.jpg)
![image.png](http://106.15.200.82/source/1589082555561.jpg)

###### 异常管理
![image.png](http://106.15.200.82/source/1589082574489.jpg)
![image.png](http://106.15.200.82/source/1589082610811.jpg)

###### 数据监控
![image.png](http://106.15.200.82/source/1589082627931.jpg)
