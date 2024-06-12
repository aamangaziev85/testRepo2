package com.example.demo5;

public class Mine extends Cell {
    public Mine(int left, int top) {

        super(left, top);
        System.out.println("загружаем тяжелое изображение пустой ячейки. mine ");

    }



    @Override

    public int getPoints() {

        return 100;   // 100 очков за открытую мину

    }
}
