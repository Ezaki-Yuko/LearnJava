/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo40
 * @Author: LENOVO
 * Date: 2020/4/12 16:25
 * project name: 20200412
 * @Version:
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 集合类有整体的认识
 */
public class TestDemo40 {
    //通过这个类来模拟创建一副牌
    //不加static的内部类,当我们创建Card对象的时候,必须要依靠TestDemo40的实例才能创建
    //加上static的内部类,当我们创建Card对象的时候,就不依赖TestDemo的实例,就可以在TestDemo的静态方法中被单独实例化
    static class Card{
        public String suit;
        public String rank;

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            //return "("+suit+rank+")";
            //String.format 静态方法,可以像C语言中的printf一样构造格式化字符串
            return String.format("(%s%s)",suit,rank);
        }
    }
    //构建一副牌
    public static List<Card> buyPoker(){
        //用List来放Card
        List<Card> poker=new ArrayList<>();
        String[] suits={"♥","♣","♦","♠"};
        for(int i=0;i<4;i++){
            for(int j=2;j<=10;j++){
                Card card=new Card(suits[i],String.valueOf(j));
                poker.add(card);
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        return poker;
    }

    public static void shuffle(List<Card> poker) {
        //洗牌思路很简单,也有很多不同的实现方式
        //从后往前遍历List,每次取到一张牌,就和前面一个随机位置的牌进行交换
        Random random=new Random();
        for(int i=poker.size()-1;i>0;i--){
            //随机产生一个[0,i)随机数
            int r=random.nextInt(i);
            swap(poker,i,r);
        }
    }
    private static void swap(List<Card> poker,int i,int j){
        Card temp=poker.get(i);
        poker.set(i,poker.get(j));
        poker.set(j,temp);
    }
    public static void main(String[] args) {
        //先买一副牌
        List<Card> poker=buyPoker();
        System.out.println(poker);
        //2.洗牌
        //Collection.shuffle(poker);标准库提供的洗牌操作
        shuffle(poker);
        System.out.println(poker);
        //3.发牌,把牌发给3个玩家,每个人发五张
        //  通过嵌套List来表示
        //  每个玩家的手牌是一个list,多个玩家的手牌再放在一个List
        //players中的元素个数就是玩家的总数,有几个玩家就有几个元素,每个玩家又是一个List
        List<List<Card>> players=new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //此处咱们在模拟轮流发牌
        for(int cardIndex=0;cardIndex<5;cardIndex++){
            for(int playerIndex=0;playerIndex<3;playerIndex++){
                //先获取到这个玩家
                List<Card> player=players.get(playerIndex);
                //再把poker中的最前面的元素发给当前玩家
                //remove删除0号下表元素,返回值是该对删掉的对象
                Card topCard=poker.remove(0);
                player.add(topCard);
            }
        }
        System.out.println("玩家一的手牌:");
        System.out.println(players.get(0));
        System.out.println("玩家二的手牌:");
        System.out.println(players.get(1));
        System.out.println("玩家三的手牌:");
        System.out.println(players.get(2));
        System.out.println("剩下的牌:");
        System.out.println(poker);
    }
}
