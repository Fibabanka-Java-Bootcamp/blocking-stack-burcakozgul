package org.kodluyoruz;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class StackPusher implements Runnable{

    Semaphore semaphore;
    Stack<String> stack;
    String item;

    public StackPusher() {
    }

    public StackPusher(Semaphore semaphore, Stack<String> stack, String item) {
        super();
        this.semaphore=semaphore;
        this.stack = stack;
        this.item = item;
    }


    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Push: "+stack.push(item));
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        semaphore.release();
    }
}
