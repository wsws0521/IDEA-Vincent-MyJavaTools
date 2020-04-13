https://blog.csdn.net/fw0124/article/details/41013333
https://my.oschina.net/u/2336787/blog/1826615
http://www.5ec8.com/seker/650.html
## 自主签发的免费证书有以下不安全的方面：（电力局，局域网，非全人类受众谁用谁添加，无在线支付环节，可以勉强使用吧？）
自签名证书不受浏览器信任，用户访问部署自签名证书的网站时会被浏览器警告并阻止访问；（需要自己将证书添加到受信任的CA颁发机构，收费的可能就不需要吧）
自签名证书可以随意签发，不受国际标准监管，你能自己签发，黑客也可以自己签发和你一样的证书用来进行中间人攻击，SSL加密的保护机制形同虚设。（服务端公钥、客户端证书被窃取）
自签名证书可能采用不安全的1024位公钥算法或SHA-1摘要算法等已经过时的标准，非常容易被破解。（那没办法了）
使用SSL证书主要是为了通过SSL加密验证机制保护数据传输安全，如果使用自签名证书完全无法起到安全保护的作用，最好是向浏览器信任的证书颁发机构沃通WoSign申请SSL证书。
付费的还可以绑多IP多域名，有效期长，客服支持到位
## CSR是什么（类似）
CSR是Certificate Signing Request的英文缩写，即证书签名请求文件，
是证书申请者在申请数字证书时由CSP(加密服务提供者)在生成私钥的同时也生成证书请求文件，
证书申请者只要把CSR文件提交给证书颁发机构后，证书颁发机构使用其根证书私钥签名就生成了证书公钥文件，也就是颁发给用户的证书。
-----BEGIN CERTIFICATE REQUEST-----
CA15R1G56ES1E5R1S51R5A5R15A1RA
C1A51E515CA15EC1E56A1C56A15C1A5
1VA6R51561B56Y1561U61TY51NN15615
-----END CERTIFICATE REQUEST-----
# 通信双方分别拥有一个[keystore]和一个[truststore]，有人图省事，把前者当成后者来用

## 1-创建server的keystore文件
生成server的公钥/私钥密钥对;
需要指定keystore的密码(storepass)和密钥对的密码(keypass)。
访问keystore需要storepass。访问密钥对需要keypass。

项目如果是IP方式访问用-ext SAN=ip:192.168.1.111，
如果是域名用 -ext SAN=dns:www.abc.com，
注意“您的名字与姓氏是什么?”就是你的IP或域名根据实际情况做必要的修改，
其中需要注意的是：服务端的密钥库参数“CN”必须与服务端的IP地址相同，否则会报错（也不一定），客户端的任意。
>>keytool -genkey     -alias tomcat_server -keyalg rsa -keysize 1024 -sigalg sha256withrsa -keypass 123456 -keystore c:\_cert\catserver.keystore -storepass 123456
>>keytool -genkeypair -alias tomcat_server -keyalg RSA -keysize 1024 -sigalg sha256withrsa -keypass 123456 -keystore c:\_cert\server.jks         -storepass 123456 -ext SAN=ip:192.168.80.37 -validity 3650 -v  -dname "CN=192.168.80.37,OU=xmlvend,O=xmlvend,L=xmlvend,ST=xmlvend,c=SA"
>>keytool -genkey     -alias tomcat_server -keyalg RSA                                     -keypass 123456 -keystore c:\_cert\server.keystore    -storepass 123456 -ext SAN=ip:192.168.80.37 -validity 3650 -v  -dname "CN=192.168.80.37,OU=xmlvend,O=xmlvend,L=xmlvend,ST=xmlvend,c=SA"
姓名：192.168.80.37(否则浏览器提示：证书错误，不匹配的地址，认为网站的安全证书是为其他网站颁发的)
组织单位：xmlvend
组织：xmlvend
城市：xmlvend
省份：xmlvend
国家代码：SA
确认：y
C:\Java\jdk1.8.0_181\bin\《server.jks》(实际名称0315_test.jks)
## 2-从server的keystore中导出server的证书（其中包括server的公钥）【cer添加到浏览器“受信任的根证书颁发机构”证书，很骚，不安全，不是必须的，奇怪的是该证书是第二天生效】
文件名《server_cert.cer》
>>keytool -export -alias tomcat_server -keystore c:\_cert\catserver.keystore   -storepass 123456 -file c:\_cert\server_cert.cer
>>keytool -export -alias tomcat_server -keystore c:\_cert\server.jks           -storepass 123456 -file c:\_cert\server_cert.cer
>>keytool -export -alias tomcat_server -keystore c:\_cert\server.keystore      -storepass 123456 -file c:\_cert\server_cert.cer

## 3-创建client的keystore文件【pfx/p12添加到浏览器“个人”证书】【注意拷贝时因为PC时差引起的证书起止时间变化，如果尚未生效则浏览器死活不会用的，soupUI和postman倒是没那么挑剔，无视未生效，直接可以用】
> 问题：【Winserver-JDK1.8.0_181替win7-JDK1.8.0_131生成keystore&cert，拷贝至win7的浏览器不认其pfx，但是soupUI&Postman是认的。
>> 反之，win7-JDK1.8.0_131生成的客户端pfx，是公认的，可以给Winserver-JDK1.8.0_181浏览器用】
>>> 后来发现原因：同一个证书文件，貌似会根据拷贝电脑的时区，自动变更起止时间。如果Client.pfx个人证书的起始时间未至，那么浏览器就是不会选择那个证书！手动修改PC时区是无效的，不知为何

同样需要指定keystore的密码和密钥对的密码。
>>keytool -genkey        -alias vincent_client   -keyalg dsa       -keysize 512 -sigalg sha1withdsa -keypass 123456                    -keystore c:\xmlvend\foxclient.keystore -storepass 123456
>>keytool -genkeypair    -alias vincent_client   -keyalg RSA       -keysize 1024 -sigalg sha256withrsa               -storetype pkcs12 -keystore c:\xmlvend\vincent.pfx        -storepass 123456 -dname "CN=vincent,OU=vincent,O=vincent,L=vincent,ST=vincent,c=SA"
>>keytool -genkeypair -v -alias vincent_client   -keyalg RSA                                        -keypass 123456  -storetype PKCS12 -keystore c:\xmlvend\vincent.p12        -storepass 123456 -dname "CN=vincent,OU=vincent,O=vincent,L=vincent,ST=vincent,c=SA" -validity 3650
姓名：vincent
组织单位：vincent
组织：vincent
城市：vincent
省份：vincent
国家代码：SA
确认：y
C:\Windows\System32\《client.pfx》
## 4-从client的keystore中导出client的证书（其中包括client的公钥）
文件名《client_cert.cer》
>>keytool -export    -alias vincent_client -keystore c:\xmlvend\foxclient.keystore            -storepass 123456      -file c:\xmlvend\foxclient.cer
>>keytool -export    -alias vincent_client -keystore C:\xmlvend\vincent.pfx                   -storepass 123456      -file C:\xmlvend\vincent_cert.cer
>>keytool -export -v -alias vincent_client -keystore C:\xmlvend\vincent.p12 -storetype PKCS12 -storepass 123456 -rfc -file C:\xmlvend\vincent_cert.cer

## 5-创建server的truststore文件并导入client的证书（其中包括client的公钥）
>>keytool -import    -alias vincent_client -keystore c:\_cert\catservertrust.keystore -storepass store123456      -file c:\_cert\clients\foxclient.cer
>>keytool -import    -alias tomcat_server  -keystore c:\_cert\server_truststore       -storepass store123456      -file c:\_cert\catserver.cer
>>keytool -import -v -alias tomcat_server  -keystore c:\_cert\server.keystore         -storepass 123456           -file c:\_cert\vincent_cert.cer 


>>keytool -importcert                      -keystore c:\_cert\server_truststore       -storepass 123456      -file C:\_cert\clients\vincent_cert.cer
>>keytool -importcert -alias tomcat_server -keystore c:\_cert\server_truststore       -storepass 123456      -file C:\_cert\clients\vincent_cert.cer
>>keytool -importcert                      -keystore c:\_cert\server.jks              -storepass 123456      -file C:\_cert\clients\vincent_cert.cer

## 6-创建client的truststore文件并导入server的证书【不是必须的，也就soupui用得到】（其中包括server的公钥）
>>keytool -import -alias tomcat_server  -keystore c:\xmlvend\foxclienttrust.keystore -storepass 123456      -file c:\xmlvend\server\catserver.cer
>>keytool -import -alias vincent_client -keystore c:\xmlvend\foxclienttrust.keystore -storepass 123456      -file c:\xmlvend\foxclient.cer
>>


>>keytool -importcert                  -keystore c:\xmlvend\client_truststore       -storepass 123456      -file c:\xmlvend\server\server_cert.cer
>>keytool -importcert                  -keystore c:\xmlvend\vincent.pfx             -storepass 123456      -file c:\xmlvend\server\server_cert.cer


## 7---查看
>>keytool -list -keystore c:\_cert\catservertrust.keystore   -storepass 123456
>>keytool -list -keystore c:\_cert\server.jks   -storepass 123456
>>keytool -list -keystore c:\_cert\server_truststore   -storepass 123456
>>keytool -list -keystore c:\xmlvend\foxclienttrust.keystore -storepass 123456
>>keytool -list -keystore c:\xmlvend\vincent.pfx  -storepass 123456
>>keytool -list -keystore c:\xmlvend\server.pfx  -storepass 123456
## 8---删除(从没删过)
>>keytool -delete -alias clientcert -keystore D:\key2\server.keystore -storepass 123456


Server:E:\tomcat.keystore----E:\tomcat.cer

Client:E:\mykey.p12----E:\mykey.cer

## 9---格式转换
keytool -importkeystore -srckeystore c:\xmlvend\client_truststore -srcstorepass 123456 -destkeystore c:\xmlvend\client_truststore.pfx -deststoretype pkcs12 -deststorepass 123456
keytool -importkeystore -srckeystore c:\_cert\server_truststore -srcstorepass 123456 -destkeystore c:\_cert\server_truststore.p12 -deststoretype pkcs12 -deststorepass 123456
keytool -importkeystore -srckeystore c:\_cert\server_truststore -srcstorepass 123456 -destkeystore c:\_cert\server_truststore.jks -deststoretype jks -deststorepass 123456
默认 alias是mykey
keytool -importkeystore -srckeystore c:\xmlvend\easypay_prod.pfx -srcstorepass 123456 -destkeystore c:\xmlvend\easypay_prod.p12 -deststoretype pkcs12 -deststorepass 123456


## Tomcat/conf/server.xml
`<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
     maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
     clientAuth="true" sslProtocol="TLS"
     keystoreFile="D:/key2/server.keystore" keystorePass="123456"
   truststoreFile="D:/key2/server.keystore" truststorePass="123456"/>`
或者
`<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
        maxThreads="150" SSLEnabled="true" scheme="https">
     <SSLHostConfig certificateVerification="required" truststoreFile="C:/_cert/server_truststore" truststorePassword="123456">
         <Certificate certificateKeystoreFile="C:/_cert/server.jks"
                      type="RSA" certificateKeyAlias="tomcat_server"
                     certificateKeyPassword="123456"
                     certificateKeystorePassword="123456" />
     </SSLHostConfig>
</Connector>`

## Tomcat/webapp/WEB-INFO，追加，强制跳转8443。（所以不跳转8443？发现是路径输错成 https:8030了）
`<login-config>
 		<auth-method>CLIENT-CERT</auth-method>
 		<realm-name>Client Cert Users-only Area</realm-name>
</login-config>
<security-constraint>
    <web-resource-collection>
        <web-resource-name>SSL</web-resource-name>
        <url-pattern>/*</url-pattern>
    </web-resource-collection>
    <user-data-constraint>
        <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
</security-constraint>`

## SoupUI
* 0、（传说soupui不认pfx，需要转成jks？并无此事，pfx一样好使）
> keytool -importkeystore -srckeystore c:\xmlvend\vincent.pfx -srcstoretype pkcs12 -srcstorepass 123456 -destkeystore c:\xmlvend\vincent.jks -deststoretype jks -deststorepass 123456
* 1、右击项目文件夹:Show Project View>>WS-Security Configurations>>[Keystores]vincent.pfx,[Truststores]client_truststore（此项非必须）
* 2、点选Request1，左下角Properties>>SSL KeyStore>>vincent.pfx
## Postman
* 1、为https地址指定client证书文件（vincent.pfx）
> 右上角扳手》》Settings》》General标签页》》REQUEST 关闭 SSL certificate verification （因为咱用的是自签名的SSL）
>> Certificates标签页》》CA保持off（如果打开则必须添加服务器公钥证书？请求成功后再打开此项为空，依旧成功...），仅需添加 Client Certificates》》 Host=192.168.81.2:8443，PFX file=C:\xmlvend\vincent.pfx，Passphrase=123456
>>> 任何一步错误都会导致：Could not get any response
* 2、请求头 Content-Type = text/xml;charset=utf-8（否则报500，parse错误）
* 3、请求URL：https://192.168.81.2:8443/xmlvend/xmlvend.wsdl
> （GET）https://192.168.81.2:8443/xmlvend/xmlvend.wsdl相当于浏览器中打开（有时傻逼浏览器不知道切换选择证书，可以使用此招postman认证）


## JDK中keytool 常用命令: 

-genkey      在用户主目录中创建一个默认文件".keystore",还会产生一个mykey的别名，mykey中包含用户的公钥、私钥和证书
(在没有指定生成位置的情况下,keystore会存在用户系统默认目录，如：对于window xp系统，会生成在系统的C:/Documents and Settings/UserName/文件名为“.keystore”)
-alias       产生别名
-keystore    指定密钥库的名称(产生的各类信息将不在.keystore文件中)
-keyalg      指定密钥的算法 (如 RSA  DSA（如果不指定默认采用DSA）)
-validity    指定创建的证书有效期多少天
-keysize     指定密钥长度
-storepass   指定密钥库的密码(获取keystore信息所需的密码)
-keypass     指定别名条目的密码(私钥的密码)
-dname       指定证书拥有者信息 例如：  "CN=名字与姓氏,OU=组织单位名称,O=组织名称,L=城市或区域名称,ST=州或省份名称,C=单位的两字母国家代码"
-list        显示密钥库中的证书信息      keytool -list -v -keystore 指定keystore -storepass 密码
-v           显示密钥库中的证书详细信息
-export      将别名指定的证书导出到文件  keytool -export -alias 需要导出的别名 -keystore 指定keystore -file 指定导出的证书位置及证书名称 -storepass 密码
-file        参数指定导出到文件的文件名
-delete      删除密钥库中某条目          keytool -delete -alias 指定需删除的别  -keystore 指定keystore  -storepass 密码
-printcert   查看导出的证书信息          keytool -printcert -file yushan.crt
-keypasswd   修改密钥库中指定条目口令    keytool -keypasswd -alias 需修改的别名 -keypass 旧密码 -new  新密码  -storepass keystore密码  -keystore sage
-storepasswd 修改keystore口令      keytool -storepasswd -keystore e:/yushan.keystore(需修改口令的keystore) -storepass 123456(原始密码) -new yushan(新密码)
-import      将已签名数字证书导入密钥库  keytool -import -alias 指定导入条目的别名 -keystore 指定keystore -file 需导入的证书

## 各选项的缺省值。 
-alias "mykey"

-keyalg "DSA"

-keysize 1024

-validity 90

-keystore 用户宿主目录中名为 .keystore 的文件

-file 读时为标准输入，写时为标准输出 



