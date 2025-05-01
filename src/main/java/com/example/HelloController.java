package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String getHello(@RequestParam String name) {
        return "Hello, " + name ;
    }

    @PostMapping
    public String postHello(@RequestBody String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping(path="json", consumes = "application/json", produces = "application/json")
    public Response postHello(@RequestBody Request req) {
        Response resp = new Response();
        resp.msg = "ok";
        resp.data = req;
        return resp;
    }

    @Getter
    @Setter
    private static class Request{
        String name;
        String desc;


    }

    @Getter
    @Setter
    private static class Response {
        String msg;
        Object data;
    }
}
