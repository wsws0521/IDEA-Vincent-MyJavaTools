package cn.vincent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SingleCallService {
    int callSynCumu2Mysql();

    int callSynLjz2Sqlserver();
}
