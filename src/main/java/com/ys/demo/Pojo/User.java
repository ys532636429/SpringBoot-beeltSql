package com.ys.demo.Pojo;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title User
 * @date 2020/2/26 12:11
 */
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.Table;

import java.sql.Date;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title User
 * @date 2020/2/25 23:48
 */
@Getter
@Setter
@Table(name="user")
@Data
public class User {
    @AutoID
    private Integer id ;
    private Integer age ;
    //用户角色
    private Integer roleId ;
    private String name ;
    //用户名称
    private String userName ;
    private Date createDate ;



}

