package PokerDemo2;

import java.util.*;

public class PokerDemo2 {
    Player player1;
    Player player2;
    List<Poker> pokers=new ArrayList<Poker>();
    List<Poker> playOnePoker=new ArrayList<Poker>();
    List<Poker> playTwoPoker=new ArrayList<Poker>();
    public static void main(String[] args) {


    }
    public void createPlayer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎光临");
        System.out.println("请输入第一个玩家的名字：");
        player1.setName(scanner.next());//nextLine可以读取空格，next不能读空格
        System.out.println("请输入第二个玩家的名字：");
        player2.setName(scanner.next());
        System.out.println("输入完毕");
    }
    public void createPoker(){
        String[] suit = {"方片","梅花","红桃","黑桃"};
        String[] size = {"A", "2", "3", "4", "5","6","7","8","9","10","J","Q","K"};
        for(int i=0;i<suit.length;i++){
            for(int j=0;j<size.length;j++){
                pokers.add(new Poker(suit[i],size[j]));
            }
        }
        Iterator<Poker> iterator=pokers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public void refreshPoker(){
        System.out.println("正在洗牌");
        Collections.shuffle(pokers);
        System.out.println("洗牌完成");
    }
    public void fapai(){
        Random random=new Random();
        playOnePoker.add(pokers.remove(random.nextInt(pokers.size()-1)));
        System.out.println("第二位的牌");
        playTwoPoker.add(pokers.remove(random.nextInt(pokers.size()-1)));
    }

}
class Player{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Poker{
    private String suit;
    private String size;

    public Poker(String suit, String size) {
        this.suit = suit;
        this.size = size;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
