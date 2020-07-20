/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo111
 * @Author: LENOVO
 * Date: 2020/6/6 15:31
 * project name: 20200603
 * @Version:
 * @Description:
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 宝石与石头
 *
 */
public class TestDemo111 {
    public int numJewelsInStones(String J,String S){
        //1.先遍历J,把宝石类型加到Set中
        Set<Character> set=new HashSet<>();
        for(char c:J.toCharArray()){
            set.add(c);
        }
        int ret=0;
        for(char c:S.toCharArray()){
            //hashset的contains操作时O(1)
            if(set.contains(c)){
                ret++;
            }
        }
        return ret;
    }

}
