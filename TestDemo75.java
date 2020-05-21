/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo75
 * @Author: LENOVO
 * Date: 2020/5/12 19:36
 * project name: 20200512
 * @Version:
 * @Description:
 */

/**
 *度为2的树是二叉树
 * 满二叉树:所有节点的度要么是2 要么是0(非叶子节点)
 * 完全二叉树
 * 在代码中如何表示一个二叉树
 * 孩子兄弟表示法
 * 二叉树通常使用 左右孩子表示法 也可以使用孩子兄弟表示法 也可以使用数组来表示(堆)
 *线性结构按照一条线的顺序一口气循环就完成了
 */

//二叉树的遍历 集合中的元素都访问一遍
//打印 修改 创建节点 删除节点 比较 复杂计算等都是访问

/**
 * 递归执行过程中需要一个额外的空间来保存当前递归的调用关系(栈) 维护一个栈
 * 先序:第一个元素一定是根节点
 * 中序:特点:打印出的第一个值是最左侧的节点
 *           左右子树中序遍历结果正好在根节点的左右两侧
 * 后序:最后一个元素一定是根节点
 * 层序:一层一层从上往下 每一层从左往右
 */
public class TestDemo75 {
    static class Node{
        public char val;
        public Node left;
        Node right;
        //此处没有parent
        public Node(char val) {
            this.val=val;
            //以下两个代码可以省略
            //引用类型的成员变量,会被默认初始化成null
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
    //辅助我们构造测试数据
    static Node build(){
        //通过build方法构建一棵树,返回树的根节点
        Node A=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        E.left=G;
        C.right=F;
        return A;
    }
    //先序
    public static void preOrder(Node root){
        //先访问根节点 递归访问左子树 再递归访问右子树
        if(root==null){
            return;
        }
        //此处的访问用print来表示
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序
    public static void  inOder(Node root){
        if(root==null){
            return;
        }
        inOder(root.left);
        System.out.print(root.val+" ");
        inOder(root.right);
    }
    //后序
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    //求节点个数 对二叉树遍历
    public static int treeSize=0;
    public static void size(Node root){
        if(root==null){
            return;
        }
        treeSize++;
        size(root.left);
        size(root.right);
    }
    //直接通过size返回节点个数
    public static int size1(Node root){
        if(root==null){
            return 0;
        }
        //借助递归思想拆分问题
        //根节点个数+左子树节点个数+右子树节点个数
        return 1+size1(root.left)+size1(root.right);
    }
    //求叶子节点个数 遍历树 遇到节点就进行判断 看当前是不是叶子节点 如果是就size++
    public static int LeafSize=0;
    public static void leafSize(Node root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            LeafSize++;
            return;
        }
        leafSize(root.left);
        leafSize(root.right);
    }
    public static int leafSize1(Node root){
        //借助递归拆分问题
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        //求当前这个树的叶子节点的个数=左子树的叶子个数+右子树叶子结点个数
        //此处没有加一 当前节点一定不是叶子节点
        return leafSize1(root.left)+leafSize1(root.right);
    }
    //第k层结点个数
    public static int KLevelSize(Node root,int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            //第一层
            return 1;
        }
        //问题拆分
        //第k层结点个数=左子树的k-1层结点个数+右子树的k-1层结点个数
        //和根节点无关不需要++
         return KLevelSize(root.right,k-1)+KLevelSize(root.left,k-1);
    }
    //在一个二叉树中 查找某个值是否存在
    //对二叉树进行遍历 依次比较每个节点的值 看和待查找元素是否相等
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
    public  static Node find1(Node root,char toFind){
        if(root==null){
            return null;
        }
        //先看看根节点是不是要查找的元素
        if(root.val==toFind){
            return root;
        }
        //再递归去找左子树
        Node result=find1(root.left,toFind);
        if(result!=null){
            //左子树中找到就直接返回 不必找右子树
            return result;
        }
        //如果左子树中没有找到就去递归找右子树
        return find1(root.right,toFind);
    }
    //核心在于"访问操作"存在差异
    //基于遍历来解决的
    public static void main(String[] args) {
        Node root=build();
        preOrder(root);
        System.out.println();
        inOder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        size(root);
        System.out.println(treeSize);
        int size=size1(root);
        System.out.println(size);
        leafSize(root);
        System.out.println(LeafSize);
        int size1=leafSize1(root);
        System.out.println(size1);
        find(root,'G');
        System.out.println(result);
        Node result=find1(root,'G');
        System.out.println(result);
    }
}