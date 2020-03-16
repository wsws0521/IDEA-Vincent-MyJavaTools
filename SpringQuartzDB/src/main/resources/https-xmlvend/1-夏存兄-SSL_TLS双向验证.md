## 0.Introduction

​  将 xmlvend 对外提供的明文的 WebService 改造为基于 HTTPS 的双向验证安全方案。开启 xmlvend ssl双向验证请先将 [web.xml](/Vending8.0/xmlvend/src/main/webapp/WEB-INF/web.xml) 中最后的 `<login-config>` 和 `<security-constraint>` 注释打开。

## 1. Required

​  本文档基于以下软件版本构建：

| Tomcat  | 9.0.0.M17 |
| ------- | --------- |
| Xmlvend | 1.0.1.0   |
| JDK     | 1.8.0_191 |
| SoapUI  | 5.2.1     |



## 2. Keystore and Certificates

​  由于是双向验证，要求 server 和 client 均有各自的 keystore 和 certificate。

### 2.1 Server side

​  由于服务端由 Java 编写，所以服务端的 keystore 以 jks 为例。

​  找到 jdk 安装目录下的 keytool 工具（Windows环境下为 keytool.exe）或者将%JAVA_HOME%\bin 添加到系统环境变量，执行以下命令行生成密钥对（本文档命令行均有换行符以明确每个 option 的注释，实际使用时请删除换行符和注释，***在一行中使用所有命令***）：

```bash
keytool
-genkeypair
-alias tomcat_server    //密钥对的别名，用于区分keystore中的密钥和证书
-keyalg RSA          //密钥使用的加密算法，这里示例的是经典的非对称加密算法 RSA
-keypass 123456        //私钥使用的密码，用于在keystore中访问私钥
-keystore server.jks    //指定的keystore文件名称，如果指定目录下文件不存在则会在指定目录创建新文件
-storepass store123456    //keystore的密码，用于访问keystore，出于安全考虑，要与私钥使用不同的密码
```

​  随后根据命令行要求填写组织名称/国家地区等信息。如果是新建 keystore，完成后会在当前目录下生成一个 `server.jks` 文件。

​  在拥有密钥对之后发布证书（公钥），执行以下命令行：

```bash
keytool
-exportcert
-alias tomcat_server    //密钥对别名，用于选择keystore中的密钥对，这里是上一步生成密钥时指定的
-keyalg RSA          //密钥使用的加密算法，指定生成公钥的算法
-keystore server.jks    //私钥所属的 keystore 文件
-storepass store123456    //keystore 的密码，用于访问keystore，由于是产生公钥，所以不需要私钥密码
-file server_cert.cer    //生成的证书文件名称
```



### 2.2 Client side

​  客户端由于使用的编程语言不同，可能并不是由 Java 编写的，所以客户端的 keystore 以标准的 PKCS12 为例。

​  同样可以用 jdk 自带的 keytool 工具生成 PKCS12 格式的 keystore (其他工具请参考具体官方说明)，执行以下命令生成密钥对：

```bash
keytool
-genkeypair
-alias client        //密钥对的别名，用于区分keystore中的密钥和证书
-keyalg RSA          //密钥使用的加密算法，这里示例的是经典的非对称加密算法 RSA
-storetype pkcs12      //store类型使用pkcs12，此类型的keystore只有storepass，不支持keypass
-keystore client.pfx    //指定的keystore文件名称，如果指定目录下文件不存在则会在指定目录创建新文件
-storepass store123456    //keystore的密码，用于访问keystore，出于安全考虑，要与私钥使用不同的密码
```

​  随后根据命令行要求填写组织名称/国家地区等信息。如果是新建 keystore，完成后会在当前目录下生成一个 `client.pfx` 文件。

​  同样，在拥有密钥对后发表客户端证书，执行以下命令行：

```bash
keytool
-exportcert
-alias client        //密钥对别名，用于选择keystore中的密钥对，这里是上一步生成密钥时指定的
-keyalg RSA          //密钥使用的加密算法，指定生成公钥的算法
-keystore client.pfx    //私钥所属的 keystore 文件
-storepass store123456    //keystore 的密码，用于访问keystore，由于是产生公钥，所以不需要私钥密码
-file client_cert.cer    //生成的证书文件名称
```



## 3. truststore and configuration

​  为了安全和管理方便，受信任的证书和本地的私钥需要分开存储，受信任的证书存储的密钥库就是 truststore，使用如下命令行将服务端/客户端证书导入到对应的 truststore，以服务端证书导入客户端 truststore 为例：

```bash
keytool
-importcert
-file server_cert.cer
-keystore client_truststore
```

​  以下分别以 Tomcat 和 SoapUI 为例，描述 truststore 的用法和 https 的配置。

### 3.1 Tomcat

​  在 Tomcat 目录下找到 `conf/server.xml`，打开配置文件中的 ssl connector 注释段，例如使用 http1.1协议的 nio connector implements：

```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
               maxThreads="150" SSLEnabled="true" scheme="https">
        <SSLHostConfig certificateVerification="required"     truststoreFile="conf/server_truststore" truststorePassword="trust123456">
            <Certificate certificateKeystoreFile="conf/server.jks"
                         type="RSA" certificateKeyAlias="tomcat_server" certificateKeyPassword="123456" certificateKeystorePassword="store123456"/>
        </SSLHostConfig>
</Connector>
```

​  配置完成后启动 Tomcat，由于 xmlvend 的 web.xml 已经进行过 SSL 的配置，所有 http 和 https 的访问均会被定向到 https 的端口，如果不修改配置，此端口默认为 `8443`。

### 3.2 SoapUI

​  在 Soap project 的 view 中选择 `WS-Security Configurations` 选项卡，分别添加客户端密钥对 keystore 和存储服务端证书的 truststore。

​  使用时，在具体的 request properties 中选择 ssl keystore 下拉框为本地的客户端密钥 keystore，修改 request url 为 https 协议的相应地址，然后正常使用 request 功能。



## 4. keystore 格式转换

​  keytool 提供了不同格式 keystore 的互相转换，可以使用 `-importkeystore` 命令进行格式转换，以 jks 转换到  pkcs12 为例：

```bash
keytool
-importkeystore
-srckeystore server.jks    //源keystore 文件
-srcstoretype jks      //源keystore type
-srcstorepass store123456  //源keystore 访问口令
-destkeystore server.pfx  //目标keystore 文件
-deststoretype pkcs12    //目标keystore type
-deststorepass pfx123456  //目标keystore 访问口令
```

​  然后按要求输入要转换的密钥口令即可完成转换。其他命令选项请参考 [keytool](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/keytool.html) 。
