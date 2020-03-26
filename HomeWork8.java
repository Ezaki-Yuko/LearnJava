import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork8
 * @Author: LENOVO
 * Date: 2020/3/26 13:32
 * project name: 20200326
 * @Version:
 * @Description:
 */

class Solution {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        loop:for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    break loop;
                }
            }
            //if (board[i][j] == 'R') {
              //  break;
            //}
        }
            int count = 0;
            for (int a = i - 1; a >= 0; a--) {
                if (board[a][j] == 'p') {
                    count++;
                    break;
                }
                if (board[a][j] == 'B') {
                    break;
                }
            }
            for (int a = i + 1; a < board.length; a++) {
                if (board[a][j] == 'p') {
                    count++;
                    break;
                }
                if (board[a][j] == 'B') {
                    break;
                }
            }
            for (int b = j - 1; b >= 0; b--) {
                if (board[i][b] == 'p') {
                    count++;
                    break;
                }
                if (board[i][b] == 'B') {
                    break;
                }
            }
            for (int b = j + 1; b < board[i].length; b++) {
                if (board[i][b] == 'p') {
                    count++;
                    break;
                }
                if (board[i][b] == 'B') {
                    break;
                }
            }
            return count;
        }
}
public class HomeWork8 {
    public static void main(String[] args) {
        char [][] arr=new char[][]{{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        Solution solution=new Solution();
        System.out.println(solution.numRookCaptures(arr));
    }
}
