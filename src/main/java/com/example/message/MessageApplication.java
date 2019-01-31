package com.example.message;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

    @Autowired
    MessageDao messageDao;

    @Bean
    CommandLineRunner runner() {
        return args -> Arrays.asList("なぶ", "Nab", "ナブラーク", "Nablarch").forEach(s -> {
            Message r = new Message();
            r.content = s;
            messageDao.insert(r);
        });
    }

    @RequestMapping(path = "/")
    List<Message> all() {
        return messageDao.selectAll();
    }

    @RequestMapping(path = "/search")
    Message select(@RequestParam(value="id", defaultValue="1") int id) {
    	return messageDao.selectById(id);
    }
}