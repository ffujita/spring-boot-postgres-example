package com.example.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/message")
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

	@Autowired
	MessageDao messageDao;

	@GetMapping("/")
	List<Message> all() {
		return messageDao.selectAll();
	}

	@GetMapping("/{id}")
	Message select(@PathVariable("id") int id) {
		return messageDao.selectById(id);
	}

	@PostMapping("/register")
	void insert(@RequestParam String content) {
		Message message = new Message();
		message.content = content;
		messageDao.insert(message);
	}

	@PostMapping("/delete")
	void delete(@RequestParam int id) {
		Message message = messageDao.selectById(id);
		messageDao.delete(message);
	}

	@PostMapping("/update/{id}")
	void update(@PathVariable int id, @RequestParam String content) {
		Message message = messageDao.selectById(id);
		message.content = content;
		messageDao.update(message);
	}
}