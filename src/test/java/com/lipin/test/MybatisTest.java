package com.lipin.test;


import com.lipin.dao.UserDao;
import com.lipin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis入門例子
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        System.out.println("11111111");
//        1.讀取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

//        2.創建SqlSessionFactory(介面),他是mybatis的核心
        /**
         *mybatis應用都是以一個SqlSessionFactory對象為實例核心
         * 透過SqlSessionFactoryBuilder獲取Config.xml配置文件
         * 然透透過SqlSessionFactoryBuilder來讓SqlSessionFactory介面獲取實例
         */
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

//        3.創建SqlSession(介面)
        /**
         * 有了SqlSessionFactory對象讓SqlSession獲得實例
         */
        SqlSession session = factory.openSession();
//        4.透過SqlSession獲得Dao介面
        /**
         * SqlSession中包含所有以資料庫為背景的sql操作方法
         * 就可以透過此SqlSession來映射sql語句
         */
        UserDao userDao = session.getMapper(UserDao.class);

//         5.執行方法
        List<User> users = userDao.findAll();
        for (User user : users){
//            System.out.println(user);
            System.out.println("username:"+user.getRealname());
        }
//         6.釋放資源
        session.close();
        in.close();



    }
}
