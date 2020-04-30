import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo56
 * @Author: LENOVO
 * Date: 2020/4/21 18:34
 * project name: 20200421
 * @Version:
 * @Description:
 */
public class TestDemo56 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
        public List<Integer> postorderTraversal(TreeNode root){
            List<Integer> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
            return result;
        }
        public boolean isSameTree(TreeNode p,TreeNode q){
            if(p==null&&q==null){
                //如果都是空树 认为相等
                return true;
            }
            if(p==null||q==null){
                //如果一个为空 一个非空 那么最终结果肯定不相等
                //由于前面还有一个都空的限制 这里就是一个空一个非空
                return false;
            }
            //按照递归把问题拆分
            //判定p和q是否相等
            return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        public boolean isSubTree(TreeNode s,TreeNode t){
            //先遍历s这个树 访问到某个节点的时候,"访问"操作就是isSameTree的判定
            if(s==null){
                return false;
            }
            //判定s中是否包含t=>先看s和t是否相同||s.left包含t||s.right包含t
            //访问当前节点
            return isSameTree(s,t)||
            //递归处理左子树
            isSubTree(s.left,t)||
            //递归处理右子树
            isSubTree(s.right,t);
        }
        public int maxDepth(TreeNode root){
            if(root==null){
                return 0;
            }
            if(root.left==null&&root.right==null){
                return 1;
            }
            int leftDepth=maxDepth(root.left);
            int rightDepth=maxDepth(root.right);
            return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
        }
        //平衡二叉树
        public boolean isBalanced(TreeNode root){
            if(root==null){
                return true;
            }
            if(root.left==null&&root.right==null){
                return true;
            }
            //求当前节点左右子树的高度
            int leftDepth=maxDepth(root.left);
            int rightDepth=maxDepth(root.right);
            //当前这个树平衡
            return (leftDepth-rightDepth<=1&&leftDepth-rightDepth>=-1)
                    &&isBalanced(root.left)&&isBalanced(root.right);
        }
        //判定一个树是否对称
        public boolean isSymmetric(TreeNode root){
            if(root==null){
                return true;
            }
            //把判定root是否对称转换成判定root.left和root.right是否对称
            return isMirror(root.left,root.right);
        }
        private boolean isMirror(TreeNode t1,TreeNode t2){
            if(t1==null&&t2==null){
                return true;
            }
            if(t1==null||t2==null){
                return false;
            }
            //判定t1和t2是否对称==t2.val&7t1.left和t2.right是否对称&&t1.right和t2.left是否对称
            return (t1.val==t2.val)&&isMirror(t1.left,t2.right)&&
                    isMirror(t1.right,t2.left);
        }
        //层序遍历
        public void levelOrder(TreeNode root){
            if(root==null){
                return;
            }
            //创建一个队列 初始情况下 根节点加入到队列中
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            //2.进入循环,循环结束条件为队列为空
            while(!queue.isEmpty()){
                //a)取出队首元素
                TreeNode cur=queue.poll();
                //b)访问当前元素
                System.out.println();
                //c)把当前元素的左子树和右子树入队列
                //队列为空 循环结束 说明遍历完毕

            }
        }
    }
}
