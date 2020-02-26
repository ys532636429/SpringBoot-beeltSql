package com.ys.demo.Controller;

import com.ys.demo.Pojo.User;
import com.ys.demo.Service.UserService;
import com.ys.demo.Util.ExcelExport;
import io.swagger.annotations.ApiOperation;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title TestController
 * @date 2020/2/25 22:17
 */

@RestController
@RequestMapping(value = "/user")
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    private SQLManager splManager;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "根据Id查询用户")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }
    @GetMapping("/list")
    @ApiOperation(value = "查询所有用户")
    public List<User> listAll(){
        List<User> userList = userService.selectAll();
        return userList;
    }
    @GetMapping("/list/{page}")
    @ApiOperation(value = "分页查询所有用户")
    @ResponseBody
    public List<User> pageListAll(@PathVariable("page") Integer page){

        List<User> userList = userService.pageUserList(page,10);
        return userList;
    }
    @PostMapping("/add")
    @ApiOperation(value = "用户信息新增")
    @ResponseBody
    public String add(@RequestBody  User user){

        Boolean de = userService.insertUser(user);
        String result="";
        if (de){
            result="新增成功";
        }else {
            result="新增失败";
        }
        return result;
    }
    @PostMapping("/update")
    @ApiOperation(value = "用户信息修改")
    @ResponseBody
    public String updateUser(@RequestBody  User user){
        int count = userService.updateUserById(user);
        String result="";
        if (count>0){
            result="修改成功";
        }else {
            result="修改失败";
        }
        return result;
    }

    @GetMapping("/exprot/excel")
    @ApiOperation(value = "用户导出")
    public void exprotExcel(HttpServletResponse response){

        //创建一个数组用于设置表头
        String[] arr = new String[]{"ID","名字","年龄","用户名","角色","创建时间"};

        //调用Excel导出工具类
        ExcelExport.export(response,userService.selectAll(),arr);

    }
}
