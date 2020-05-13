import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo67
 * @Author: LENOVO
 * Date: 2020/5/11 19:56
 * project name: 20200428
 * @Version:
 * @Description:
 */
public class TestDemo67 {
    public static List<List<Integer>> generate(int numRows){
        //杨辉三角的规律
        //第1行固定 1
        //第二行固定 1 1
        //第i行 首位元素固定是1
        //第i行有i个元素
        //对于第i行来说  j列的值是i-1行j-1列 加j列
        if(numRows<=0){
            return new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        //先准备第一行 只有一个元素
        List<Integer> firstLine =new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows==1){
            return result;
        }
        //2.准备第二行
        List<Integer> secondLine=new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows==2){
            return result;
        }
        //3.处理第i行的情况
        // 第i行有i列
        //(i,j)=(i-1,j)+(i-1,j-1);
        //最后一个元素和第一个元素都是 1
        for(int row=3;row<=numRows;row++){
            //如果想知道row行情况 要先知道 row-1行的内容
            List<Integer> preLine=result.get(row-1-1);
            //第一次减一得到row-1行
            //第二次减一得到row-1的下标 row是从1开始 下标是从0开始
            List<Integer> curLine=new ArrayList<>();
            curLine.add(1);
            //第row行有row列 下面这个循环循环row-2次
            //第一列和最后一列不参与循环
            for(int col=2;col<row;col++){
                int curNum=preLine.get(col-1-1)+preLine.get(col-1);
                //col-1-1是col-1列的元素 col-1是col列的元素 col从1开始 下标从0开始
                curLine.add(curNum);
            }
            //处理最后一个
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
    public static void func(){
        int[] arr={1,2,3,4};
        System.out.println(arr[5]);
    }
    public static void main(String[] args) {
        System.out.println(generate(4));
    }
}
