# 这是鸡哥当年基于netty写的工具
> 用于实现Opay-app基于REST规范请求Hexpay的webservice服务

## 1-项目迁移
* 原项目是eclipse下的web项目
* IDEA新建Module，左侧选择Java>>勾选Web Application（注意左侧不要选择JavaEE）
* 将原文件拷贝至src下、SSL、web/lib
* 依赖1：右键lib>>add as library（或者Ctrl+Alt+Shift+S>>Dependencies页签里面添加lib类库）
* 依赖2：Ctrl+Alt+Shift+S>>Dependencies页签里面添加Tomcat类库

## 2-项目结构
* ①先将Hexpay的webservice.wsdl反解至项目路径下：tangdi.ws.service

* ②（鸡哥在演习？）Netty的标准写法：···\netty\socket
【SocketServer】启动黄牛主线程组：bossGroup，用户线程组：workerGroup
（SocketServerInitializer）鸡哥写的一个中间传递类
【SocketServerHandler】继承Netty的Handler规范，编写自己的业务

* ③处理购电请求的Netty业务：···\netty\http\NettyHttpUtils（支持SSL）
【HttpServer】------------------【SocketServer】
【HttpServerInboundHandler】----【SocketServerHandler】
【NettyHttpUtils】实现json与xml的互转等

* ④处理微信支付结果请求的Netty业务：···\netty\wechat
【WeChatServer】----------------【SocketServer】
【WeChatServerInboundHandler】--【SocketServerHandler】

* 编写psvm主类，来为Netty启动一个线程，并监听端口

## 3-使用说明书
前提：已安装jdk1.7以上版本，windows环境下已配置好java环境变量。
* 1.在netty-power.properies文件中配置中转服务和支付宝微信回调服务的端口；
* 2.windows环境下点击netty-start1.bat启动服务；
* 3.Linux环境下执行 sh startnetty-power.sh 命令启动服务，执行 sh stopnetty-power.sh 命令关闭服务。


