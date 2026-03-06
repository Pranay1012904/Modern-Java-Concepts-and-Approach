package com.multithreading;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreadUsingLambda {

    public static void main(String[] args) {
       // Thread using Lambda !!
        Runnable run=()->{
                ThreadUsingLambda.twoSum(new int[]{2,7,11,15},9);
                //ThreadUsingLambda.twoSum(new int[]{3,2,4},6);
            };
        Thread t1=new Thread(run,"KILLER-1");
        t1.start();
        //twoSum(new int[]{2,7,11,15},9);
        twoSum(new int[]{3,2,4},6);
    }

    public static void twoSum(int[] arr,int t){
        Map<Integer,Integer> m=new HashMap<>();
        int n=arr.length;
        int comp;
        for(int i=0;i<arr.length;i++){
            comp=t-arr[i];
            if(m.containsKey(comp)){
                System.out.println(Thread.currentThread().getName()+" --> "+Arrays.toString(new int[]{m.get(comp),i})+"-> "+Arrays.toString(arr));
            }else{
                m.put(arr[i],i);
            }
        }
    }
}
