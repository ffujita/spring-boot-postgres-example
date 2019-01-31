package com.example.message;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
    public String content;
}
