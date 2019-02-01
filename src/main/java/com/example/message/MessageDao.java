package com.example.message;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

@ConfigAutowireable
@Dao
public interface MessageDao {
	@Select
	List<Message> selectAll();

	@Insert
	@Transactional
	int insert(Message message);

	@Select
	Message selectById(int id);

	@Delete
	int delete(Message message);

	@Update
	int update(Message message);
}