#! /bin/bash

kill `ps -ef | grep iSerureComMgr-ws|grep -v grep | awk '{print $2}'`
cd /home/project/iSecureComMgr-ws
nohup /home/hik/jdk/openjdk11linux64_1.1.1.20200117223552_CentOS/jre/bin/java -jar /home/project/iSecureComMgr-ws/iSecureComMgr-web-1.0.1-SNAPSHOT.jar &