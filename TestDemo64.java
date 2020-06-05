/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo64
 * @Author: LENOVO
 * Date: 2020/5/10 9:05
 * project name: 20200428
 * @Version:
 * @Description:
 */
/*
比较相等 1)==:比较对象身份(引用中存的地址是不是相同)
         2)equals:默认是调用==来比较身份 可以手动重写equals实现按自定义规则比较
                  实现时要注意:a)this和o是不是相同身份
                              b)o是不是null
                              c)o和this是不是相同类型
                              d)对o进行强制类型转换
                              e)按照自定义规则比较
比较大小:
Comparable=>compareTo=>this和o之间的比较
Comparator
例如对于Card类来进行比较
1)对于Comparable来说 必须让Card类来实现Comparable
  a)你要比较的类可能修改不了(类是某个库的类)
  b)Comparable只能指定一种比较规则,指定多种比较规则 还得使用Comparator
  Comparator比Comparable适用范围更广泛
2)对于Comparator来说 是创建一个新的类(CardComparator),然后让这个类实现Comparator 然后完成对Card的比较
 */

