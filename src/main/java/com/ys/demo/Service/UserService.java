package com.ys.demo.Service;

import com.ys.demo.Pojo.User;
import com.ys.demo.dao.UserDao;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title UserService
 * @date 2020/2/25 23:56
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    private SQLManager splManager;

    public User getUserById(Integer id) {
        return userDao.unique(id);
    }
    public List<User> selectAll (){
        return userDao.all();
    }


    public List<User> pageUserList(long pageNumber, long pageSize) {
        User record = new User();
        record.setName("");
        Query<User> query = splManager.query(User.class);
        List<User> list = query .limit(pageNumber, pageSize)
                .select();
        //List<User> queryList = splManager.getPageSqlScript("1").mappingSelect(User.class);
        return list;
    }

   /* public PageQuery<User> pageBlog(long pageNumber, long pageSize) {
        LambdaQuery<User> query = userDao.createLambdaQuery()
                .andEq(User::getDeleteFlag, false);
        return query.page(pageNumber, pageSize);
    }*/

   public Boolean insertUser(User user){
       userDao.insertTemplate(user);
       return true;
   }

   public Integer updateUserById(User user){
       return userDao.updateById(user);
   }
}
