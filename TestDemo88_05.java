/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo88
 * @Author: LENOVO
 * Date: 2020/5/28 18:44
 * project name: 20200512
 * @Version:
 * @Description:
 */

/**
 * 数据库中的月数就是针对数据进行的一些校验
 * group by 把得到查询结果集按照一定的规则分组(可能分多组)
 * 有group by就把role相同的记录放在一组 avg是针对每个组来求平均值
 * select role from emp group by role;
 *  select role ,avg(salary) from emp group by role;
 * select role ,min(salary) from emp group by role;
 * select role ,max(salary) from emp group by role;
 * group by 类似于 Hadoop中map reduce操作中的reduce
 * group by中也可以结合一些条件对数据进行进一步筛选 不是使用where 而是having
 * 查找出所有平均工资高于250的岗位和平均薪资
 * select role,avg(salary) from emp group by role having avg(salary)>250;
 * having和where表示不同语义
 * having针对group by聚类之后的结果进行筛选 where针对原始表中的每条记录都进行筛选
 *
 * 联合查询/多表查询
 * 联合查询的基本机制 笛卡尔积
 * 笛卡尔积的结果为:两张表每条记录进行排列组合的结果
 * 多表查询的过程 先计算多个表的笛卡尔积 再基于一些条件针对笛卡尔积中的记录进行筛选
 * 如果针对两个比较大的表进行联合查询,笛卡尔积的计算开销会很大,最终查找效率也就比较低
 * 不应该在生产环境上对大表进行联合查询
 * 面试中考察的SQL语句编写一般都是多表查询
 * 构造一组数据
 * 让mysql 直接批量执行文件中的SQL语句
 *
 * 命令行中:
 * mysql -u root -p < test.sql
 * 重定向 把文件内容重定向到标准输入 等价于把文件内容直接复制粘贴
 * a) 查找名字为许仙的的同学的所有成绩
 * student表中的ID和score表中的student_ID字段对应才是有意义的记录
 * 当前为了干掉笛卡尔积中无意义的数据可以加where语句
 * 姓名包含在student表中 分数在score表中
 * 对这两张表联合
 *
 * 多表查询时写列的时候写成[表名].列名
 * select 字段 from 表1 别名1 [inner] join 表2 别名2 on 连接条件 and 其他条件;
 * select 字段 from 表1 别名1,表2 别名2 where 连接条件 and 其他条件;
 * where中不添加条件得到的就是笛卡尔积的结果
 * 表2中的第一条记录和表一中的每一条记录进行匹配
 * 笛卡尔积
 * select student.id,student.name,score.student_id,score.score from student ,score;
 * 筛选有意义的数据 对应ID相等的 连接条件 当多个表进行笛卡尔积时按照啥样的条件筛选有效记录就是连接条件
 * select student.id,student.name,score.student_id,score.score from student ,score where student.id=score.student_id;
 * 为了查找名字为许仙的成绩信息,就在刚才where基础上再加一个条件,筛选条件
 * select student.id,student.name,score.student_id,score.score from student ,score where student.id=score.student_id and student.name='许仙';
 * 先把两张表联合 得到笛卡尔积 按照studentID对笛卡尔积筛选保留有意义数据 再针对名字进行筛选
 * 多表查询的另一种写法join on
 * 内连接
 * select student.id,student.name,score.student_id,score.score from student inner join score on student.id=score.student_id and student.name='许仙';
 *
 * b)查找所有同学的总成绩以及该同学的基本信息
 * 同学信息是在student中 成绩在score表中 针对student和score联合(笛卡尔积)
 * 筛选条件:按照学生ID来筛选 干掉笛卡尔积中不必要的数据
 * 按照学生ID来group by 求每个同学的总成绩
 * group by 得到的记录数目肯定要比原来少 如果某一列若干值已经相同了,group by没影响
 * select student.id,student.name,sum(score.score) from student,score where student.id=score.student_id group by student.id;
 *
 * c)查找所有同学每一科的成绩和同学的相关信息
 * student course score
 * 线上环境给用户看的 线下环境给公司内部人员看的 需要统计计算一些数据
 * 1.三张表联合
 * 2.按照student.ID和score.student_ID进行筛选
 *select student.id,student.name,course.name,score.student_id,score.course_id,score.score from student,course,score where student.id=score.student_id;
 * 3.针对courseID进行筛选 课程ID
 *  select student.id,student.name,course.name,score.student_id,score.course_id,score.score from student,course,score where student.id=score.student_id and course.id=score.course_id;
 * 4.去掉重复的列 只保留关心的列
 * select student.name,course.name,score.score from student,course,score where student.id=score.student_id and course.id=score.course_id;
 *
 * 仔细观察发现student表中本来有8个同学 最终查询只有7个同学有成绩 score表中没有学号为8的记录
 * 当前进行笛卡尔积后再按照ID筛选
 *  inner join这样的筛选结果一定是同时在两张表中都出现过的.这就叫做内连接
 *
 * outer join 外连接是如果有些数据在student中存在 在score中不存在 或者student不存在 score中存在 这样的记录也能查出来 这样记录叫做外连接
 *
 * left join左连接 在student存在 在score中不存在=>能查到 student不存在 score存在=>查不到
 * right join右连接 在student存在 在score中不存在=>查不到 student不存在 score存在=>能查到
 *
 * 主要以内连接为主
 */
public class TestDemo88 {
}
