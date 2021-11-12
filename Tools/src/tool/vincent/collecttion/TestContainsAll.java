package tool.vincent.collecttion;

import org.junit.Test;
import tool.vincent.optional.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestContainsAll {

    @Test
    public void testNPE(){
        List<User> userList = null;
        List<String> nameList = userList.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(nameList);
    }

    /**
     * 子集判断
     */
    @Test
    public void testAB(){
        List<String> aList = new ArrayList<>();
        aList.add("a");
        aList.add("b");
        aList.add("c");
        List<String> bList = new ArrayList<>();
//        bList.add("b");
        bList.add("c");
        bList.add("d");
        System.out.println(aList.containsAll(bList));
        System.out.println(aList.retainAll(bList)); // retainAll = 保留公共元素
        System.out.println(aList);
    }
}
