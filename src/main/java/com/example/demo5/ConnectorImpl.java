package com.example.demo5;

public class ConnectorImpl implements Connector{
    private final MyServer myServer;

    public ConnectorImpl(MyServer myServer) {
        System.out.println("Загрузка коннектора");
        this.myServer = myServer;
    }

    @Override
    public void uploadFile(String file) {
        myServer.putFile(file);
    }

    @Override
    public void recieveFile(String fileName) {
        myServer.takeFile(fileName);
    }
}
