package com.lsepu.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String helloWorld(){
        return "Hello";
    }

    @GetMapping("/hello/{user-name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String pathVariableExample(
            @PathVariable("user-name") String userName
    ){
        return "Hello" + userName;
    }

    @GetMapping("/helloParam")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String queryParamExample(
            @RequestParam("user-name") String userName
    ){
        return "Hello" + userName;
    }



    @PostMapping("/helloPost")
    public String helloWorldPost(
            @RequestBody Order order
    ){
        return "Hello " + order.toString();
    }

    @PostMapping("/helloPost-record")
    public String helloWorldPostRecord(
            @RequestBody OrderRecord order
    ){
        return "Hello " + order.toString();
    }

}
