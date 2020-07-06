package tool.vincent.proxy;

public class MiStore implements IMiSeller {
    @Override
    public void buy() {
        System.out.println("我们买了一部小米手机");
    }
}
