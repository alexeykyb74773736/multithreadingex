package com.company.myhomework.home3;

public class ScanDocument extends Document{
    public ScanDocument(String name, int pages) {
        super(name, pages);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public int getPages() {
        return super.pages;
    }

}
