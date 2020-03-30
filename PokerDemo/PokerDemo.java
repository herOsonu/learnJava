package PokerDemo;

import java.util.*;

public class PokerDemo {

    List<Poker> pokers = new ArrayList<Poker>();//初始化扑克牌
    List<Poker> playerOneCard = new ArrayList<Poker>();//创建玩家1的手牌
    List<Poker> playerTwoCard = new ArrayList<Poker>();//创建玩家2的手牌
    Player player1;
    Player player2;

    //初始化扑克牌
    public void createPoker(List<Poker> pokers) {
        String[] size = {"A", "2", "3", "4", "5","6","7","8","9","10","J","Q","K"};
        String[] suit = {"方片","梅花","红桃","黑桃"};
        for(int i=0;i<suit.length;i++){
            for(int j=0;j<size.length;j++){
                pokers.add(new Poker(suit[i],size[j]));
            }
        }
        System.out.println("创建扑克牌成功！输出所有扑克牌：");
        Iterator<Poker> iterator=pokers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //洗牌
    public void shufflePoker(List<Poker> pokers){
        System.out.println("开始洗牌");
        Collections.shuffle(pokers);
        System.out.println("洗牌成功");
    }
    //创建玩家
    public void createPlayer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("创建玩家1");
        System.out.println("请输入玩家姓名1：");
        player1.setName(scanner.next());
        System.out.println("创建玩家2");
        System.out.println("请输入玩家姓名2：");
        player2.setName(scanner.next());
        System.out.println("欢迎玩家1："+player1.getName()+"进入游戏");
        System.out.println("欢迎玩家2："+player2.getName()+"进入游戏");
    }
    //发牌
    public void deal(){
        Random random=new Random();
        System.out.println("开始发牌...");
        for(int i=0;i<2;i++){
            System.out.println("玩家1："+player1.getName()+"拿牌：");
            playerOneCard.add(pokers.remove(random.nextInt(pokers.size()-1)));
            System.out.println("玩家2："+player2.getName()+"拿牌：");
            playerTwoCard.add(pokers.remove(random.nextInt(pokers.size()-1)));
            System.out.println("玩家1："+player1.getName()+"拿牌：");
        }
        System.out.println("发牌结束");


    }
    public void startGame(){
        String[] size = {"A", "2", "3", "4", "5","6","7","8","9","10","J","Q","K"};
        String[] suit = {"方片","梅花","红桃","黑桃"};
        int one1=0;
        int one2=0;
        System.out.println("开始游戏");
        if(playerOneCard.get(0).getSize()==playerOneCard.get(0).getSize()){
            for(int i=0;i<suit.length;i++){
                String one=playerOneCard.get(0).getSuit();
                if(suit[i]==one){
                    one1=i;
                }
            }
            for(int i=0;i<suit.length;i++){
                String one=playerOneCard.get(1).getSuit();
                if(suit[i]==one){
                    one2=i;
                }
            }
            if(one1>one2){
                int playerOneMax=one1;
            }else{
                int playerOneMax=one2;
            }

        }else{

        }
    }
}
    //扑克牌的类
class Poker{
    private String size;
    private String suit;

        public Poker(String size, String suit) {
            this.size = size;
            this.suit = suit;       
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }
    }
//玩家的类
class Player{
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
