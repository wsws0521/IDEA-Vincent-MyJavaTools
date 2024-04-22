package vincent.test;

public class OuterClass {
    public void useInnerClass(int num){
        InnerClass ic = new InnerClass(){
            @Override
            void doSomething() {
                super.doSomething();
                System.out.println("num is : " + num);
            }
        };
        ic.doSomething();
    }

    public class InnerClass{
        void doSomething(){}
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        oc.useInnerClass(5);
    }
}
