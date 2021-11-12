package toolsmvn.vincent.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestMenuTree {
    @Test
    public void testtree() {
        //模拟从数据库查询出来
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子节点1.1", 2),
                new Menu(4, "子节点1.2", 2),
                new Menu(5, "根节点1.3", 2),
                new Menu(6, "根节点2", 1),
                new Menu(7, "根节点2.1", 6),
                new Menu(8, "根节点2.2", 6),
                new Menu(9, "根节点2.2.1", 7),
                new Menu(10, "根节点2.2.2", 7),
                new Menu(11, "根节点3", 1),
                new Menu(12, "根节点3.1", 11)
        );
        //获取父节点
        List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildList(getChildrens(m, menus));
                    return m;
                }
        ).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        System.out.println(JSON.toJSON(collect));
        System.out.println(responseFormat(JSON.toJSON(collect).toString()));;
    }
    /**
     * 递归查询子节点
     * @param root  根节点
     * @param all   所有节点
     * @return 根节点信息
     */
    private List<Menu> getChildrens(Menu root, List<Menu> all) {
        List<Menu> children = all.stream().filter(m -> {
            return Objects.equals(m.getParentId(), root.getId());
        }).map(
                (m) -> {
                    m.setChildList(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

    /**
     * 输出漂亮点的 json 返回
     * @param resString json字符串
     * @return
     */
    private String responseFormat(String resString){
        StringBuffer jsonForMatStr = new StringBuffer();
        int level = 0;
        for(int index=0;index<resString.length();index++)//将字符串中的字符逐个按行输出
        {
            //获取s中的每个字符
            char c = resString.charAt(index);

            //level大于0并且jsonForMatStr中的最后一个字符为\n,jsonForMatStr加入\t
            if (level > 0  && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            //遇到"{"和"["要增加空格和换行，遇到"}"和"]"要减少空格，以对应，遇到","要换行
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }
    private String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
}
