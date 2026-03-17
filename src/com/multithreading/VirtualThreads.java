package com.multithreading;

public class VirtualThreads {

    public static void main(String[] args) {
        Runnable run1=()->{
           boolean res= VirtualThreads.pallindrome("abcba",0, args.length-1);
            System.out.println(Thread.currentThread().getName()+" :: "+res);
        };
        Thread t1=Thread.ofVirtual().start(run1);

        Thread t2=Thread.ofVirtual().unstarted(run1);
        t2.start();
        try {
            t2.join();//t2 is blocked until t1 finishes execution
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean pallindrome(String s,int l,int r){
        if(l>=r) return true;
        return s.charAt(l)==s.charAt(r) && pallindrome(s,l+1,r-1);
    }
}
