import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo76
 * @Author: LENOVO
 * Date: 2020/5/18 21:10
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo76 {
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

    //二叉树的前序 结果放在List中
    //理解这个的核心是 每次方法递归都要在内存中创建一个新的空间开辟栈帧
    //栈帧就是包含这次方法调用中的局部变量
    //某个树的result的内容依赖于左右子树中的遍历结果(左右子树的result)(两个result是不相干的)
    //先序遍历结果=根节点+左子树的先序结果+右子树的先序结果
    public List<Character> preOrderTraversal(Node root) {
        List<Character> result = new ArrayList<>();
        if (root == null) {
            //空树返回空的List 不是null
            return result;
        }
        //访问根节点.此处的访问操作就是把元素添加到result中
        result.add(root.val);
        //递归访问左子树
        result.addAll(preOrderTraversal(root.left));
        //addAll(参数是List) add(参数是元素)存在的意义是 每递归一次都new一个result
        //也可以写成:
        /*List<Character> leftResult=preOrderTraversal(root.left);
        for(Character x:leftResult){
            result.add(x);
        }*/
        //递归访问右子树
        //把参数中的集合里的所有元素都add到当前集合中
        result.addAll(preOrderTraversal(root.right));
        return result;
    }

    //迭代算法/非递归/循环
    //二叉树的中序
    public List<Character> inOrderTraversal(Node root) {
        List<Character> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(inOrderTraversal(root.left));
        result.add(root.val);
        result.addAll(inOrderTraversal(root.right));
        return result;
    }
    //后序
    public List<Character> postOrderTraveral(Node root){
        List<Character> result=new ArrayList<>();

        if(root==null){
            return result;
        }
        result.addAll(postOrderTraveral(root.left));
        result.addAll(postOrderTraveral(root.right));
        result.add(root.val);
        return result;

    }
}

