package invoke;

public class Phone implements IMessage{
    @Override
    public void send() {
        System.out.println("send");
    }
}
