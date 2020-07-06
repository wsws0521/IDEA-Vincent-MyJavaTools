package tool.vincent.proxy;

public class KFC implements IKFC {

    @Override
    public void eat() {
        System.out.println("我们在KFC吃了一顿饭");
    }
}
