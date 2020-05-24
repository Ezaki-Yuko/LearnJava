import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo78
 * @Author: LENOVO
 * Date: 2020/5/21 15:25
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo78 {
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

    //层序遍历 借助队列 不是递归
    //循环执行操作 a取出队首元素 b访问这个该元素 c把当前元素的左子树和右子树分别入队列
    //队列为空就是遍历完毕
    public void levelOrder(Node root) {
        if(root==null){
            return;
        }
        //1.创建一个队列
        Queue<Node> queue =new LinkedList<>();
        queue.offer(root);
        //2.进入循环,循环结束条件为队列为空
        while(!queue.isEmpty()){
            //a取出队首元素
            Node cur=queue.poll();
            //b 访问当前元素
            System.out.println(cur.val+" ");
            //c把当前节点左右子树入队列
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
}