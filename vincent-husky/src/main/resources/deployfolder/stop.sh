#kill -15 `ps -ef | grep $1-|grep -v grep | awk '{print $2}'`
kill -15 `ps -ef | grep $1-|grep -v grep | awk '{print $2}'`
