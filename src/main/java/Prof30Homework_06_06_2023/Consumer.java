package Prof30Homework_06_06_2023;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message exit = new Message(null);
        do {
            try {
                // taking message from queue
                exit = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // finding exit message
        } while (!"exit".equals(exit.getMsg()));
    }
}