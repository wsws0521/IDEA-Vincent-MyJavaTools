package vincent.proxy;

import java.lang.reflect.Proxy;

/**
 * JDK里的Proxy已经设计的很优美了，但是只能代理interface，无法代理class
 * 因为所有动态生成的代理类都继承了Proxy接口，Java又不支持多继承
 *
 * 但现实中你要代理的对象不一定都实现了某个接口，所以：
 * 可以看看第三方：CGLib，Aspectj貌似可以实现class的代理
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("this is proxy main");

        IKFC kfc = (IKFC) Proxy.newProxyInstance(
                MainTest.class.getClassLoader(),
                new Class[]{IKFC.class},
                new ProxyHandler(new KFC()));
        kfc.eat();
        IMiSeller mi = (IMiSeller) Proxy.newProxyInstance(
                MainTest.class.getClassLoader(),
                new Class[]{IMiSeller.class},
                new ProxyHandler(new MiStore()));
        mi.buy();
    }
}
