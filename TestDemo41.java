/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo41
 * @Author: LENOVO
 * Date: 2020/4/12 17:37
 * project name: 20200412
 * @Version:
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class TestDemo41 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows<=0){
            return result;
        }
        //处理第一行的情况 固定只有一个一
        ArrayList<Integer> firstLine=new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows==1){
            return result;
        }
        //处理第二行的情况
        ArrayList<Integer> secondLine=new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows==2){
            return result;
        }
        //处理后面的行
        //第i行的相关规律
        //a)第1列和最后一列都是1
        //b)第i行有i列
        //c)i,j=(i-1,j-1)+(i-1,j)
        for(int row=3;row<=numRows;row++){
            //需要构造第row行的内容,构造第row行内容依赖row-1行
            //row从1开始算,下标从0开始算 把行数转换成对应的list下标
            List<Integer> prevLine=result.get(row-1-1);
            List<Integer> curLine=new ArrayList<>();
            //当前行第一列是1
            curLine.add(1);
            //第row行一共有row列
            //col也是从1开始算,第row行来说,col的取值范围就是[1,row]
            //其中第1列和第row列都是固定为1
            for(int col=2;col<=row-1;col++){
                //要计算第col列的值,需要知道上一行的col-1列和col列 col是从1开始的,换算成List下标还得再-1
                int temp1=prevLine.get(col-1-1);
                int temp2=prevLine.get(col-1);
                curLine.add(temp1+temp2);
            }
            //当前行最后一列也是1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
