package cn.vincent.testmybatisplus.console.service;

import org.springframework.stereotype.Service;

@Service
public class IdGeneratorImpl implements IdGenerator {
    @Override
    public Long next(Long max) {
        return max + 1;
    }
}
