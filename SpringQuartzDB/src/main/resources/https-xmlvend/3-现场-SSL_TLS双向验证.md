
## [服务端]C盘下创建文件夹：_cert
## 1-创建server的keystore文件
>>keytool -genkeypair -alias tomcat_server -keyalg RSA -keysize 1024 -sigalg sha256withrsa -keypass 123456 -keystore c:\_cert\server.jks -storepass 123456 -ext SAN=ip:192.168.80.37 -validity 3650 -v  -dname "CN=192.168.80.37,OU=xmlvend,O=xmlvend,L=xmlvend,ST=xmlvend,c=SA"
>>keytool -genkeypair -alias tomcat_server -keyalg RSA -keysize 1024 -sigalg sha256withrsa -keypass 123456 -keystore c:\_cert\server.jks -storepass 123456 -ext SAN=ip:192.168.80.37 -validity 3650 -v  -dname "CN=CentlecXmlvend,OU=xmlvend,O=xmlvend,L=xmlvend,ST=xmlvend,c=SA"

## 2-从server的keystore中导出server的证书（其中包括server的公钥）【导出的文件添加到客户端浏览器，作为“受信任的根证书颁发机构”证书】
>>keytool -export -alias tomcat_server -keystore c:\_cert\server.jks -storepass 123456 -file c:\_cert\server_cert.cer

## [客户端]C盘下创建文件夹：xmlvend
## 3-创建client的keystore文件【pfx/p12添加到浏览器“个人”证书】
>>keytool -genkeypair -alias vincent_client     -keyalg RSA -keysize 1024 -sigalg sha256withrsa  -keypass 123456 -storetype pkcs12 -keystore c:\xmlvend\vincent.pfx  -storepass 123456 -dname "CN=vincent,  OU=vincent, O=vincent,  L=vincent,  ST=vincent, c=SA" -validity 365
[Easypay.net]
>>keytool -genkeypair -alias easypay_client     -keyalg RSA -keysize 1024 -sigalg sha256withrsa  -keypass 123456 -storetype pkcs12 -keystore c:\xmlvend\easypay.pfx  -storepass 123456 -dname "CN=Easypay,  OU=Easypay, O=Easypay,  L=Easypay,  ST=Easypay, c=SA" -validity 365
[R&A.net]
>>keytool -genkeypair -alias ra_client          -keyalg RSA -keysize 1024 -sigalg sha256withrsa  -keypass 123456 -storetype pkcs12 -keystore c:\xmlvend\ra.pfx       -storepass 123456 -dname "CN=RA,       OU=RA,      O=RA,       L=RA,       ST=RA,      c=SA" -validity 365
[Cigicell.net]
>>keytool -genkeypair -alias cigicell_client    -keyalg RSA -keysize 1024 -sigalg sha256withrsa  -keypass 123456 -storetype pkcs12 -keystore c:\xmlvend\cigicell.pfx -storepass 123456 -dname "CN=Cigicell, OU=Cigicell,O=Cigicell, L=Cigicell, ST=Cigicell,c=SA" -validity 365
[Ontec.java]
>>keytool -genkeypair -alias ontec_client       -keyalg RSA -keysize 1024 -sigalg sha256withrsa  -keypass 123456                   -keystore c:\xmlvend\ontec.jks    -storepass 123456 -dname "CN=Ontec,    OU=Ontec,   O=Ontec,    L=Ontec,    ST=Ontec,   c=SA" -validity 365

## 4-从client的keystore中导出client的证书（其中包括client的公钥）
>>keytool -export    -alias vincent_client  -keystore C:\xmlvend\vincent.pfx  -storepass 123456 -file C:\xmlvend\vincent_cert.cer
[Easypay.net]
>>keytool -export    -alias easypay_client  -keystore C:\xmlvend\easypay.pfx  -storepass 123456 -file C:\xmlvend\easypay_cert.cer
[R&A.net]
>>keytool -export    -alias ra_client       -keystore C:\xmlvend\ra.pfx       -storepass 123456 -file C:\xmlvend\ra_cert.cer
[Cigicell.net]
>>keytool -export    -alias cigicell_client -keystore C:\xmlvend\cigicell.pfx -storepass 123456 -file C:\xmlvend\cigicell_cert.cer
[Ontec.java]
>>keytool -export    -alias ontec_client    -keystore C:\xmlvend\ontec.jks    -storepass 123456 -file C:\xmlvend\ontec_cert.cer

## 将第4步[客户端]的证书copy到[服务端]/_cert/clients文件夹下
## 5-创建server的truststore文件并导入client的证书（其中包括client的公钥）
>>keytool -importcert -alias tomcat_server   -keystore c:\_cert\server_truststore -storepass 123456 -file C:\_cert\clients\vincent_cert.cer
[Easypay.net]
>>keytool -importcert -alias easypay_server  -keystore c:\_cert\server_truststore -storepass 123456 -file C:\_cert\clients\easypay_cert.cer
[R&A.net]
>>keytool -importcert -alias ra_server       -keystore c:\_cert\server_truststore -storepass 123456 -file C:\_cert\clients\ra_cert.cer
[Cigicell.net]
>>keytool -importcert -alias cigicell_server -keystore c:\_cert\server_truststore -storepass 123456 -file C:\_cert\clients\cigicell_cert.cer
[Ontec.java]
>>keytool -importcert -alias ontec_server    -keystore c:\_cert\server_truststore -storepass 123456 -file C:\_cert\clients\ontec_cert.cer

## tomcat/conf/server.xml
`<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
     maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
     clientAuth="true" sslProtocol="TLS"
     keystoreFile="D:/key2/server.keystore" keystorePass="123456"
   truststoreFile="D:/key2/server.keystore" truststorePass="123456"/>`


