package com;
import java.util.ArrayList;
import java.util.Random;
/**
 * RandomGenerator
 */
public class RandomG {
    // random number generater
    private Random random = new Random();
    // counter
    private int count = 0;

    // arrayList for storing values
    private ArrayList<String> arrList =new ArrayList<String>();

    // constructor of RandomGenerator
    RandomG(){}
    
    // method for add stuff to arrayList
    protected void add(String stuff){
        arrList.add(stuff.toString());
        this.count += 1;
        System.out.println(count);
    }

    // method to remove last one
    protected void removeLastOne(){
        arrList.remove((arrList.size() - 1));
        this.count -= 1;
    }
    
    // method to output
    protected String output(){
        System.out.println(this.count);
        return (arrList.get(random.nextInt(this.count)));
    }
    
    // main method
}