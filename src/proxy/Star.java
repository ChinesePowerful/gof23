package proxy;

public class Star implements VocalConcert{

    private String starName;

    public Star(String starName) {
        this.starName = starName;
    }

    public void todo() {
        System.out.println(starName + " 唱歌");
    }
}
