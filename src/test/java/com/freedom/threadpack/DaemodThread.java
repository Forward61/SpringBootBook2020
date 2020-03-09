package com.freedom.threadpack;

import java.io.IOException;

public class DaemodThread {

    public static void exectue(){
        for (int i = 0; ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(() -> exectue());
        thread.setDaemon(true);
        thread.start();

        System.in.read();
    }
}
