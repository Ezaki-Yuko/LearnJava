/**
 * @PackgeName: com.bit2
 * @ClassName: TestDemo84
 * @Author: LENOVO
 * Date: 2020/5/22 20:00
 * project name: 20200512
 * @Version:
 * @Description:
 */
/**
 * 1.查看数据库
 * Mysql服务器是一个数据库软件 这个软件运行过程中可以维护多个逻辑上的数据库(若干个表的集合就可以理解成一个逻辑上的数据库)
 * 可以把多个数据库放在同一个Mysql服务器上
 * show databases;
 * 2.创建数据库
 * create database[数据库名];
 * Mysql中的SQL绝大部分需要带分号
 * Mysql默认字符集是拉丁文
 * 3.使用数据库
 * 当前有多个数据库 使用操作选中某个数据库 接下来的操作都针对这个数据库
 * cmd中的复制粘贴 选中内容 回车 赋值 鼠标右键粘贴
 * mysql里不太方便看到当前选中的是哪个数据库 MariaDB更方便
 * 4.删除数据库
 * drop database[数据库名];
 * 删除操作非常危险 一旦删除通过常规手段无法找回
 * IDEA专业版可以直接连接数据库 数据库的客户端集成在IDEA中
 * 开启Mysql的binlog功能 每次针对数据库进行的操作都会被记录在binlog中
 * 万一被毁 可以重新把binlog中的所有操作再倒入一遍 (这里的内容不一定全)
 * if exists判断是不是存在
 * 有了数据库之后要想真的去存储组织数据,还需要数据表 创建表就需要指定表结构,表结构中涵盖了有哪些字段,以及每个字段的类型
 * 常见的数据类型
 * int
 * double
 * decimal
 * varchar
 * text
 *  M 是数字总位数(有效数字)，D是小数点后面的位数，
 *表操作
 * 表操作之前必须要先use数据库再建表
 * 1.先创建表 if not exists
 * 创建表的时候 如果表名和列名和SQL中的关键字重复了,就会报错
 * 可以把名字冲突的部分用反引号(`)引起来 就能解决这个问题
 * mysql> create table student (
 *     -> id int,
 *     -> name varchar(20)
 *     -> );
 *
 *2.查看表结构
 *  desc student;
 *3.删除表 也是很危险的操作 也可以搭配if exists
 * drop table student2;
 * 4.查看有哪些表
 * show tables;
 * 5.mysql表的增删改查
 * CRUD create retrieve update delete
 * 5.1插入操作
 * into可以省略
 *  insert into student values(1,'test',98.5,'test@qq.com');
 *  插入的字段数目和类型需要和表结构中要求的一致
 *  双引号单引号都可以
 *  查看数据
 *  select*from[表名];
 *  *是一个通配符 意思是把所有的列都查找出来
 *  5.2指定列插入 根据需要只插入某几列
 *  树木和类型要对应 指定的列都得在表头中存在 要想正确插入中文 必须指定数据库字符编码方式
 *  修改my.ini配置文件 修改之前先备份 防止不能还原
 *  5.3一个insert语句插入多组数据
 *   insert into student (id,name) values (3,'罗志祥'),(4,'蔡阿姨');
 *   0.06sec 60ms 就是蜗牛爬
 *   操作内存 ns级
 *   操作磁盘 us级
 *   访问网络 ms->s级
 *   关系型数据库由于对数据进行大量校验 所以牺牲性能换来数据完整性和可靠性
 *   正因为关系型数据库效率比较低 在一个高并发系统中 数据库可能成为性能瓶颈 是极端情况下最容易挂的服务
 */
/**
 * 数据库在磁盘上组织大量数据(应用到数据结构)
 * 常见数据库:MySQL Oracle (关系型数据库)
 * 按照数据表的形式组织数据 一个数据库包含若干表 每个表有很多字段 每一行就是一条数据记录
 * SQL结构化查询语言(编程语言)
 * MySQL客户机服务器结构
 * 服务器是本体 是用来真正存储和管理数据的
 * 客户端通过网络访问客户端 (SQL) 服务器通过网络响应客户端(操作结果)
 * 非关系型数据库 MongoDB
 * 表中的查找:
 * 1.全列查找 select * from [表名];只适合在测试环境使用 一定不要在生产环境中使用
 * 生产环境的服务器压力本来就很大 同时生产环境的 数据库数据量非常多 一旦执行上面的语句可能就会给生产环境的服务器造成很大的负担
 * 服务器卡死或宕机 生产环境的服务器宕机就会造成恶劣影响 操作生产环境要谨慎
 *2.指定列查找
 * select [列名]from[表名];
 * 3.查询字段为表达式
 * 针对查到的列进行一定的表达式计算
 * a. select name,chinese+english+math from exam_result;
 * 查找所有同学语文成绩 并在基础上加10
 *  b. select name,chinese+10 from exam_result;
 *  select name,chinese+math+english as total from exam_result;
 *  命名 as可以省略
 *sum试求多行数据的和 此处是求多列数据的和
 * 表达式计算达到的结果类型不一定和原来的列类型完全一致会尽可能保证数据是正确的的
 * 4.列求和就是同一行中的若干列加到一起(一个人的各科成绩) 行求和就是同一列的不同行加到一起(同一科的总成绩)
 * 去重查找得到的结果得到的表行数可能和原来的不一样
 * select得到的结果也相当于是一张表(mysql构造的一个临时表)
 * select distinct chinese from exam_result;
 * 5.指定多列来去重 要求指定列完全相同才可以去重
 * select distinct chinese,math from exam_result;
 * 使用distinct的时候必须把对应的列放在distinct后面
 * 所有select操作不会对原来的表造成任何改变 insert update delete
 * select只是基于原来的表来生成一个结果表
 *6.排序
 * order by指定列排序
 * 升序排序 asc可以不写
 * select * from exam_result order by math asc;
 * 降序排序
 *  select * from exam_result order by math desc;
 *  按总成绩排序
 *  select name,chinese+math+english from exam_result order by chinese+math+english;
 * 总程序使用别名排序
 * select name,chinese+math+english as total from exam_result order by total;
 * 按照多个列来排序
 * 先把所有同学信息按照语文降序排序 再按照数学降序排序 再按照英语降序排序
 * 优先级不一样
 *  select * from exam_result order by chinese desc,math desc,english desc;
 *  null会被当成最小的
 *  7.条件查询[特别重要]
 *  > < = >= <=
 *  =是比较相等 不是赋值(update中的=相当于赋值) null=null =>null 相当于条件不成立 如果表达式是null<=>null=>true 条件成立
 *  <=> :针对null进行比较 比较相等
 *  != <>不等于
 *  between x and y:表示当值在[x,y]闭区间都是满足条件
 *  in (若干个选项) 当前值在()中若干选项里匹配一个就是满足条件
 *  is null
 *  is not null 专门用于判定值是否为空
 *  like 模糊匹配
 *  and 逻辑与
 *  or 逻辑或
 *  not 逻辑取反
 *  a)查找数据中语文成绩为空的
 *  错误写法select * from exam_result where chinese = null;
 *  正确:select * from exam_result where chinese <=> null;
 *  正确:select * from exam_result where chinese is null;
 *   b) 查找英语成绩不及格的同学信息
 *    select * from exam_result where english<60;
 *   c)查找语文成绩比英语好的同学信息
 *   select * from exam_result where chinese>english;
 *   d) 查找总分在两百分以下的
 *   where中不能使用别名
 *   错误的select name,chinese+math+english as total from exam_result where total<200;
 *    select name,chinese+math+english as total from exam_result where chinese+math+english<200;
 *   e)查询语文成绩大于80 并且英语成绩也大于80的同学
 *   select * from exam_result where chinese>80 and english>80;
 *   f)查询语文成绩大于80 或者英语成绩大于80的同学
 *    select * from exam_result where chinese>80 or english>80;
 *    and 和or同时出现and优先级更高 还是推荐括号
 *  g)查询语文成绩在[80,90]之间的同学
 *  mysql中 如果针对null进行比较或者算术运算的值也是null
 *  between前面比后面小
 *  select * from exam_result where chinese >=80 and chinese <=90;
 *  select * from exam_result where chinese between 80 and 90;
 *  h)查询数学成绩是45.0或者60.0的
 *  select * from exam_result where math in(45.0,60.0,90.0);
 *  select * from exam_result where math=45.0 or math=60.0 or math =90.0;
 *  like操作搭配通配符使用
 *  % 匹配任意个任意字符 _:匹配一个任意字符
 *  i)查找所有姓孙的同学的成绩
 *  select * from exam_result where name like 'K%';
 *  模糊匹配查询效率相对较低 _只有一个匹配不到Karsa 需要4个
 *  select * from exam_result where name like 'K____';
 *  j) 查找所有同学中语文成绩9开头的
 *  select * from exam_result where chinese like '9%';
 *  k)查找所有同学中姓孙并且语文成绩大于60的同学
 *    进行复杂查询存在最左原则
 *    推荐select * from exam_result where  name like'K%'and chinese>40;
 *    后面两个条件都是过滤 推荐 name like在前面
 *    先针对第一个条件遍历表中的所有记录 最终保留6条 再遍历6条留下满足第二个条件的记录
 *    多个条件联合生效的时候 哪个条件过滤的数据多,就把该条件放在左侧
 *    第一次遍历都需要遍历全表
 *  8.分页查找
 *    避免出现数据库卡死
 *    信息太多就会分页
 *    上面的这些select操作除了条件查找之外剩下的都是不应该在生产服务器上执行的
 *    最保险的就是加上分页查找
 *    相当于把查找结果只选取其中的一小部分作为结果
 *    a)查找总分最高前三名
 *    select name,chinese+math+english as total from exam_result order by total desc limit 3;
 *    b)查找总分最高的4-6名
 *    select name,chinese+math+english as total from exam_result order by total desc limit 3 offset 3;
 *    offset 3可以当成下标 从0开始计数
 *    c)如果limit后面的数字太大 超出记录的数目 返回结果不会有错误
 *    d)如果offset过大 可能得到一个空的结果
 * 修改
 * update [表名] set[列名]=[修改的值],[列名]=[修改的值] where子句
 * > update exam_result set math=80;如果不加任何where限定条件就会把所有记录进行更改
 *  update exam_result set math=80 where name='mlxg';
 * 一次修改两个
 * update exam_result set math=80,chinese=95 where name='维克多';
 * 所有同学的语文成绩都减十分
 *  update exam_result set chinese=chinese-10 ;
 *  将总成绩倒数三名的同学的数学成绩加十分
 *  matched是匹配到的 changed是修改的  涉及到null可能会出现差异 一般来说会相等
 *  删除操作 谨慎进行
 *  delete from [表名] where[条件]
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 数据库的约束
 * 1.not null 不能为空
 * create table student (id int not null,name varchar(20),score decimal(3,1));
 * 不成功:insert into student values(null,'提莫',90.5);
 * 2.unique 不能重复
 * unique限制同一个列里面的行之间不能重复,列和列之间不受影响
 * create table student(id int unique,name varchar(20),score decimal(3,1));
 * 可以同时使用 not null和unique
 * 3.default默认值
 * create table student(id int not null,name varchar(20) default 'unknown');
 * 4.主键约束 not null +unique
 * create table student(id int primary key,name varchar(20));
 * 创建一张表最好指定一个主键
 * 如何保证主键不重复 可以借助数据库自动生成auto_increment 自增主键
 * 自增都是跟着上一条往下排
 * create table student(id int primary key auto_increment,name varchar(20));
 * 自增的特点是 如果表中没有任何记录 自增从1开始 如果有就是从上一条记录往下自增
 * 如果中间某个数据删掉,再次插入数据 刚才删掉的自增主键的值不会被重复利用
 * 如果是一个int类型的自增主键,有效范围就是-21亿->+21亿
 * 外键关联两个表
 *
 * 指定三方面信息
 * 指定当前表中哪列进行关联
 * 指定和哪张表关联
 * 指定和目标表中的哪列关联
 * 后续往student插入数据是mysql就会自动检查当前classID字段的值是否存在在class表中
 * 外键约束会影响表的删除
 * 使用外键对插入操作效率产生一定影响
 *create table student(id int primary key auto_increment,name varchar(20),classId int,foreign key(classId)references class(id));
 * class表被其他表关联 无法直接删除class表
 * 如果真的把class删了再对student的classID列进行任何操作都无意义
 *
 * 数据库表设计涉及到的实体间的关系
 *
 * 一对一关系
 * 一对多关系 通过外键建立关联关系
 * class(id name)
 * student(id name classId)
 * student表中可能存在很多条记录,很多条中的记录 classID可能是相同的,classID相同的记录表示是存在在同一个班级中
 * mysql不支持 class表(ID name student) student列当成数组 但是mysql中没有数组 不支持
 *
 * 多对多就需要引入中间表来
 * 描述每个同学每一科考了多少分
 * student course score/多表查询
 * courseID可能存在很多重复 studentID也是 很多同学修一门课 一个同学修多门课courseID和studentID是外键
 *   更加复杂的插入操作结合select操作
 *  可以把其他select查找的数据作为新增的数据
 *   insert into user2 select name,decription from user;
 *   子查询得到的列的数目,顺序,类型都得和被插入的表的列的数目,顺序类型一致,列的名字不一致无所谓
 *   多个SQL一起拼装,可以拼装出更复杂的SQL套娃,select和select也可以拼装
 *
 *  聚合查询 一般需要搭配 mysql 中的一些内置函数
 *  count计算结果的行数 count不计算null的值
 *  //下面这行写法开销更大些
 *  select count(*) from user;相当于计算select* from user的结果
 *  select name from user
 *  select count(name) from user;
 * count本来是一个函数 如果和(name)存在空格 就是把count当成一个列了
 * sum avg max min针对不是数字没意义
 * select min(score) from student;
 * select avg(score) from student;
 * select min(score) from student;
 * select sum(score) from student;
 * 所有分数小于90的同学的平均分
 * select avg(score) from student where score<90;
 *
 *
 * */




