> by Yuanwl

## 一、定义listener、filter、servlet

一般都有两种定义方式，我只说其中最简单的那种——用注解的定义方式，另一种方式自己百度。

1. 在 [XxxApplication](src/main/java/xyz/yuanwl/Application.java) 加上 @ServletComponentScan ；
2. 分别用注解 @WebListener、@WebFilter、@WebServlet 定义 [listener、filter、servlet](src/main/java/xyz/yuanwl/web) ；

至此，就定义好了。


## 二、定义拦截器

按以下步骤即可：

1. 定义拦截器：[TestInterceptor](src/main/java/xyz/yuanwl/web/TestInterceptor.java)（可以定义多个）；
2. 把拦截器加入到MVC环境：[MvcConfig](src/main/java/xyz/yuanwl/web/MvcConfig.java)；

至此，看似拦截器已经定义完了。然而，启动项目，进入 http://localhost:8080 可以被拦截，但是进入 http://localhost:8080/servlet 却没有被拦截——我们不是配置了拦截 /** ——拦截全部链接吗？

其实是因为，拦截器是mvc的组件，而mvc是基于 dispatcherServlet 实现的——请求都进入到 /servlet 了，自然就不会进入 dispatcherServlet ，也就不会进入拦截器！

那为什么不会进入dispatcherServlet呢？这和路径匹配有关。下面就复习一下servlet路径匹配相关内容，你就知道是怎么回事了。

在传统web.xml里，定义servlet是这样的：
```xml
<servlet>
    <servlet-name>TestServlet1</servlet-name>
    <servlet-class>xyz.yuanwl.ServletDemo1</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>TestServlet1</servlet-name>
    <url-pattern>/abc/*</url-pattern>
</servlet-mapping>
```

在springboot里定义其实也大同小异。我们关注的是 <url-pattern>/servlet/Servlet1</url-pattern> 这个东西——假如再定义多个servlet，最后是这样的：

- TestServlet1 映射到 /abc/* ——这叫目录匹配：以 / 开始，以 /* 结尾
- TestServlet2 映射到 /* ——这也是目录匹配，匹配根目录
- TestServlet3 映射到 /abc ——这叫完全路径匹配：以 / 开始，非 / 结尾，不带通配符 *
- TestServlet4 映射到 *.do ——这叫扩展名匹配：不能以 / 开始，必须以 * 开始

当前端发送请求到后台时，会进入哪个servlet呢？

- 当请求URL为“/abc/a.html”，“/abc/*”和“/*” 似乎都匹配，哪个servlet响应？Servlet引擎将调用TestServlet1；
- 当请求URL为“/abc”时，“/abc/*”和“/abc” 似乎都匹配，哪个servlet响应？Servlet引擎将调用TestServlet3；
- 当请求URL为“/abc/a.do”时，“/abc/*”和“*.do” 似乎都匹配，哪个servlet响应？Servlet引擎将调用TestServlet1；
- 当请求URL为“/a.do”时，“/*”和“*.do” 似乎都匹配，哪个servlet响应？Servlet引擎将调用TestServlet2；
- 当请求URL为“/xxx/yyy/a.do”时，“/*”和“*.do” 似乎都匹配，哪个servlet响应？Servlet引擎将调用TestServlet2；

（项目里已经定义好这些servlet，你可以试试。**注意：dispatcherServlet的路径和TestServlet2一样都是/*，因为后者后加载，所以会把dispatcherServlet覆盖，会导致mvc相关的功能都不可用，所以默认都是把TestServlet2注释掉的，测试这个匹配规则时再打开**）

从上面不难总结出规律：

- 匹配优先级：完全路径匹配 > 目录匹配 > 扩展名匹配；
- 谁长得更像就匹配谁；

至此，你应该知道为什么一开始访问servlet时无法进入拦截器了吧？

不过，也不用想太多，一般情况下，我们很少会在mvc的环境下再定义servlet——都用Controller了，还用这原始的玩意干哈？定义多个dispatcherServlet的情况倒是有，但那也是一个dispatcherServlet就一个mvc系统，每个mvc系统都有自己的拦截器，你的拦截器当然不能拦截别人的请求了，对吧！


## 三、资源路径修改

看 [MvcConfig](src/main/java/xyz/yuanwl/web/MvcConfig.java) 里的 addResourceHandlers 方法。