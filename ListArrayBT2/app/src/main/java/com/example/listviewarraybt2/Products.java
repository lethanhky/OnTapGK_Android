package com.example.listviewarraybt2;

public class Products extends Goods {
    private Catalog Dmuc;

    public Products() {
        super();
    }
    public Products(String ma,String name)
    {
        super(ma,name);
    }
    public Products(String ma,String name, Catalog dmuc) {
        super(ma,name);
        this.Dmuc = dmuc;
    }

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }
}
