package command;

public class Phone {

    private static final int VOLUME_MAX = 16;
    private static final int VOLUME_MIN = 0;

    private int volume = 8;

    private boolean screen = false;

    public void volumeUp1() {
        if (this.volume >= VOLUME_MAX) {
            System.out.println("音量已经最大了！音量：" + this.volume);
            return;
        }
        this.volume++;
        System.out.println("单击音量增加按键～音量" + this.volume);
    }

    public void volumeUp() {
        if (this.volume >= VOLUME_MAX) {
            System.out.println("音量已经最大了！音量：" + this.volume);
            return;
        }
        this.volume = VOLUME_MAX;
        System.out.println("长按音量增加！音量：" + this.volume);
    }

    public void volumeDown1() {
        if (this.volume <= VOLUME_MIN) {
            System.out.println("音量已经最小了！音量：" + this.volume);
            return;
        }
        this.volume--;
        System.out.println("单击音量减少按键～音量：" + this.volume);
    }

    public void volumeDown() {
        if (this.volume <= VOLUME_MIN) {
            System.out.println("音量已经最小了！音量：" + this.volume);
            return;
        }
        this.volume = VOLUME_MIN;
        System.out.println("长按音量减少！音量：" + this.volume);
    }

    public void power1() {
        if (this.screen) {
            System.out.println("单击电源按键：正在熄灭屏幕～");
            this.screen = false;
        } else {
            System.out.println("单击电源按键：正在点亮屏幕～");
            this.screen = true;
        }
    }

    public void power() {
        System.out.println("长按电源按键～呼叫出 Siri～");
    }

    public void doublePower() {
        System.out.println("双击电源按键～打开了 Apple Pay～");
    }

}
