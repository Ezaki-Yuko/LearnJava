/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo90
 * @Author: LENOVO
 * Date: 2020/5/30 9:03
 * project name: 20200529
 * @Version:
 * @Description: 数据库  mysql-5
 */

/**
 * 1.聚合查询 把若干行结果按照一定的规则合并到一起,进行一些统计计算的查询
 * count sum avg max min 如果没有group by 就是针对整个查询结果集进行统计计算了
 * group by 按照指定的列进行分组,如果某两行的指定列值相同就会被分到一组
 * having 针对聚合后的结果进行筛选
 *
 * 2.多表查询/联合查询
 * 笛卡尔积.
 * 联合查询:先针对多个标记进行笛卡尔积的计算,再针对where或者join on后面的条件来对笛卡尔积进行筛选
 * 内连接 只包含两张表交集
 * 自连接 所有计算机原理的成绩比java高的同学ID
 * 1.先找计算机原理和java课程ID 字符串比较规则是忽略大小写的
 * 2.按照ID在分数表中筛选数据
 * 自连接进行笛卡尔积
 * select s1.student_id,s1.score,s1.course_id,s2.student_id,s2.score,s2.course_id from score s1,score s2 ;
 * 根据学生ID筛选
 * select s1.student_id,s1.score,s1.course_id,s2.student_id,s2.score,s2.course_id from score s1,score s2 where s1.student_id=s2.student_id;
 * 加上课程ID限制
 * select s1.student_id,s1.score,s1.course_id,s2.student_id,s2.score,s2.course_id from score s1,score s2 where s1.student_id=s2.student_id and s1.course_id=3 and s2.course_id=1;
 * 按照分数大小进行比较
 * select s1.student_id from score s1,score s2 where s1.student_id=s2.student_id and s1.course_id=3 and s2.course_id=1 and s1.score>s2.score;
 *
 * 自连接本质上把同一列中的两行记录转换成不同列的
 *
 * 子查询 : 在其他SQL中嵌入查询语句 让我们的查询语句
 * 单行子查询:
 * a) 查询和"不想毕业"同班的同学
 *  select classes_id from student where name='不想毕业';
 * select name from student where classes_id =(select classes_id from student where name='不想毕业');
 * 子查询的结果中只有一行
 * 多行子查询
 * 查询'语文'或者'英文'课程对应的成绩
 * 1.先找到语文英文课程ID
 * select id from course where name='语文' or name='英文';
 * 2. select * from score where course_id =(select id from course where name='语文' or name='英文');
 * ERROR 1242 (21000): Subquery returns more than 1 row
 * //子查询超过一行就不能用= 得用in
 * 借助in来子查询
 * mysql> select * from score where course_id in (select id from course where name='语文' or name='英文');
 * 借助 exists 也能完成子查询
 * 先执行主查询,再触发子查询
 * select * from score where exists (select score.course_id from course where (name='语文' or name='英文')and course.id =score.course_id);
 * 如果字表查询结果集合比较小,就使用in
 * 如果字表查询结果集合比较大,主表集合比较小,就使用exists
 *
 * 合并查询 多个查询结果的结果集合合并成一个集合(需要保证多个结果集之间的的字段类型和数目都得一致)
 * union 查询ID<3 或者名字为'英文'的课程
 * select * from course where id <3 or name='英文';
 * select * from course where id <3 union select * from course where name='英文';
 * 如果两个查询结果存在相同的记录,就会只保留一个
 * 如果不想去重,就可以使用union all
 *
 * 索引和事务,必考
 * 涉及的SQL操作很少,也很简单 重点理解原理
 * 原理要背
 * 关于数据库,面试都考啥
 * 1.给定场景写SQL(简单)
 * 2.数据库的索引(索引是干啥,索引的底层数据结构)
 * 3.数据库的事务(事务是干啥的,事务的特点,事务的隔离级别,不同隔离级别中产生的问题)
 * 4.其他内容(比较琐碎)
 *
 * 索引(index): 一本书的目录(index) 用于加快查找的效率
 * 如果数据库中没有索引,此时查找的时候就需要把整个表遍历一遍
 * student表中没有索引找ID为8学生信息 没有索引 就相当于顺序表查找
 * O(N) 效率低
 *
 * 如果针对顺序表查找 由于顺序表在内存中,内存访问速度快,数据也不多 速度还行
 * 数据库的数据在磁盘上,针对数据库顺序查找,磁盘访问速度慢,且数据量大,速度可能慢
 * 索引就是为了避免数据库进行顺序查找,提高查找效率
 * 索引可以考虑的数据结构 1.二叉树(二叉搜索树) 如果比较平衡 查找效率是O(logN)2.哈希表O(1)
 * 数据库的索引可以考虑使用哈希,但是也有问题 例如 查找ID<6并且>3的学生信息
 * select * from student where id<6 and id>3;
 * 哈希只能处理相等的情况,不能处理其他的逻辑 > >= < <= between and....
 * 哈希的查找过程 : 把key带入哈希函数,计算得到下标,再根据下标取到对应的链表,再去遍历比较key是否相等
 * 二叉搜索树内部的元素是有序的(中序遍历结果有序)
 * 例如还是查找ID<6并且ID>3的学生信息
 * 先找到ID为6的元素
 * 再找到ID为3的元素(按照二叉搜索树典型的方式查找即可)
 * 中序遍历中3和6之间的结果就是想要的结果(效率是O(N))
 *
 * 相比于哈希表 二叉搜索树虽然能处理范围查找,但是处理效率不高
 * 1.二叉搜索树每个节点最多两叉,当数据量比较大的时候树的高度就会比较高,树的高度越高最终操作效率就会越低
 * 2.二叉搜索树获取中序遍历也不是很高效O(N)
 *
 * 真实的索引结构是一种N叉搜索树 => B+树
 *
 * 认识B+树 先认识B树(也写作B-树) -相当于是一个连接号,不是减号
 * B-树
 * 1.每个节点不是二叉 而是N叉
 * 2.每个节点不是存一个数据,而是可能存多个数据
 * 每个节点存的数据的个数和该节点的度是相关的
 * 度=存的数据个数+1
 * 此时在B树上查找就是一个N分查找,效率比二分还快
 * 由于每个节点存了多个数据 和二叉树相比,在保存相同个数元素时,B树的高度就会比二叉树低很多
 *
 * 构造过程与二叉搜索树类似,先找到合适位置再插入
 * B+树和B树相比,主要是两个地方发生变化
 * 1.每一层元素之间都链接都一起
 * 2.数据只在叶子节点上保存,非叶子节点上只保存一些辅助查找的边界信息
 *   数据:表中的一行记录
 *   非叶子节点只保存ID 辅助我们快速找到想要的ID对应的节点
 *   叶子放在磁盘上 非叶子放在内存中 查找范围就更高了 减少读磁盘的次数
 *   索引在内存中占用的实际开销也不高
 *   查询任何一条记录速度都是比较平均的,不会出现效率差异大的情况 不需要进行额外的中序遍历 遍历链表就得到中序结果,处理范围就更高效了
 *
 * 索引起到的效果就是加快查找效率 减慢插入和删除,修改效率(需要同步调整索引结果)
 * 索引不是越多越好 也会占用额外的空间 本质上空间换时间
 * 给具体的表中某列加索引时,加在主键上的索引和加在其他列的索引是截然不同的
 * 主键索引
 * 每个数据是一条记录 根据主键建好索引
 * 如果针对name来建立索引(不是主键)
 * 主键索引的叶子节点存的是数据的完整记录
 * 其他索引的叶子节点存的是主键ID
 * 如果按name查找 先通过索引 找到'王五'对应的主键ID,再根据主键ID去主键索引中查找到具体记录(回表)
 * 索引应用场景 主要是应用在查找很频繁 但是插入删除修改都不频繁的场景[非常常见]
 * 以作业为例 每次布置作业都相当于要进行查找
 * 插入删除修改操作就非常少
 * 创建主键约束 唯一约束 外键约束就会创建对应列的索引
 * 指定外键 student中的classID要关联class表中的ID字段
 * 索引是给关联到的那个对应表建立索引
 * 查看索引 show index
 * 创建索引 create index index_name_student on student(name);(name索引存主键ID 主键索引存整条记录)
 * 删除索引 drop index index_name_student on student;
 * 主键索引上保存整条数据 不能删
 * 跟索引相关的创建删除都是很耗时的 尽量避免线上环境创建删除
 * 与自增无关 只要指定了primary key就是主键索引
 * 1.索引是什么
 * 2.索引要解决的问题
 * 3.索引的应用场景
 * 4.索引的数据结构[重点]
 * a.为什么不用哈希
 * b.为什么不同二叉搜索树
 * c.什么是B树 有什么优势(现场画出来)
 * d.什么是B+树 有什么优势(现场画出来)
 * 其他注意事项
 *
 * explain语句帮助我们分析一个SQL的执行过程
 * 能够看到是否使用索引,以及使用哪个索引 key这个为null就是没有使用索引
 *
 * 事务
 * 解决的问题 (转账问题) 数据表保存一些人的银行账户余额
 * A->B 转3000
 * 分成两个步骤  A的账户-3000 B的账户+3000
 * 如果第一步执行成功 执行2的时候出问题
 * 事务就是把一组操作封装在一起,称为一个共同的执行单元 保证在执行过程中避免上面的问题
 * 事务的基本特征保证了能够解决刚才的问题
 * ACID
 * 1.原子性:事务中的若干个操作 要么全部执行成功 要么全都不执行
 * 不执行并不是真的不执行 一旦某个步骤出错就把前面已经执行完毕的步骤回滚(rollback)回去
 * 回滚:借助逆向操作把原来操作造成的影响全部还原
 * 例如-3000的逆操作 +3000
 * 2.一致性:执行事务前后,数据始终处于一种合法的状态
 * 例如 转账操作,减账户余额的时候不能减成负数
 * 3.持久性:事物一旦执行完毕,此时对数据的修改就是持久生效的(写入磁盘)
 * 数据写到磁盘中就是持久的
 * 数据存储到内存中就是不持久的(重启就没了)
 * 4.隔离性 (很复杂) 涉及到"并发执行事务"(java web开篇讨论的重大话题) 引出一系列问题:脏读,不可复读,幻读=>解决方案=>数据库隔离级别
 * start transaction开启事务 表示接下来的操作都在一个事务中
 *
 * 一旦中间出现失败就会自动回滚
 *
 * commit 事务结束,开始正式执行
 *
 * */

