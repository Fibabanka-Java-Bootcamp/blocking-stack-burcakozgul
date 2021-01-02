package org.kodluyoruz;

import java.util.Stack;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Stack<String> stack = new Stack<>();
        StackPusher stackPusher = new StackPusher(semaphore,stack,"test");
        StackPusher stackPusher1 = new StackPusher(semaphore,stack,"test1");
        StackPusher stackPusher2 = new StackPusher(semaphore,stack,"test2");
        StackPopper stackPopper = new StackPopper(semaphore,stack);
        StackPopper stackPopper1 = new StackPopper(semaphore,stack);
        StackPopper stackPopper2 = new StackPopper(semaphore,stack);
        Thread t = new Thread(stackPusher);
        Thread t1 = new Thread(stackPusher1);
        Thread t2 = new Thread(stackPusher2);
        Thread t3 = new Thread(stackPopper);
        Thread t4 = new Thread(stackPopper1);
        Thread t5 = new Thread(stackPopper2);
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
