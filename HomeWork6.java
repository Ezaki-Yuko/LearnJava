/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork6
 * @Author: LENOVO
 * Date: 2020/3/25 15:49
 * project name: 20200325
 * @Version:
 * @Description:
 */

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        if(grid.length==0||grid==null){
            return -1;
        }
        int count=0;
        for(int i=0;i<=grid.length-1;i++){
            for(int j=0;j<=grid[i].length-1;j++){
                if(grid[i][j]>0){
                    count+=6*grid[i][j]-2*(grid[i][j]-1);
                    if(i<grid.length-1){
                        int ret=(grid[i+1][j]<grid[i][j])?(grid[i+1][j]):(grid[i][j]);
                        count-=(ret*2);
                    }
                    if(j<grid[i].length-1){
                        int ret=(grid[i][j+1]<grid[i][j])?(grid[i][j+1]):(grid[i][j]);
                        count-=(ret*2);
                    }
                }
            }
        }
        return count;
    }
}
public class HomeWork6 {
    public static void main(String[] args) {
        int [][] arr={{1,2},{3,4}};
        Solution solution=new Solution() ;
        System.out.println(solution.surfaceArea(arr));
    }
}
