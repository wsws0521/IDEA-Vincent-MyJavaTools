package cn.vincent.guava.rateLimiter;


import com.google.common.util.concurrent.RateLimiter;

/**
 * 服务上使用令牌桶，限流
 */
public class HelloService {
    // qps = 10
    RateLimiter rateLimiter = RateLimiter.create(10);

    public void doRequest(){
        if(rateLimiter.tryAcquire()){
            System.out.println("请求成功");
        }else{
            System.out.println("请求过多，稍后重试");
        }
    }
}
