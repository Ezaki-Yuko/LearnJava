import java.util.Arrays;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork12
 * @Author: LENOVO
 * Date: 2020/3/28 14:42
 * project name: 20200328
 * @Version:
 * @Description:
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        //Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());
        if(words==null||words.length==0){
            return 0;
        }
        String str=new String("a");
        boolean ret=false;
        for(int i=0;i<words.length-1;i++){
            ret=false;
            for(int j=i+1;j<words.length;j++){
                if(words[i].length()<words[j].length()){
                    str=words[i];
                    words[i]=words[j];
                    words[j]=str;
                    ret=true;
                }
            }
            if(ret==false){
                break;
            }
        }
        String S = new String();
        for (String word : words) {
            if (!S.contains(word + "#")) {
                S = S.concat(word + "#");
            }
        }
        return S.length();
    }
}
public class HomeWork14 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String [] arr={"meet","me","bell"};
        System.out.println(solution.minimumLengthEncoding(arr));
    }

}