package toolsmvn.vincent.guava.bloomFilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.NumberFormat;
import java.util.*;

/**
 * @PackageName: cn.vincent
 * @ClassName: GuavaBloomFilter
 * @Description: 布隆过滤器
 * @author: Vincent
 * @date: 2021/1/4 22:15
 */
public class GuavaBloomFilter {
    private static final int insertions = 1000000;
    public static void main(String[] args) {
        // 初始化一个布隆过滤器，指定大小100W
        // 参数3，默认误判率 0.03，修改误判率，会发现位图位数&Hash次数都在变化····。。。。
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), insertions);
        // 初始化一个set用来存放实际存在的key，用来判断
        Set<String> sets = new HashSet<String>(insertions);
        // 初始化一个list用来存放实际存在的key，用来取出
        List<String> lists = new ArrayList<String>(insertions);
        // 向3个容器初始化100W个随机且不重复的随机数，模拟ID
        for (int i = 0; i < insertions; i++) {
            String uuId = UUID.randomUUID().toString();
            bf.put(uuId);
            sets.add(uuId);
            lists.add(uuId);
        }
        int right = 0; // 判断正确的次数
        int wrong = 0; // 判断错误的次数
        for (int i = 0; i < 10000; i++) {
            // 可以被100整除时取一个确实存在的数（会有100个真实存在的数）
            String data = i % 100 == 0 ? lists.get(1 / 100) : UUID.randomUUID().toString();
            if(bf.mightContain(data)){
                // bf认为存在
                if(sets.contains(data)){
                    // 真实也确实存在
                    right ++;
                    continue;
                }
                // 否则就是bf就是判断出错，哈希冲突碰撞，无法避免
                wrong ++;
            }
        }
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2); // 最多两位小数
        float percent = (float) wrong / 9900;
        float bingo = (float) (9900 - wrong) / 9900;
        System.out.println("100W数据量，判断100个真实存在的数据，bf认为存在的个数：" + right);
        System.out.println("100W数据量，判断9900个瞎编的数据，bf误认为存在的个数：" + wrong);
        System.out.println("命中率：" + percentFormat.format(bingo));
        System.out.println("误判率：" + percentFormat.format(percent));

    }
}
