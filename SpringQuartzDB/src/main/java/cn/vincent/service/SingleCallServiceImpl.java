package cn.vincent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SingleCallServiceImpl implements SingleCallService {
    private static final Logger logger = LoggerFactory.getLogger(SingleCallServiceImpl.class);
    @Override
    public void callSynCumu() {
        logger.info("未完待续............");
    }
}
