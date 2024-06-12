package com.example.demo5;

public class ConnectorProxy implements Connector{
    private ConnectorImpl connector;
    @Override
    public void uploadFile(String file) {
        init();
        if(validate(file))
            connector.uploadFile(file);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void recieveFile(String fileName) {
        init();
        if(validate(fileName))
            connector.recieveFile(fileName);
        else
            throw new IllegalArgumentException();
    }

    private void init(){
        if(connector == null){
            connector = new ConnectorImpl(new MyServer());
        }
    }

    private Boolean validate(String file){
        return !file.isEmpty();
    }
}
