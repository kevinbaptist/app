package ovh.ladon.threads;

import ovh.ladon.threads.starvation.Worker;

public class StarvationExample {

    public static void main(String[] args) {
        Worker worker = new Worker();

        for (int i = 0; i < 10; i++) {
            new Thread(worker::work).start();
        }
    }
}
