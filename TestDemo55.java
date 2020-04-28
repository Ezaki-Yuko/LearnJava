/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo55
 * @Author: LENOVO
 * Date: 2020/4/18 9:16
 * project name: 20200418
 * @Version:
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 完全二叉树:
 * 满二叉树:所有节点的度要么是2,要么是0(非叶子节点)
 *
 * 普通二叉树通常是"孩子兄弟表示法"
 * 二叉树的表示通常是"左右孩子表示法"
 */

/**
 * 二叉树的遍历:把每一个数据都访问(和具体的问题场景相关 可以是打印,比较,修改,复杂计算,创建节点,删除节点等)一遍
 *             不重不漏
 *线性结构:顺序表 链表遍历很简单 二叉树不是线性结构了,要约定一定遍历顺序
 *
 * 树的遍历及衍生出的问题
 * 常见遍历方式有四种:1.先序/前序遍历 2.中序遍历 3.后序遍历 4.层序遍历
 * 先序:N L R 中序:L N R 后序: L R N 层序:一层一层
 *
 * 递归执行过程中需要一个额外的空间来保存当前的递归调用关系(栈)
 */
public class TestDemo55 {
    static class Node{
        public char val;
        public Node left;
        public Node right;

        public Node(char val){
            this.val=val;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    static Node build(){
        Node A=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        A.right=C;
        A.left=B;
        B.right=E;
        B.left=D;
        E.left=G;
        C.right=F;
        return A;
    }

    /**
     * 前中后序遍历
     * @param root
     */
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }
    public static void posOrder(Node root){
        if(root==null){
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val+" ");
    }
    //给定一个二叉树 求二叉树中节点的个数
    public static int treeSize=0;
    public static void size(Node root){
        if(root==null){
            return;
        }
        treeSize++; //访问节点操作
        size(root.left);
        size(root.right);
    }
    //直接通过size返回值 返回树的节点
    public static int size2(Node root){
        if(root==null){
            return 0;//空树有0个节点
        }
        //借助递归思想拆分问题
        //整个树的节点个数=根节点个数+左子树节点个数+右节点节点个数
        return 1+size2(root.left)+size2(root.right);
    }
    //求二叉树 叶子节点的个数
    //遍历树 遇到节点进行判断 看当前的节点是不是叶子节点 如果是就size++
    public static int leafSize =0;
    public static void leafSize(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
            return;
        }
        leafSize(root.left);
        leafSize(root.right);
    }
    public static int leafSize2(Node root){
        //思路:借助递归拆分问题
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        //求当前这个这个树叶子节点的个数=左子树叶子节点的个数+右子树中叶子节点的个数
        //没有加1是因为当前节点一定不是叶子
        return leafSize2(root.left)+leafSize2(root.right);
    }
    //求第k层节点的个数
    public static int KLevelSize(Node root,int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            //第一层节点的个数
            return 1;
        }
        //把问题进一步拆分.
        //求树K 层节点个数=左子树k-1层节点个数+右子树k-1层节点个数
        return KLevelSize(root.left,k-1)+KLevelSize(root.right,k-1);
    }

    //在一个二叉树中,查找某个值
    public static Node result=null;
    public static void find(Node root,char toFind){
        if(root==null){
            return;
        }
        if(root.val==toFind){
            result=root;
            return;
        }
        find(root.left,toFind);
        find(root.right,toFind);
    }
    //返回值就表示查找到的节点结果 没找到就返回null
    public static Node find2(Node root,char toFind){
        if(root==null){
            return null;
        }
        //先去看根节点是不是要查找的节点 再递归找左子树
        //如果左子树没找到,再递归找右子树
        if(root.val==toFind){
            return root;
        }
        Node result=null;
        result=find2(root.left,toFind);
        if(result!=null){
            //左子树中找到了 就直接返回 不必找右子树
            return result;
        }
        //左子树没找到,就去右子树递归
        return find2(root.right,toFind);
    }
    //前序遍历把结果放在一个list中 而不是直接打印

    /**
     * 每次方法递归,都会在内存中开辟一块新的栈帧
     * 栈帧中包含这次递归过程中的局部变量
     * @param root
     * @return
     */
    public List<Character> preorderTraversal(Node root){
        List<Character> result=new ArrayList<>();
        if(root==null){
            //空树返回一个空list
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        //访问根节点 此处的访问操作就是把元素添加到result中
        result.add(root.val);
        return result;
    }
    public List<Character> inorderTraversal(Node root) {
        List<Character> result = new ArrayList<>();
        if(root==null){
            //空树返回一个空list
            return result;
        }
        result.addAll(preorderTraversal(root.left));
        result.add(root.val);
        result.addAll(preorderTraversal(root.right));
        return result;
    }
    
    public static void main(String[] args) {
        Node root=build();
        posOrder(root);
        size(root);
        System.out.println(treeSize);
        int size=size2(root);
        System.out.println(size);
    }

}
