package com.example.demo5;

import java.util.Iterator;

public class MyList<Ulan>{
    private Object[] data;
    private int count;
    private int listSize;

    public MyList() {
        this.data = new Object[10];
        this.count = 0;
        this.listSize = 0;
    }

    public void add (Ulan item){
        data[count] = item;
        count ++;
        listSize ++;
    }

    public int getSize(){
        return listSize;
    }

    public Ulan get(int index){
        return (Ulan) data[index];
    }
}
