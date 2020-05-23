/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo77
 * @Author: LENOVO
 * Date: 2020/5/19 18:01
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo77 {
    static class Node {
        public char val;
        public Node left;
        Node right;

        //此处没有parent
        public Node(char val) {
            this.val = val;
            //以下两个代码可以省略
            //引用类型的成员变量,会被默认初始化成null
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    //辅助我们构造测试数据
    static Node build() {
        //通过build方法构建一棵树,返回树的根节点
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    //判断两棵树结构相同 节点值相同就是相同
    //这个代码和先序遍历几乎一模一样 访问操作是比较相等
    public boolean isSameTree(Node p,Node q){
        //借助递归对问题进行拆分A.val==B.val&&A.left和B.left是否相等&&A.right和B.right是否相等
        if(p==null&&q==null){
            //都是空树认为相等
            return true;
        }
        //if((p==null&&q!=null)||(p!=null&&q==null)){
            //如果两个树一个为空一个非空,那么最终结果肯定不相等
        if(p==null||q==null){
            //两种写法都可以
            //由于前面还有一个 p q 均为空的条件限制
            return false;
        }
        //按照递归的方式把问题拆分
        //判断p和q是否相等 => p.val ==q.val&& p.left和q.left相等 &&p.right和q.right相等
        return p.val==q.val &&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //判定s中是否包含一个子树和t完全相等
    public boolean isSubtree(Node s,Node t){
        //先序遍历s这个树,访问到某个节点是时,访问操作就是isSameTree
        if(s==null){
            return false;
        }
        //判定s中是否包含t =>先看s和t是否相同||s.left包含t ||s.right包含t
        //访问当前节点
        return isSameTree(s,t)||
        //递归处理左子树
        isSubtree(s.left,t)||
        //递归处理右子树
        isSubtree(s.right,t);
    }
    //二叉树的最大深度
    //代码的执行过程类似于后序遍历 访问根节点的操作是一个稍微复杂一点的计算
    //1+max(左子树的深度,右子树的深度)
    public int maxDepth(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            //叶子节点
            return 1;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
    }
    //平衡二叉树 左右子树高度差不超过1
    //依次遍历每个节点 求节点左右子树高度 计算差值,看这个差值是否符合要求
    public boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        //求左右子树的高度
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        //左右子树高度差<=1&&左子树平衡&&右子树平衡
        return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
                &&isBalanced(root.left)
                &&isBalanced(root.right);
    }
    //对称二叉树 镜像对称
    //判定一棵树是不是对称的 ,对应节点值相同 左右子树刚好相反 和根节点没关系
    //主要看左右子树是否对称 左右子树根节点值相等&&左子树.left和右子树.right对称&&左子树.right和右子树.left对称
    public boolean isSymmetric(Node root){
        if(root==null){
            return true;
        }
        //把判定root是否对称转换成root.left和root.right是否对称
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(Node t1,Node t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        //判定t1和t2是否对称
        return (t1.val==t2.val)&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
}
