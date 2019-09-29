package com.example.listviewarraybt2;

import java.util.ArrayList;

public class Catalog extends  Goods {
    private ArrayList<Products> listsp= null;

    public Catalog(String ma,String name) {
        super(ma,name);
        this.listsp = new ArrayList<Products>();
    }

    public Catalog() {
        this.listsp = new ArrayList<Products>();
    }
    public boolean isDuplicate (Products p) // so sanh
    {
        for (Products p1 : listsp) {
            if (p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;
        }
        return false;
    }
    public boolean addProduct(Products p)
    {
        boolean isDup = isDuplicate(p);
        if (!isDup)
        {
            p.setDmuc(this);
            return listsp.add(p);
        }
        return isDup;
    }
    public ArrayList<Products>getlistProducts()
    {
        return this.listsp;
    }
    public int size()
    {
        return listsp.size();
    }
    public Products get(int i )
    {
        return listsp.get(i);
    }
}
