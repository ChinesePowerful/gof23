package proxy;

public class Broker implements VocalConcert {

    private String brokerName;

    private Star star;

    public Broker(String brokerName, Star star) {
        this.brokerName = brokerName;
        this.star = star;
    }

    //    进行演唱会除了唱歌以外的各个事项的处理，等到演唱会开始时告知明星上台唱歌即可
    public void todo() {
        before();
        this.star.todo();
        after();
    }

    private void before() {
        System.out.println(brokerName + " 与演出机构商谈");
        System.out.println(brokerName + " 筹备演唱会具体事项");
        System.out.println(brokerName + " 进行演唱会的宣传");
        System.out.println(brokerName + " 寻找正规的票务公司售票");
    }

    private void after() {
        System.out.println(brokerName + " 演出完成后的事项处理和演出回顾");
    }
}
