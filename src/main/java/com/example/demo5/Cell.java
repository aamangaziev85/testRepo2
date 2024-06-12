package com.example.demo5;

public abstract class Cell {
    public static final int OPENED = 0;

    public static final int CLOSED = 1;



    protected int status;



    protected int left, top;



    public Cell(int left, int top) {

        super();



        this.left = left;

        this.top = top;

        this.status = Cell.CLOSED;

    }



    /**

     * Открыть данную ячейку. Будем считать, что в этой операции происходит некоторая

     * ресурсоемкая операция. Например, загрузка изображения, для отображения содержимого ячейки.

     */

    public void open() {

        this.status = Cell.OPENED;

    }



    public int getLeft() {

        return left;

    }



    public int getTop() {

        return top;

    }



    public int getStatus() {

        return status;

    }



    /**

     * Единственная абстрактная операция, возвращаяет количество очков за открытие данной ячейки.

     */

    public abstract int getPoints();
}
