/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo106
 * @Author: LENOVO
 * Date: 2020/6/3 21:22
 * project name: 20200603
 * @Version:
 * @Description:
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap存键值对
 * HashSet存key
 *
 * 给一个非空数组,除了某元素只出现一次以外,其余每个元素均出现了两次,找出那个只出现了一次的元素
 * 只出现一次的元素
 *
 * 1.通过map统计数字出现的次数,遍历map找到只出现一次的数字
 * Map<Integer,Integer> key表示当前的数字,value表示这个数字出现的次数
 */
public class TestDemo106 {
    public int singleNumber(int[] nums){
        //1.创建一个map统计每个数字出现的次数 key表示当前数字,value表示这个数字出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        //2.遍历数组,完成统计
        for(int x:nums){
            Integer value=map.get(x);
            if(value==null){
                //当前这个数字在map中不存在,新增一个键值对
                map.put(x,1);
            }else{
                //当前这个数字以及存在了,把value再加1就好
                //如果之前存在,就会修改
                map.put(x,value+1);
            }
        }
        System.out.println("统计出现次数结果:");
        System.out.println(map);
        //3.遍历map,找到出现次数为1次的数字
        /*for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            //getValue得到的是Integer包装类
            //通过equals判定相当于对1进行自动装箱,比较两个Integer的值
            //如果写成==1,相当于对Integer自动拆箱,比较两个==
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }*/
        //迭代器
        Iterator<HashMap.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            HashMap.Entry<Integer,Integer> entry=iterator.next();
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
         //理论上讲只要数组给的是正确的内容,return 0不会触发
        return 0;

    }
    //按位异或的方式 a^b^b=>a 二进制异或的规则相同为0,相异为1
    //a^0=>0
    //初始值为0 把所有的数字都一起异或 由于大部分数字都是出现两次,两次异或同一个数字就抵消
    //所有数字异或完成之后,最后的结果就是只存在一次的数字
    //偶数次消除,奇数次输出
    public int singleNumber1(int[] array){
        int ret=0;
        for(int x:array){
            ret^=x;
        }
        return ret;
    }
    //两个整数只出现一次,ab
    //所有的数字^完只剩下a^b剩下
    //a^b肯定不为0,就可以从异或结果中找到值为1的bit位
    //3.根据这个bit位,对整个数组进行分组,bit位为1的为1组,为0的为第二组
    //a和b就一定分散在不同的组中
    //此时两个组就是由若干个数字构成,其中一个数字只出现一次,剩下的数字都出现两次,再按照之前的按位异或在一起就得到这个只出现一次的值
    public int[] singleNumber2(int[] nums){
        //1.先把所有数组异或
        int ret=0;
        for(int x:nums){
            ret^=x;
        }
        //2.此时的异或结果相当于a^b,值一定不为0,就可以从中找到某个为1的bit位
        int bit=1;
        int i=0;
        //找第几位是1
        for(;i<32;i++){
            if((ret&(bit<<i))!=0){
                break;
            }
        }
        //循环结束后,bit中的值就是刚才找到的某一位为1的值
        //进行分组
        int a=0;
        int b=0;
        for(int x:nums){
            //针对这个1位就是(异位进行分组,异位一定是0/1,就能把a,b分开在两个组)
            //分组操作:让ab分散在不同组
            //让值相同的元素一定在同一组
            //分组操作和哈希表核心思想一直,也是现代服务器开发中的分布式系统核心思路一致
            if((x&(bit<<i))!=0){
                //指定位为1
                a^=x;
            }else{
                //第二组指定为0
                b^=x;
            }
        }
        int[] array={a,b};
        return array;
    }
}
