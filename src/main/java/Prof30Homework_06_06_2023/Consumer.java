package Prof30Homework_06_06_2023;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if ("exit".equals(queue.take().getMsg())) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}