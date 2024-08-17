package com.spring.aopspringboot.DAO;

import com.spring.aopspringboot.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account,boolean flag) {
        System.out.println(getClass() + " - DOING MY DB Work : Adding Account\n");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " - DOING Work \n");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " - getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " - setName()\n ");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " - getServiceCode()\n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " - setServiceCode()\n");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        /*List<Account> myAccounts=new ArrayList<>();
        Account temp1=new Account("John","Silver");
        Account temp2=new Account("Madhu","Platinum");
        Account temp3=new Account("Susan","Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;*/
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if(tripWire)
        {
            throw new RuntimeException("Exception Found for You !!!");
        }
        List<Account> myAccounts=new ArrayList<>();
        Account temp1=new Account("John","Silver");
        Account temp2=new Account("Madhu","Platinum");
        Account temp3=new Account("Susan","Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
}
