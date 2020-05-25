import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo79
 * @Author: LENOVO
 * Date: 2020/5/21 15:36
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo79 {
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
    //判断一棵树是不是完全二叉树 基于层序遍历实现的
    //两个阶段 针对这个树进行层序遍历 1.要求每个访问到的节点必须具备两个子树,
    //2.如果遇到某个节点没有子树 或者只有左子树就进入第二阶段
    //如果只有右子树判定完毕,这个树不是完全二叉树 第二阶段要求访问到的节点必须没有子树,如果有子树就不是完全二叉树
    //直到遍历结束也没有找到不符合要求的节点,这个树就是完全二叉树
    public boolean isComplete(Node root) {
        if(root==null){
            return true;
        }
        //这个变量为true 表示当前在第一阶段 为false就是第二阶段
        boolean isFirstStep=true;
        //针对这个树进行层序遍历
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(isFirstStep){
                //第一阶段,要求任意节点必须具备两个子树
                if(cur.left!=null&&cur.right!=null){
                    //当前节点有两个子树,直接把子树入队列,然后往后遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left==null&&cur.right!=null){
                    //当前节点右子树非空 左子树为空
                    return false;
                }else if(cur.left!=null&&cur.right==null){
                    isFirstStep=false;
                    queue.offer(cur.left);
                }else{
                    //当前节点左右子树都为空,还是进入第二阶段
                    isFirstStep=false;
                }
            }else{
                //第二阶段要求任意节点必须没有子树
                if(cur.left!=null||cur.right!=null){
                    //找到反例 直接判定不是完全二叉树
                    return false;
                }

            }
        }
        //树遍历完也没有找到反例就是完全二叉树
        return true;
    }
}