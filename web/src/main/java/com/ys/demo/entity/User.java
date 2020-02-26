package com.ys.demo.Util;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2020-02-25
*/
public class User extends org.beetl.sql.core.TailBean  implements Serializable{
	private Integer id ;
	private Integer age ;
	//用户角色
	private Integer roleid ;
	private String name ;
	//用户名称
	private String username ;
	private Date createDate ;
	
	public User() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public Integer getAge(){
		return  age;
	}
	public void setAge(Integer age ){
		this.age = age;
	}
	
	public Integer getRoleid(){
		return  roleid;
	}
	public void setRoleid(Integer roleid ){
		this.roleid = roleid;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	public String getUsername(){
		return  username;
	}
	public void setUsername(String username ){
		this.username = username;
	}
	
	public Date getCreateDate(){
		return  createDate;
	}
	public void setCreateDate(Date createDate ){
		this.createDate = createDate;
	}
	
	
	

}
