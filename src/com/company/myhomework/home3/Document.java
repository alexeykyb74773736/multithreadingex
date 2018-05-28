package com.company.myhomework.home3;

abstract class Document{
    protected String name;
    protected int pages;

    public Document(String name, int pages){
        this.name = name;
        this.pages = pages;
    }

    abstract protected String getName();
    abstract protected int getPages();
}


