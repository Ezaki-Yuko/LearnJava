/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: HomeWork10
 * @Author: LENOVO
 * Date: 2020/3/27 11:23
 * project name: 20200327
 * @Version:
 * @Description:
 */
class Solution {
    private int gcd(int a,int b){
        int c=a%b;
        while(c!=0){
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length<2){
            return false;
        }
        int[] deckSum=new int[10000];
        int max=deck[0]>deck[1]?deck[0]:deck[1];
        int min=deck[0]<deck[1]?deck[0]:deck[1];
        for(int i=0;i<deck.length;i++){
            deckSum[deck[i]]++;
            if(deck[i]>max){
                max=deck[i];
            }
            if(deck[i]<min){
                min=deck[i];
            }
        }
        int j=0;
        while(min<=max){
            if(deckSum[min]==1){
                return false;
            }
            if(deckSum[min]>=2){
                deckSum[j]=deckSum[min];
                j++;
            }
            min++;
        }
        for(int i=0;i<j-1;i++){
            if(gcd(deckSum[i],deckSum[i+1])==1){
                return false;
            }
        }
        return true;
    }
}
public class HomeWork10 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,4,3,2,1};
        Solution solution=new Solution();
        boolean ret=solution.hasGroupsSizeX(arr);
        System.out.println(ret);
    }
}
