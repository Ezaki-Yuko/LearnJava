import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo96
 * @Author: LENOVO
 * Date: 2020/5/31 11:41
 * project name: 20200529
 * @Version:
 * @Description:
 */
public class TestDemo96 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource =new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");

        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");
        Connection connection=dataSource.getConnection();
        String sql="select * from student";
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        //遍历过程类似于迭代器
        //结果集相当于一张表 这个表里有很多行每一行是一条记录(又包含很多列)
        //next() 一方面是判定当前是否存在下一行,另一方面,如果存在下一行就直接获取到这一行)
        //可以直观的把resultSet想象成一个光标
        while(resultSet.next()){
            //resultSet的光标指向当前行,就可以把当前行的列数据都获取到
            //当前表中的每一行包含三个列 根据列名获取列数据
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            int classId=resultSet.getInt("classId");
            System.out.println(" id : "+id+" name : "+name+" classId : "+classId);
        }

        resultSet.close();
        statement.close();
        connection.close();
        //1.创建DataSource对象
        //2.创建Connection对象和数据库建立连接
        //3.借助PrePareStatement拼装SQL语句
        //4.执行SQL语句
        //5.遍历结果
        //6.关闭释放资源
    }
}
