package com.example.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(method = RequestMethod.GET, path = "/")
	List<Message> all() {
		return messageDao.selectAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search")
	Message select(@RequestParam(value = "id", defaultValue = "1") int id) {
		return messageDao.selectById(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/register")
	void insert(@RequestParam(value = "content") String content) {
		Message message = new Message();
		message.content = content;
		messageDao.insert(message);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete")
	void delete(@RequestParam(value = "id") int id) {
		Message message = messageDao.selectById(id);
		messageDao.delete(message);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/update")
	void update(@RequestParam int id, String content) {
		Message message = messageDao.selectById(id);
		message.content = content;
		messageDao.update(message);
	}
}