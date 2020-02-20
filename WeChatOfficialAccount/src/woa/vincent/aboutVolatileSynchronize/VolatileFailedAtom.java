package woa.vincent.aboutVolatileSynchronize;

/**
 * Volatile不能保证原子性
 *
 * if(i==1)//单独对i读，此操作具有原子性
 * i=1;//单独对i写（赋值），此操作具有原子性
 * i++;//复合操作，此操作不具有原子性！！！！
 * 因为[++]这个动作大致分三步走！
 * （可以编译 javac -encoding UTF-8 VolatileFailedAtom.java
 * 反编译javap -c VolatileFailedAtom.class看下[++]操作对应的字节码
 *
 * 字节码释义如下：
 * aload_0 将this引用推送至栈顶
 * dup 复制栈顶值this应用，并将其压入栈顶，即此时操作数栈上有连续相同的this引用；
 * getfield 弹出栈顶的对象引用，获取其字段race的值并压入栈顶。第一次操作
 * iconst_1 将int型(1)推送至栈顶
 * iadd 弹出栈顶两个元素相加（race+1），并将计算结果压入栈顶。第二次操作
 * putfield 从栈顶弹出两个变量（累加值，this引用），将值赋值到this实例字段race上。第三次操作，赋值
 * ）
 *
 * 有的线程拿出race，加完尚未存回去，其他线程取到的是老值
 * 此时需要祭出低效的synchronize了，参照SynchronizedTest.java
 */
public class VolatileFailedAtom {
    public volatile int race = 0;

    public void increase() {
        race++;
    }

    public int getRace() {
        return race;
    }

    public static void main(String[] args) {
        // 创建5个线程，同时对同一个volatileTest实例对象执行累加操作
        VolatileFailedAtom volatileTest = new VolatileFailedAtom();
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];//5个线程
        for (int i = 0; i < threadCount; i++) {
            // 每个线程都执行1000次++操作
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    volatileTest.increase();
                }
                System.out.println(Thread.currentThread().getName() + "执行1000次++后,race值为：" + volatileTest.getRace());
            }, "线程" + (i + 1));
            threads[i].start();
        }

        // 等待所有累加线程都结束
        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 所有子线程结束后，race理论值应该是：5*10000=50000,但是执行结果会小于它
        System.out.println("累加结果：" + volatileTest.getRace());
    }


}
