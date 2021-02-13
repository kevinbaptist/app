package ovh.ladon.threads;

import ovh.ladon.threads.livelock.Criminal;
import ovh.ladon.threads.livelock.Police;

public class HostageRescueLivelock {
    static final Police police = new Police();

    static final Criminal criminal = new Criminal();

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> police.giveRansom(criminal));
        t1.start();

        Thread t2 = new Thread(() -> criminal.releaseHostage(police));
        t2.start();
    }

}
