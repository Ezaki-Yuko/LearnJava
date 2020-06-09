/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo95
 * @Author: LENOVO
 * Date: 2020/5/31 9:04
 * project name: 20200529
 * @Version:
 * @Description: 数据库编程
 */

//mysql是一个CS结构的系统

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * mysql的客户端(系统自带的客户端 是一个控制台程序)
 *
 * SQL通过网络发送给服务器
 * 服务器(管理和组织数据部分)把执行结果发送给客户端
 *
 * 通过代码来自己实现一个mysql客户端,同样是通过网络和服务器进行交互
 * 数据库给我们提供一组API来自己实现客户端
 * 数据库的种类有很多 不同数据库提供的API不太一样
 * mysql的API和Oracle的API以及SQL Server的API差异很大
 * API 提供一组函数/类/方法,让用户直接使用
 * API有时也称为接口 与interface无关
 *
 * 在java中引入'JDBC' java自带的一组数据库操作的API,这组API
 * 相当于涵盖了各种数据库操作的操作方式 把不同数据库的API统一到一起
 *
 * java自身完成JDBC API和具体数据库API之间的转换
 * 只需要学习JDBC这一套 某个数据库的API的细节就不需要考虑
 *
 * 通过适配器/adapter(转接头) 把不同种类的API转换成JDBC风格统一的API(数据库驱动程序)
 * 不同的数据库需要分别提供不同的驱动程序.
 *
 * 没有转接头就用原生API也可以操作
 *
 * 在java中 这样的驱动程序是一个独立的"jar包"
 *
 * .class=>打一个压缩包(类似于.rar/.zip) .jar
 *
 * maven仓库相当于jar包应用商店
 * 下载的jar包版本必须要和mysql服务器版本一致
 * 1.在IDE的工程中 创建一个目录
 * 2.配置项目属性
 */
public class TestDemo95 {
    public static void main(String[] args) throws SQLException {
        //操作数据库要先和数据库建立连接
        //JDBC里面提供两套API
        //1.创建DataSource对象(准备工作)
        //DataSource对象生命周期是跟随整个程序
        DataSource dataSource = new MysqlDataSource();
        //针对DataSource进行一些配置,以便后面能顺利的访问到数据库服务器
        //URL User,Password 需要进行向下转型
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java16_0531?characterEncoding=utf-8&useSSL=true");
        //向下转型).需要指定访问哪个数据库的服务器 访问哪个服务器中的数据库("协议名固定的//IP地址,Mysql服务器是通过是通过网络访问的IP地址相当于描述要访问网络上哪个主机此处的127.0.0.1是一个特殊的IP地址,表示本机,只要你的mysql服务器是装在本机都可以使用这个IP:端口号(3306)为了区分开一台主机上的多个服务器/要访问的数据库的名字?字符集和数据库服务器配置字符集一致否则就会乱码&可以没有 表示是否要加密访问
        //每个位置用符号分割都是固定的,不能随便写 符合URL(网址)
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("root");
        //2.基于DataSource对象,创建Connection对象,和数据库建立连接 打开客户端 输入密码 连接成功
        //建立连接好了之后就可以进行之后的后续传输
        //测试当前是否准备就绪,能否进行后续的通信
        //收发消息能力
        //Connection是java.sql包中的
        //建立连接的意义是为了验证当前的网络通信是否正常,不正常就会抛出SQLException异常
        //连接不是链接
        //connection对象的生命周期较短,每个请求创建一个新的connection
        Connection connection =dataSource.getConnection();
        //3.PrePareStatement对象拼装具体的SQL语句(客户端输入SQL的过程)
        //先以插入为例
        //当前示例中插入的数据内容都是写死的,其实也可以在运行时获取到 动态拼接上
        int id=1;
        String name="曹";
        int classId=10;
        String sql="insert into student values(?,?,?)";
        //?是一个占位符 把具体的变量值替换到?位置
        //1,2,3相当于?的下标(从1开始计算)
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        //4.拼装SQL之后,需要执行SQL(客户端中敲下回车,此时SQL就发到服务器)
        //inset delete update都可以使用executeUpdate方法执行
        //select就使用executeQuery来执行
        //返回值就表示修改了多少行
        int ret= statement.executeUpdate();
        System.out.println("ret:"+ret);
        //5.查看服务器返回的结果(客户端显示出结果)
        //6.关闭连接 释放资源(退出客户端)
        //后创建的先释放
        statement.close();
        connection.close();
    }
}
/**
 * JDBC编程中主要用到的类/对象
 *
 * 1.DataSource用于配置如何连接Mysql
 * 2.Connection表示建立好的一次连接(操作数据库之前需要先建立连接)
 * 3.PrepareStatement 对应到一个SQL语句
 * 4.ResultSet结果集
 */