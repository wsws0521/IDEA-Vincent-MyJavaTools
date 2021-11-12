set -x
kill -9 `ps -ef | grep husky-|grep -v grep | awk '{print $2}'`
HOME_DIR="$( cd "$(dirname "$0")" && pwd )"
JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=0.0.0.0:6970 -Dspring.config.location=${HOME_DIR}/application.properties"
JAVA_OPTS_1="-XX:+HeapDumpOnOutOfMemoryError -XX:+UseG1GC -XX:HeapDumpPath=${HOME_DIR}/husky.hprof  -XX:MaxMetaspaceSize=128M -Xms64M -Xmx64M -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -XX:+DisableExplicitGC -Xlog:gc*:file=${HOME_DIR}/logs/gc.log:time,uptime,uptimemillis:filecount=10,filesize=10240000"
nohup java ${JAVA_OPTS} -jar ${HOME_DIR}/husky-0.0.1-SNAPSHOT.jar  &