package proxy;

public class Main {
    public static void main(String[] args) {
        Star star = new Star("周杰伦");
        Broker broker = new Broker("杨峻荣", star);
//        由经纪人发起演唱会
        broker.todo();
    }
}
