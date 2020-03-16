/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork3
 * @Author: Fan yuxuan
 * Date: 2020/3/16 18:10
 * project name: 20200316
 * @Version:
 * @Description: 牛客练习
 */
public class HomeWork3 {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param
     */
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                 if(array[i][j]==target){
                 return true;
                 }
            }
        }
        return false;

    }
    public static boolean Find2(int target,int[][] array) {
        int i=array.length-1;
        int j=0;
        while(i>=0&&j<array[i].length) {
            while (j < array[i].length && target > array[i][j]) {
                j++;
                if (j<array[i].length&&target == array[i][j]) {
                    return true;
                }
            }
            while (i >= 0 && j<array.length&&target < array[i][j]) {
                i--;
                if (i>=0&&target < array[i][j + 1] && target < array[i + 1][j]&&target>array[i][j]) {
                    return false;
                }
                if (i>=0&&target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array= new int[][] {{1,4,6,12},{2,8,12,13},{3,9,13,14}};
        boolean flg=Find3(11,array);
        System.out.println(flg);
    }
    public static boolean Find3(int target,int[][] array){
        int i = array.length-1;
        int j = 0;
        while((i>=0)&&(j<=array[i].length-1)){
            if(target==array[i][j]){
                return true;
            }
            else if(target<array[i][j]){
                i--;
            }
            else if(target>array[i][j]){
                j++;
            }
        }
        return false;
    }


}


