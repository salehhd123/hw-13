package com.example.hw13.Controller;

import com.example.hw13.Model.Task;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping("/api/v1/task")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> get(){
        return tasks;
    }

    @PostMapping("/add")
    public String add(@RequestBody Task t){
        tasks.add(t);
        return "the task is added !";
    }

    @PutMapping("/update/{index}")
    public String update(@RequestBody Task t , @PathVariable int index){
        tasks.set(index,t);
        return "the taks is updated";
    }

    @DeleteMapping("/delete/{index}")
    public String delete(@PathVariable int index){
        tasks.remove(index);
        return "the task deleted";
    }

    @PutMapping("/state/{index}")
    public String state(@PathVariable int index){
        Task l = tasks.get(index);
       if (l.getStatus().equals("done")){
           l.setStatus("not done");
       }else {l.setStatus("done");}
        return "state changed !";
    }
    @GetMapping("/search/{name}")
    public  Task getI( @PathVariable String name){
        Task l = new Task();
        for(int i =0;i<tasks.size();i++){
            if(tasks.get(i).getTitle().equals(name)){
                 l = tasks.get(i);
            }
        }
        return l;
    }








}
