# 安卓校园 py 项目 3组

## 简介
随着现在高校的扩招和校园信息化,网上交易的人日益增长, 。二手交易在大学校园里面越来越多，一方面，大学生热衷潮流，消费需求较旺盛，但也容易因为冲动购物而产生较多的闲置物品；另一方面，大部分大学生经济未独立，资金来源主要是依靠父母，经济能力有限。现在国家倡导可循环经济，人们的环保意识逐渐增强，加之旺盛的需求与滞后的经济能力形成的鲜明反差，为校园二手市场的发展提供了有利的环境。
该项目以大学生合理利用资源，使大学生之间二手物品交易更加便捷为目的，建立大学生二手物品交易APP平台，使大学生可以发布自己的二手物品或求购请求。

## 功能模块

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132244.png)

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132252.png)

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132300.png)



## 主要技术

1. 开发环境: Android Studio 3.4.1 JDK 1.8 Gradle 5.1.1

2. 后台环境:Idea 2019.1.3 JDK1.8 Maven2.7.7 SpringBoot 2.1.5

3. App用到的外部包: 

   - Material材质设计 :用于美化整个App

   - Banner滑动组件 : 用于主页商品展示页面

   - Glide 图片显示 : 用于请求网络图片,和展示图片

   - ButterKnife View注入框架 : 用于注入View

   - RecycleView 列表 : 用于显示商品列表

   - SearchLayout 搜索框 :用于搜索商品

   - RxHttp 网络请求: 用于实现App和后台交互 ***RxHttp要rebuild一下**

   - Gson : 解析网络获取的数据

     ![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132158.png)

4. 后台用到的技术:

   - Jpa持久层框架: 实现对数据库的增删改查

   - Lombok:注解的方式，在编译时自动为属性生成构造器、getter/setter、equals、hashcode、toString 方法

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132204.png)





## 人员分配


| 功能                | 功能                              | 人员   |
| ------------------- | --------------------------------- | ------ |
| 商品列表            | 列表                              | 吴春鹏 |
| 商品详情页          | 显示价格,图片,商品描述            | 谢函峰 |
| 用户注册登陆/启动页 | 手机验证,密码验证,                | 毛少文 |
| 我的页面            | 头像,名字,添加商品 | 刘雨航 |
| 搭建后台            |                                   | Yacny |
| 数据库建表          | 商品详情表,个人信息表,商品表,     | Yancy |



## 界面

### 登陆页

> 打开app如果没有登陆过就会跳转到登陆页进行登陆,没有账号可以进行注册

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132139.png)

### 注册页

> 注册完后就可以登陆了

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132138.png)

### 主页

> 登陆成功跳转到主页,在主页你可以选择喜欢的商品进行交易

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132159.png)

### 商品详见页

> 在这里你可以查看喜欢的商品进行交易

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132142.png)

### 搜索页

> 搜索页,你可以搜索想要的商品

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132141.png)

### 我的页面

> 可以管理我的账号,发布交易信息

![](http://pte4vw7ek.bkt.clouddn.com/img/20190624132140.png)

