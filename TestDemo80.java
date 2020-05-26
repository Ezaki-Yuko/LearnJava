import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo80
 * @Author: LENOVO
 * Date: 2020/5/21 19:35
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo80 {
    static class TreeNode{
        public char val;//根据数据输入结果,树的每个节点都是一个字符
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    //二叉树的构建及遍历
    //输出的每个元素之间必须使用空格来分割
    //包含空树的先序遍历结果才能构建出一棵树AB### A#B#3
    //不包含空树的先序遍历结果无法构建一棵树
    //二叉树还原的过程本质上还是进行先序遍历.访问元素的过程就是创建节点
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while(scanner.hasNext()){
            //由于在线OJ的输入数据可能有多组,一定要使用循环的方式来处理
            String line=scanner.next();
            //读到先序结果就可以构建树
            //TreeNode root=buildTree(line);
            index=0;//多行输入一定要重新设置成0
            TreeNode root=creatTreePreOrder(line);
            inOrder(root);//输出中序 打印的每个结果要用空格分割
            //每个输出结果占一行
            System.out.println();
        }
    }
    private static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    private static int index=0;//帮助我们在递归中记住当前处理到哪个字符
    //入口
    /*private static TreeNode buildTree(String line){
        //输入数据可能存在多组,每次处理一组新的数据都需要从0开始重新计数
        index=0;
        return creatTreePreOrder(line);
    }*/
    //辅助递归方法
    //每递归一次就处理一个节点(从字符串中取出一个指定字符)
    private static TreeNode creatTreePreOrder(String line){
        char ch=line.charAt(index);
        if(ch=='#'){
            //当前节点是个空树
            return null;
        }
        //如果节点非空,就可以访问这个节点 访问操作就是创建节点
        TreeNode node =new TreeNode(ch);
        index++;//为了处理下一个节点
        node.left=creatTreePreOrder(line);
        index++;//再去处理下一个节点
        node.right=creatTreePreOrder(line);
        return node;
    }
}