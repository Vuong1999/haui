package com.example.billinformation;

import java.util.ArrayList;

public class CustomerList {
    ArrayList<Customer> listKH=new ArrayList<Customer>();
    public void addCustomer(Customer kh)
    {
        listKH.add(kh);
    }
    public double sumProfits()
    {
        double tien=0.0;
        for(Customer kh:listKH) tien+=kh.tinhThanhTien();
        return tien;
    }
    public int sumCustomer()
    {
        return listKH.size();
    }
    public int sumCustomerVip()
    {
        int s=0;
        for(Customer kh:listKH)
        {
            if(kh.isVip()) s++;
        }
        return s;
    }
}
