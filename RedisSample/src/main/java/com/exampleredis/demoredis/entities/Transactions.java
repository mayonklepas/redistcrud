/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exampleredis.demoredis.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author mulyadi
 */
@RedisHash("transactions")
public class Transactions implements Serializable{
    
    @Id
    long id;
    String dbBic;
    String cdBic;
    String insertTime;
    double amount;

    public Transactions(long id, String dbBic, String cdBic, String insertTime, double amount) {
        this.id = id;
        this.dbBic = dbBic;
        this.cdBic = cdBic;
        this.insertTime = insertTime;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDbBic() {
        return dbBic;
    }

    public void setDbBic(String dbBic) {
        this.dbBic = dbBic;
    }

    public String getCdBic() {
        return cdBic;
    }

    public void setCdBic(String cdBic) {
        this.cdBic = cdBic;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
