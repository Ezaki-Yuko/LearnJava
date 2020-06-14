import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo98
 * @Author: LENOVO
 * Date: 2020/5/31 12:14
 * project name: 20200529
 * @Version:
 * @Description:
 */
public class TestDemo98 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入要修改的学生id:");
        int id=scanner.nextInt();
        System.out.println("输入要修改的学生姓名:");
        String name=scanner.next();
        //1.创建DataSource对象
        DataSource dataSource =new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");
        //2.创建Connection对象和数据库建立连接
        Connection connection=dataSource.getConnection();

        //3.拼装SQL
        String sql="update student set name=?where id =?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);
        //4,执行SQL
        int ret=statement.executeUpdate();
        if(ret==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        //5.关闭资源
        statement.close();
        connection.close();
    }
}
/**
 * ORM框架(把一个对象映射到表的一条记录上)
 * 插入数据=>创建新对象
 * 删除数据=>销毁对象
 * 修改数据=>直接修改对象属性
 * 查看数据=>直接查看对象属性
 * 甚至可以做到不写SQL就能操作数据库
 * java的ORM框架底层支持还是靠JDBC
 * MyBaits:java中广泛使用的ORM框架
 * JPA
 */
//SQL
//索引事务
//JDBC编程
