package cn.vincent;

/**
 * 一个IPv4最小需要7个字符，最大需要15个字符(UTF-8下一个字符是3个字节  GBK是2个)
 * VARCHAR(15)
 * MySQL在保存变长的字符串时，还需要额外的一个字节来保存此字符串的长度
 * 所以最多需要 15*3 + 1 = 46字节
 * ----------------------------------------------
 * 而如果使用无符号整数来存储，只需要4个字节即可（不易读 + 不易于检索 + 需要手动转换）
 * mysql> select inet_aton('192.168.0.1');
 * mysql> select inet_ntoa(3232235521)
 */
public class IpLongUtils {
    /**
     * 把字符串IP转换成long
     * 4块数据，分别推到对应的位置  00000000 00000000 00000000 00000000
     * 所以在 气球消气回落 long2Ip 第二段 第三段 第四段 都要进行高位抹零，详见 long2Ip
     *
     * @param ipStr 字符串IP
     * @return IP对应的long值
     */
    public static long ip2Long(String ipStr) {
        String[] ip = ipStr.split("\\.");
        return (Long.valueOf(ip[0]) << 24) + (Long.valueOf(ip[1]) << 16)
                + (Long.valueOf(ip[2]) << 8) + Long.valueOf(ip[3]);
    }

    /**
     * 把IP的long值转换成字符串     >>> 无符号  >> 有符号
     *
     * & 0xFF的作用：将高的24位置为0，仅保留低8位（基础不牢，请读下文）
     * 原码 -> 反码 -> 补码
     * 补码就是 反码 + 1  就是为了方便计算机存储负数
     * int 1 (4 * 8 = 32bit) 原码 = 00000000 00000000 00000000 00000001
     * int 1 (4 * 8 = 32bit) 反码 = 11111111 11111111 11111111 11111110
     * int 1 (4 * 8 = 32bit) 补码 = 11111111 11111111 11111111 11111111（16进制为：0xFFFFFFFF，由此可知 0xFF = 00000000 00000000 11111111 11111111）
     * 原码 + 补码 = 0
     *
     * 如：“-12”二进制为：0000 1100 取反： 1111 0011 补码加1： 11110100
     * 【byte –> int】 就是由8位变 32 位 高24位全部补1： 11111111 11111111 11111111 11110100 ;
     * 0xFF的二进制表示就是：1111 1111，高24位补0：00000000 00000000 00000000 11111111;
     * -12的补码与0xFF 进行与（&）操作 最后就是:00000000 00000000 00000000 11110100
     *
     * @param ipLong IP的long值
     * @return long值对应的字符串
     */
    public static String long2Ip(long ipLong) {
        StringBuilder ip = new StringBuilder();
        ip.append(ipLong >>> 24).append(".");
        ip.append((ipLong >>> 16) & 0xFF).append(".");
        ip.append((ipLong >>> 8) & 0xFF).append(".");
        ip.append(ipLong & 0xFF);
        return ip.toString();
    }



    public static void main(String[] args) {
        System.out.println(ip2Long("192.168.0.1"));
        System.out.println(long2Ip(3232235521L));
        System.out.println(ip2Long("10.0.0.1"));

        int ipLong = 8; // 1000
        System.out.println(Integer.toBinaryString(ipLong));
        int ipLong2 = ipLong >>> 3;
        System.out.println(Integer.toBinaryString(ipLong2)); // 1
    }
}
