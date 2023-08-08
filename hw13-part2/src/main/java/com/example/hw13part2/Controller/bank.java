package com.example.hw13part2.Controller;

import com.example.hw13part2.Model.Customers;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class bank {
ArrayList<Customers> customers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Customers> getTodos(){
        return customers;
    }

    @PutMapping("/update/{index}")
    public String update(@RequestBody Customers c , @PathVariable int index){
        customers.set(index,c);
        return "updated";
    }

    @PostMapping("/add")
    public String add(@RequestBody Customers c){
        customers.add(c);
        return "added";
    }

    @DeleteMapping("/delete/{index}")
    public String delete(@PathVariable int index){
        customers.remove(index);
        return "deleted";
    }

    @PutMapping("/deposit/{index}/{amount}")
    public Customers Deposit(@PathVariable int index,@PathVariable int amount){
        Customers l = customers.get(index);
        int n = l.getBalance()+amount;
        l.setBalance(n);
        return l;
    }

    @PutMapping("/withdraw/{index}/{amount}")
    public String Withdraw(@PathVariable int index,@PathVariable int amount){
        Customers l = customers.get(index);
        if(amount>l.getBalance()){
            return "you do not have enough money";
        }else {
            l.setBalance(l.getBalance()-amount);
            return "the Withdraw is done";
        }
    }







}
