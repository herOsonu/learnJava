package Collection;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashSet;

import java.util.List;

import java.util.Random;

import java.util.Scanner;

import java.util.Set;



public class Initial {

    List <PokerCard> PokerCardList=new <PokerCard>ArrayList();//初始化扑克牌

    List <PokerCard> PlayerOnePokerCard=new <PokerCard>ArrayList(); //玩家一的手牌

    List <PokerCard> PlayerTwoPokerCard=new <PokerCard>ArrayList(); //玩家二的手牌

    Player playerOne;                                            //玩家一

    Player playerTwo; //玩家二

    public void createPokerCard() {

        System.out.println("----------创建扑克牌...----------");

        String SuitString[]=new String[] {"方片","梅花","红桃","黑桃"};

        String SizeString[]=new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (int i=0;i<SuitString.length;i++) {  //将所有扑克牌按顺序添加到List中

            for(int j=0;j<SizeString.length;j++) {

                PokerCardList.add(new PokerCard(SuitString[i],SizeString[j]));

            }

        }

        System.out.print("----------创建扑克牌成功!----------\n为：");

        for(PokerCard pokercard:PokerCardList) {

            System.out.print(pokercard.getSuit()+pokercard.getSize()+",");

        }

        System.out.println();

    }

    public void shufflePokerCard() {

        System.out.println("----------开始洗牌...----------");

        Collections.shuffle(PokerCardList);

        System.out.println("----------洗牌结束!----------");

    }

    public void createPlayers() {

        System.out.println("----------创建玩家...----------");//创建第一位玩家

        System.out.println("请输入第1位玩家的ID和姓名");

        try {

            inputPlayerOne();

        } catch (inputException e) {

            System.out.println(e.getMessage());

            createPlayers();

        }

        System.out.println("请输入第2位玩家的ID和姓名");   //创建第二位玩家

        try {

            inputPlayerTwo();

        } catch (inputException e) {

            System.out.println(e.getMessage());

            createPlayers();

        }

        System.out.println("---欢迎玩家："+playerOne.getName());

        System.out.println("---欢迎玩家："+playerTwo.getName());

    }

    public void inputPlayerOne() throws inputException { //输入玩家1信息

        Scanner scannerPlayerOne=new Scanner(System.in);

        System.out.println("输入ID：");

        String PlayerOneID=scannerPlayerOne.next();

        if(isNumeric(PlayerOneID)==false) {

            throw new inputException();

        }

        System.out.println("输入姓名：");

        String PlayerOneName=scannerPlayerOne.next();

        playerOne=new Player(PlayerOneID,PlayerOneName);

    }

    public void inputPlayerTwo() throws inputException { //输入玩家2信息

        Scanner scannerPlayerTwo=new Scanner(System.in);

        System.out.println("输入ID：");

        String PlayerTwoID=scannerPlayerTwo.next();

        if(isNumeric(PlayerTwoID)==false) {

            throw new inputException();

        }

        System.out.println("输入姓名：");

        String PlayerTwoName=scannerPlayerTwo.next();

        playerTwo=new Player(PlayerTwoID,PlayerTwoName);

    }

    public void deal() {

        Random random=new Random();

        System.out.println("----------开始发牌...----------");

        System.out.println("----玩家："+playerOne.getName()+"-拿牌");

        PlayerOnePokerCard.add(PokerCardList.remove(random.nextInt(PokerCardList.size()-1)));

        System.out.println("----玩家："+playerTwo.getName()+"-拿牌");

        PlayerTwoPokerCard.add(PokerCardList.remove(random.nextInt(PokerCardList.size()-1)));

        System.out.println("----玩家："+playerOne.getName()+"-拿牌");

        PlayerOnePokerCard.add(PokerCardList.remove(random.nextInt(PokerCardList.size()-1)));

        System.out.println("----玩家："+playerTwo.getName()+"-拿牌");

        PlayerTwoPokerCard.add(PokerCardList.remove(random.nextInt(PokerCardList.size()-1)));

        System.out.println("----------发牌结束!----------");

    }

    public void startGame() {

        System.out.println("----------开始游戏!----------");

        String SuitString[]=new String[] {"方片","梅花","红桃","黑桃"};

        String SizeString[]=new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        PokerCard PlayerOneMax;  //第一位玩家最大的手牌

        PokerCard PlayerTwoMax;  //第二位玩家最大的手牌

        if(PlayerOnePokerCard.get(0).getSize()==PlayerOnePokerCard.get(1).getSize()) {//计算第一位玩家哪张手牌最大

            System.out.println(1);

            int countPlayerOne1=0;

            int countPlayerOne2=0;

            for(int x=0;x<4;x++) {

                if(SuitString[x]==PlayerOnePokerCard.get(0).getSuit()) {

                    countPlayerOne1=x;

                    break;

                }

            }

            for(int y=0;y<4;y++) {

                if(SuitString[y]==PlayerOnePokerCard.get(1).getSuit()) {

                    countPlayerOne2=y;

                    break;

                }

            }

            if(countPlayerOne1>countPlayerOne2) {

                PlayerOneMax=PlayerOnePokerCard.get(0);

            }

            else {

                PlayerOneMax=PlayerOnePokerCard.get(1);

            }

        }

        else {

            int countPlayerOne3=0;

            int countPlayerOne4=0;

            for(int x=0;x<13;x++) {

                if(SizeString[x]==PlayerOnePokerCard.get(0).getSize()) {

                    countPlayerOne3=x;

                    break;

                }

            }

            for(int y=0;y<13;y++) {

                if(SizeString[y]==PlayerOnePokerCard.get(1).getSize()) {

                    countPlayerOne4=y;

                    break;

                }

            }

            if(countPlayerOne3>countPlayerOne4) {

                PlayerOneMax=PlayerOnePokerCard.get(0);

            }

            else {

                PlayerOneMax=PlayerOnePokerCard.get(1);

            }

        }

        if(PlayerOnePokerCard.get(0).getSize()==PlayerOnePokerCard.get(1).getSize()) {//计算第二位玩家哪张手牌最大

            int countPlayerTwo1=0;

            int countPlayerTwo2=0;

            for(int x=0;x<4;x++) {

                if(SuitString[x]==PlayerTwoPokerCard.get(0).getSuit()) {

                    countPlayerTwo1=x;

                    break;

                }

            }

            for(int y=0;y<4;y++) {

                if(SuitString[y]==PlayerTwoPokerCard.get(1).getSuit()) {

                    countPlayerTwo2=y;

                    break;

                }

            }

            if(countPlayerTwo1>countPlayerTwo2) {

                PlayerTwoMax=PlayerTwoPokerCard.get(0);

            }

            else {

                PlayerTwoMax=PlayerTwoPokerCard.get(1);

            }

        }

        else {

            int countPlayerTwo3=0;

            int countPlayerTwo4=0;

            for(int x=0;x<13;x++) {

                if(SizeString[x]==PlayerTwoPokerCard.get(0).getSize()) {

                    countPlayerTwo3=x;

                    break;

                }

            }

            for(int y=0;y<13;y++) {

                if(SizeString[y]==PlayerTwoPokerCard.get(1).getSize()) {

                    countPlayerTwo4=y;

                    break;

                }

            }

            if(countPlayerTwo3>countPlayerTwo4) {

                PlayerTwoMax=PlayerTwoPokerCard.get(0);

            }

            else {

                PlayerTwoMax=PlayerTwoPokerCard.get(1);

            }

        }

        System.out.println("玩家："+playerOne.getName()+"最大的手牌为："+PlayerOneMax.getSuit()+PlayerOneMax.getSize());

        System.out.println("玩家："+playerTwo.getName()+"最大的手牌为："+PlayerTwoMax.getSuit()+PlayerTwoMax.getSize());

        if(compare(PlayerOneMax,PlayerTwoMax)) {          //玩家1和玩家2比较手牌大小

            System.out.println("----------玩家："+playerOne.getName()+"获胜！----------");

        }

        else {

            System.out.println("----------玩家："+playerTwo.getName()+"获胜！----------");

        }

    }

    public boolean compare(PokerCard pokercard1,PokerCard pokercard2) { //扑克牌比较大小的函数,如果pokercard1>pokercard2，返回True

        String SuitString[]=new String[] {"方片","梅花","红桃","黑桃"};

        String SizeString[]=new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        if(pokercard1.getSize()==pokercard2.getSize()){  //如果大小size一样，就比较花色suit谁大

            int countPlayerOne1=0;

            int countPlayerTwo1=0;

            for(int x=0;x<4;x++) {

                if(SuitString[x]==pokercard1.getSuit()) {

                    countPlayerOne1=x;

                    break;

                }

            }

            for(int y=0;y<4;y++) {

                if(SuitString[y]==pokercard2.getSuit()) {

                    countPlayerTwo1=y;

                    break;

                }

            }

            return countPlayerOne1>countPlayerTwo1;

        }

        else {                                           //如果大小size不一样，就比较大小size即可

            int countPlayerOne2=0;

            int countPlayerTwo2=0;

            for(int x=0;x<13;x++) {

                if(SizeString[x]==pokercard1.getSize()) {

                    countPlayerOne2=x;

                    break;

                }

            }

            for(int y=0;y<13;y++) {

                if(SizeString[y]==pokercard2.getSize()) {

                    countPlayerTwo2=y;

                    break; }

            }

            return countPlayerOne2>countPlayerTwo2;

        }

    }

    public static boolean isNumeric(String str){  //判断字符串是否是一个正整数

        for(int i=str.length();--i>=0;){

            int chr=str.charAt(i);

            if(chr<48 || chr>57)

                return false;

        }

        return true;

    }

    public void showPlayerPokerCard() {

        System.out.println("玩家各自的手牌为：");

        System.out.print(playerOne.getName()+":");

        for(PokerCard pokercard:PlayerOnePokerCard) {

            System.out.print(pokercard.getSuit()+pokercard.getSize()+" ");

        }

        System.out.println();

        System.out.print(playerTwo.getName()+":");

        for(PokerCard pokercard:PlayerTwoPokerCard) {

            System.out.print(pokercard.getSuit()+pokercard.getSize()+" ");

        }

    }

    public static void main(String[] args) {

        Initial initial =new Initial();

        initial.createPokerCard();  //创建扑克牌

        initial.shufflePokerCard(); //洗牌，打乱扑克牌的顺序

        initial.createPlayers();    //创建玩家

        initial.deal();            //给玩家发牌

        initial.startGame();        //开始游戏

        initial.showPlayerPokerCard(); //展示两位玩家的手牌

    }

}





class inputException extends Exception{

    inputException(){

        super("请输入整数类型的ID！");

    }

}



class Player {

    String ID;

    String name;

    public Player(String ID,String name) {

        this.ID=ID;

        this.name=name;

    }

    public String getID() {

        return ID;

    }

    public void setID(String iD) {

        ID = iD;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

}


class PokerCard {

    String suit;   //扑克牌的花色

    String size; //扑克牌的大小

    public PokerCard(String suit,String size){//含参构造器

        this.suit=suit;

        this.size=size;

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

