package woa.vincent.aboutFinal;

/**
 * 左边邮件该java-->Open in Terminal-->javac AboutFinal.java-->生成class文件
 * 注意：AboutFinal$1描述了内部类InnerClass与外部类AboutFinal之间的[参数传递关系]
 * 你会发现，外部类的[基本类型num]与[引用类型bean]全变成了内部类InnerClass的入参，入参形式不能变都是final，也就不能改num
 */
public class AboutFinal {
    public void useInnerClass(int num){
        DataBean bean = new DataBean("asdf");
        // 基本类型num与引用类型bean，都是InnerClass的final入参
        InnerClass innerClass = new InnerClass(){
            @Override
            void doSomething(){
//                num = 5;
                System.out.println("num = " + num);
                System.out.println("bean name is: " + bean.name);
            }
        };
        innerClass.doSomething();
    }

    public class  InnerClass{
        void doSomething(){}
    }

    public class DataBean{
        public String name;

        public DataBean(String name) {
            this.name = name;
        }
    }
}
