import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo66
 * @Author: LENOVO
 * Date: 2020/5/11 17:20
 * project name: 20200428
 * @Version:
 * @Description:
 */
class Card{//这是一张牌
    private String rank;//点数
    private String suit;//花色
    public Card(String rank,String suit){
        this.rank=rank;
        this.suit=suit;
    }
    public String getRank(){
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
      /*  return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';*/
      return "["+this.suit+this.rank+"]";
    }
}
public class TestDemo66 {
    public static void main(String[] args) {
        List<Card> poker=buyPoker();
        System.out.println(poker);
        //洗牌,最简单的办法 Collection.shuffle方法
        //把List中的元素随机打乱
        //shuffle也可以自己实现
        //一种简单的办法 从后往前遍历List,取出当前元素 再生成一个随机位置
        //把当前元素和随机位置的元素交换即可
        Collections.shuffle(poker);
        //3.发牌 假设有三个玩家,每人发五张牌
        //  每个玩家是个List 每个人的手牌放在list中
        //多个玩家的信息再放在一个List中
        //players就表示所有玩家
        //每个元素就是一个玩家的手牌 一个list
        List<List<Card>> players=new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //给三个玩家发牌 每人五张牌
        //i表示牌的编号 j表示玩家的编号
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                List<Card> player=players.get(j);
                //remove 表示删除List中指定下标的元素
                //remove返回值表示删除的这个元素是啥
                player.add(poker.remove(0));
            }
        }
        //到这一步 玩家发牌结束 就可以查看玩家手牌
        for(int i=0;i<3;i++){
            System.out.println("玩家"+i+":"+players.get(i));
        }
    }
    //创建一副牌
    private static List<Card> buyPoker(){
        List<Card> poker=new ArrayList<>();
        String[] suits={"♥","♠","♣","♦"};
        //for循环来处理四种花色
        for(int i=0;i<4;i++){
            //每种花色13张牌
            for(int j=2;j<=10;j++){
                //j表示点数 int=>String
                //""+j
                //String.valueOf
                poker.add(new Card(String.valueOf(j),suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
    }
}
