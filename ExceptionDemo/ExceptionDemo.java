package ExceptionDemo;


public class ExceptionDemo {
    public static void main(String[] args)throws AddException {
        if((10+20)==30){
            throw new AddException("错误的相加操作");//自定义异常学习
        }
        try {
            System.out.println(My.test(12,0));
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    public static Integer test(Integer a,Integer b) throws ArithmeticException{
        return a/b;
    }
}
class My{
    public static Integer test(Integer a,Integer b)throws ArithmeticException{
        Integer result=0;
        System.out.println("开始运行");
        try {
            result= a/b;
        } finally {
            System.out.println("运行结束");
        }
        return result;
    }
}
class AddException extends Exception{
    public AddException(String msg){
        super(msg);
    }
}
