/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exampleredis.demoredis.controller;

import com.exampleredis.demoredis.entities.MasterAccounts;
import com.exampleredis.demoredis.entities.Transactions;
import com.exampleredis.demoredis.repositories.MasterAccountsRepo;
import com.exampleredis.demoredis.repositories.TransactionsRepo;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mulyadi
 */
@RestController
@RequestMapping("/api/main")
public class MainController {

    @Autowired
    MasterAccountsRepo ma;
    @Autowired
    TransactionsRepo tx;

    @GetMapping("/create-master-account")
    public ResponseEntity createMasterAccount() {

        long startTime = System.currentTimeMillis();
        ma.deleteAll();

        for (int i = 0; i < 00; i++) {
            int def = 1001 + i;
            String bic = String.valueOf(def);
            MasterAccounts acc = new MasterAccounts(bic, 2_000_000, 2_000_000, 0, 0, 0, 0);
            ma.save(acc);
        }

        long executionTime = (System.currentTimeMillis() - startTime);

        Map<String, Object> resMap = new LinkedHashMap();
        resMap.put("status", "success");
        resMap.put("timeProcess", NumberFormat.getNumberInstance(Locale.GERMANY).format(executionTime) + "ms");
        resMap.put("data", "");

        return ResponseEntity.ok(resMap);
    }

    @PostMapping("/execute-transaction")
    public ResponseEntity executeTransaction(@RequestBody List<Map<String, Object>> param) {

        List<Map<String, Object>> data = param;

        long startTime = System.currentTimeMillis();
        long counter = 1l;
        for (Map<String, Object> d : data) {
            try {
                String norekPengirim = d.get("fromBic").toString();
                String norekPenerima = d.get("toBic").toString();
                double nominal = (double) d.get("amount");
                String insertTime = LocalDateTime.now().toString();

                Transactions trans = new Transactions(counter, norekPengirim, norekPenerima, insertTime, nominal);
                tx.save(trans);

                MasterAccounts pengirimData = ma.findById(norekPengirim).get();
                pengirimData.setBalance(pengirimData.getBalance() - nominal);
                ma.save(pengirimData);

                MasterAccounts penerimaData = ma.findById(norekPenerima).get();
                penerimaData.setBalance(pengirimData.getBalance() + nominal);
                ma.save(penerimaData);

                counter++;
            } catch (Exception e) {
                System.out.println(d);
            }

            

        }

        long executionTime = (System.currentTimeMillis() - startTime);

        Map<String, Object> resMap = new LinkedHashMap();
        resMap.put("status", "success");
        resMap.put("timeProcess", NumberFormat.getNumberInstance(Locale.GERMANY).format(executionTime) + "ms");
        resMap.put("data", "");

        return ResponseEntity.ok(resMap);
    }

    @GetMapping("/getall-transaction")
    public ResponseEntity getAllTrans() {

        long startTime = System.currentTimeMillis();

        List<Transactions> result = StreamSupport.stream(tx.findAll().spliterator(), true).collect(Collectors.toList());

        long executionTime = (System.currentTimeMillis() - startTime);

        Map<String, Object> resMap = new LinkedHashMap();
        resMap.put("status", "success");
        resMap.put("timeProcess", NumberFormat.getNumberInstance(Locale.GERMANY).format(executionTime) + "ms");
        resMap.put("data", result);

        return ResponseEntity.ok(resMap);
    }

    @GetMapping("/getall-masterAccount")
    public ResponseEntity getAllMasterAccount() {

        long startTime = System.currentTimeMillis();

        List<MasterAccounts> result = StreamSupport.stream(ma.findAll().spliterator(), true).collect(Collectors.toList());

        long executionTime = (System.currentTimeMillis() - startTime);

        Map<String, Object> resMap = new LinkedHashMap();
        resMap.put("status", "success");
        resMap.put("timeProcess", NumberFormat.getNumberInstance(Locale.GERMANY).format(executionTime) + "ms");
        resMap.put("data", result);

        return ResponseEntity.ok(resMap);
    }

}
