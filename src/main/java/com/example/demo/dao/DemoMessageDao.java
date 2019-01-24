package com.example.demo.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface DemoMessageDao {

    @Select
    String selectById(Integer id);
}
