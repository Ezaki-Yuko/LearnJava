package com.bit.demo6;

import java.util.Arrays;

/**
 * @PackgeName: com.bit.demo6
 * @ClassName: TestDemo26
 * @Author: LENOVO
 * Date: 2020/4/2 20:58
 * project name: 20200402
 * @Version:
 * @Description:
 */
class Student implements Comparable<Student>{
    public int age;
    public String name;
    public int score;
    public Student(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age<o.age){
            return -1;
        }
        if(this.age==o.age){
            return 0;
        }
        return 1;
        //return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score=" + score +
               '}';
    }
}
public class TestDemo26 {
    public static void main(String[] args) {
        Student[] student=new Student[3];
        student[0]=new Student(10,"gaobo",89);
        student[1]=new Student(12,"bit",99);
        student[2]=new Student(15,"caocao",99);
        Arrays.sort(student);
        //把数组当中的元素转化为字符串的时候,会调用Student的toString方法
        System.out.println(student[0].toString());
        System.out.println(Arrays.toString(student));
        System.out.println(student);
    }
    public static void main1(String[] args) {
        int[]array={18,1,8,3,8,10};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(array);
    }
}
