package com.ys.demo.Util;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.MapperCodeGen;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * @author yuanshuai【yuanshuai@tftoken.net】
 * @title DbMain
 * @date 2020/2/25 23:35
 */
public class DbMain {

    private static final String mysqlDriver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
    private static final String userName="root";
    private static final String password="root";

    /**
     * 生成代码
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ConnectionSource source = ConnectionSourceHelper
                .getSimple(mysqlDriver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        //SQL语句放于classpath的sql目录下
        SQLLoader loader = new ClasspathLoader("/sql");
        //数据库命名和java命名一样，所以采用DefaultNameConversion,还有一个UnderlinedNameConversion下划线风格的
        ReDbNameConversion nc = new ReDbNameConversion();
        //最后，创建一个SQLManager,DebugInterceptor,不是必须的，但可以通过它查看SQL的执行情况
        SQLManager sqlManager = new SQLManager(mysql, loader, source, nc, new Interceptor[]{new DebugInterceptor()});
//        或者直接生成java文件
        GenConfig config = new GenConfig();
        config.preferBigDecimal(true);
        config.setBaseClass("org.beetl.sql.core.TailBean");
        MapperCodeGen mapper = new MapperCodeGen("com.ys.demo.dao");
        config.codeGens.add(mapper);

//        sqlManager.genPojoCodeToConsole("t_user", config);

        sqlManager.genPojoCode(
                "user",
                "com.ys.demo.Pojo",
                new File(ResourceUtils.getURL("/java").getPath()).getPath(),
                config);
//
        sqlManager.genSQLFile("user");
    }
}
