package vincent.springmybatis.noxml.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.lang.reflect.Field;

/**
 *
 */
public class NoXmlUtils {
    /**
     * 为了方便演示和免除手工编写映射关系的烦恼，这里提供了一个快速生成映射结果集的方法:
     * 1.用于获取结果集的映射关系
     * 在Main下执行，然后我们将控制台打印信息复制到接口方法上即可。（囧）
     * @param origin
     * @return
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : origin.getDeclaredFields()) {
            String property = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName()).toUpperCase();
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),\n", property, column));
        }
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
}
