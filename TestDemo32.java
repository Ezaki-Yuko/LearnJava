/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo32
 * @Author: LENOVO
 * Date: 2020/4/9 18:35
 * project name: 20200409
 * @Version:
 * @Description:
 */

import java.util.Arrays;

/**
 * == 比较身份
 * equals 比较内容
 * 字符串常量池 通过把创建好的字符串常量直接放到一个池中,后续如果使用这个常量就直接从池中取,不需要额外创建对象
 * intern 方法主动入池
 * 不可变特性 无法修改String的内容,核心成员 char value[].String类没有提供一个public方法修改数组内容
 * 方便实现字符串常量池 不可变对象的hash值不变,更方便保存到hash表中 不可变对象线程安全
 */
public class TestDemo32 {
    public static void main(String[] args) {
        String str1="hello worldwor";
        String str2="wor";
        //通过contains可以判定是否是包含关系
        System.out.println(str1.contains(str2));
        //通过indexOf方法判断子串是否存在 还可以查看子串所在的位置
        //返回值表示str2在str1 这个字符串所在的下标位置
        //如果存在多组子串,返回最左侧子串的下标
        System.out.println(str1.indexOf(str2));
        //从右往左找匹配的字符串
        System.out.println(str1.lastIndexOf(str2));

        //startsWith ,endsWith 判断开始的位置和结束的位置
        System.out.println(str1.startsWith("hello"));
        System.out.println(str1.endsWith("hello"));

        //replaceAll/replaceFirst都不修改原始的字符串,而是得到新的字符串
        //替换所有指定内容/替换首个内容
        String result=str1.replace("world","java");
        System.out.println(str1);
        System.out.println(result);

        //replaceAll/replaceFirst第一个参数regex =>正则表达式 .
        //是一个特殊的字符串,带有一些特殊的符号,这些符号就描述了你要找的字符串的特征

        //C语言中strtok:针对两个相邻的分隔符,会合并成一个(切分结果是3)

        String str3="aaa,bbb,,ccc";
        String[] str4=str3.split(",");
        System.out.println(Arrays.toString(str4));

        //.在正则表达式中具有特殊含义,这里的.不是按照"."文本切分
        //想按照.的文本进行切分,就需要进行转义
        //正则中需要通过\.来查找文本
        //java代码中字符串中不能直接写\,需要\\表示一个文本\
        // | * + ...都有类似的情况
        //java13版本引入了raw string这样的语法特性 避免双重转义
        String str5="192.168.1.1";
        String[] str6=str5.split("\\.");
        System.out.println(Arrays.toString(str6));

        String str7="name=张三&age=18";
        String[] str8=str7.split("&");
        for (String temp:str8) {
            //预期temp2 数组中包含两个元素
            String[] temp2=temp.split("=");
            System.out.println(temp2[0]+":"+temp2[1]);
        }
        //字符串截止
        String str9="hello world";
        //前闭后开,子串要包含6位置的元素,不包含9位置的元素
        System.out.println(str9.substring(6,9));
        //表示从6开始,一直到最终末尾结束
        System.out.println(str9.substring(6));

        String str10="\n\t   abcd     \n  ";
        System.out.println("["+str10+"]");
        //去掉字符串的空白字符:空格 制表符 换行 回车 垂直制表符 翻页符....
        System.out.println("["+str10.trim()+"]");
        String str11="Hello";
        //String是不可变对象,toSting
        System.out.println(str11.toUpperCase());
        System.out.println(str11.toLowerCase());
        //isEmpty 判断的是当前字符串是否是空字符串(""),而不是判定是否为null

        //str=str+"abcd"
        //这个操作频繁的进行了对象的创建和销毁,比较低效
        //StringBuilder 线程不安全/StringBuffer 线程安全 支持的操作和用法几乎是一样的
        String str12="";
        for(int i=0;i<1;i++){
            //str12是不可变对象,+=操作也是创建了新的对象
            str12+="abcd";
        }
        System.out.println(str12);
    }

}
