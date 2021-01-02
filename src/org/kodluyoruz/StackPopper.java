package org.kodluyoruz;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class StackPopper implements Runnable{

    Semaphore semaphore;
    Stack<String> stack;

    public StackPopper(Semaphore semaphore, Stack<String> stack) {
        super();
        this.semaphore = semaphore;
        this.stack = stack;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Pop: "+stack.pop());
        }
        catch (EmptyStackException e){
            System.out.println(e);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

        semaphore.release();

    }
}
