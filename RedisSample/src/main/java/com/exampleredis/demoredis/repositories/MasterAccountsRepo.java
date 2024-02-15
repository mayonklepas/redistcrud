/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exampleredis.demoredis.repositories;

import com.exampleredis.demoredis.entities.MasterAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mulyadi
 */
@Repository
public interface MasterAccountsRepo extends CrudRepository<MasterAccounts, String>{
    
}
