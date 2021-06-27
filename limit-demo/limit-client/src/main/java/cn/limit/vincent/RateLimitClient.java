package cn.limit.vincent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

@Service
public class RateLimitClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisScript<Long> rateLimitLua;

    public boolean acquireToken(String key){
        Long re = stringRedisTemplate.execute(
                rateLimitLua,
                java.util.Collections.singletonList(key),
                "60", "10");
        if(re.intValue() == 1){
            return true;
        }else{
            return false;
        }
    }

}
