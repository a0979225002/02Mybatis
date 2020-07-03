package com.lipin.dao;


import com.lipin.domain.User;

import java.util.List;

//用戶持久層介面
public interface UserDao {

    /**
     * 查詢所有操作
     */
    List<User> findAll();
}
