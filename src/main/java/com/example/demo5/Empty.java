package com.example.demo5;

public class Empty extends Cell {

    public Empty(int left, int top) {

        super(left, top);
        System.out.println("загружаем тяжелое изображение пустой ячейки. empty ");

        // загружаем тяжелое изображение пустой ячейки.

    }


    @Override

    public int getPoints() {

        return 10;  // 10 очков за открытую пустую ячейку

    }

}
