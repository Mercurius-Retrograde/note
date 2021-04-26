package demo.yvan.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties properties = new Properties();
    static {
        try {
        //加载配置文件
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        //通过load方法将输入流的内容加载到配置文件中
            properties.load(inputStream);
            //通过配置文件对象的getPropertiy()方法获取驱动名，并加载驱动
            Class.forName(properties.getProperty("jdbcName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
        //得到数据库链接的相关信息
        String dbUrl =properties.getProperty("dbUrl");
        String dbName =properties.getProperty("dbName");
        String dbPwd =properties.getProperty("dbPwd");
        //建立数据库连接
            connection = DriverManager.getConnection(dbUrl,dbName,dbPwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
    //关闭
    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection){
        try {
            //判断资源是否被使用；未被使用资源直接关闭出错
            if(resultSet != null){
                resultSet.close();
            }if(preparedStatement != null){
                preparedStatement.close();
            }if(connection != null){
                    connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}