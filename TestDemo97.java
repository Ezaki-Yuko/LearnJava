import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo97
 * @Author: LENOVO
 * Date: 2020/5/31 12:07
 * project name: 20200529
 * @Version:
 * @Description:
 */
public class TestDemo97 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要删除的名字:");
        String name=scanner.next();
        //1.创建DataSource对象
        DataSource dataSource =new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");
        //2.创建Connection对象和数据库建立连接
        Connection connection=dataSource.getConnection();

        //3.拼装SQL
        String sql="delete from student where name=?";

        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,name);

        int ret=statement.executeUpdate();
        if(ret==1){
            System.out.println("删除成功");
        }
        statement.close();
        connection.close();
    }
}
