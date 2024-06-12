package com.example.demo5;

public class RealProject implements Project{
    private String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load(){
        System.out.println("Load project " + url + " .....");
    }
    @Override
    public void run() {
        System.out.println("Runner project " + url + " .....");
    }
}
