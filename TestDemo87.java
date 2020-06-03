/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo87
 * @Author: LENOVO
 * Date: 2020/5/24 21:04
 * project name: 20200512
 * @Version:
 * @Description:
 */

import java.util.Stack;

/**
 * 二叉树的非递归遍历
 * 一般非递归方式实现递归操作都需要用到栈
 * 先序遍历:1)创造一个栈 初始情况下 把根节点入栈
 *          2)进入循环
 *            a)取栈顶元素(出栈)
 *            b)访问该元素
 *            c)如果该元素右子树不为空就入栈;如果该元素左子树不为空也入栈 当栈为空的时候,遍历就完成了
 */
//先序遍历
public class TestDemo87 {
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode top=stack.pop();
            System.out.println(top.val+" ");
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null){
                stack.push(top.left);
            }
        }
    }
    //中序遍历也是需要依赖一个栈
//1.设定一个cur引用 从root出发 只要cur不为空 就把cur入栈 同时cur往左移动
//2.cur为空 此时栈顶元素就是当前最左侧元素 出栈并访问栈顶元素
// 3.让cur指向被访问节点右子树循环执行1,2步骤
    public void inOrder(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(true){
            //1.cur一直往左找循环入栈 知道cur为空
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //2.取栈顶元素并访问 如果遇到空栈就访问完毕了
            if(stack.empty()){
                break;
            }
            TreeNode top=stack.pop();
            System.out.print(root.val+" ");
            //3.cur从top的右子树出发,重复1,2
            cur=top.right;
        }
    }
    //后序遍历 和中序相似
    //依赖一个栈
    //1.创建一个cur从root出发
    //只要cur不为空 就把cur入栈 同时往左移动
    //2.cur为空 取栈顶元素,看能不能访问
    //在后序遍历中右子树的根节点和根节点是相邻的
    //能访问:栈顶元素右子树为null 栈顶元素右子树已经被访问过了
    //3.如果当前栈顶元素不满足访问条件 cur从栈顶元素右子树出发 继续进行1,2

    public void posOrder(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        //pre用来记录上一个被访问过的节点 初始情况下没有任何节点被访问过
        TreeNode pre=null;
        while(true){
            //1.cur循环往左找,遇到非空节点都入栈
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //2.取栈顶元素看能不能访问这个元素
            //右子树为空
            //右子树被访问过
            if(stack.isEmpty()){
                //遍历结束
                break;
            }
            TreeNode top=stack.peek();//只是取元素判断 不能出栈
            if(top.right==null||top.right==pre){
                System.out.print(top.val+" ");
                stack.pop();
                pre=top;
            }else{
                //3.让cur从top.right出发 继续循环1,2
                cur=top.right;
            }
        }
    }
}

