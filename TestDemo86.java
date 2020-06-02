/**
 * @PackgeName: com.bit2
 * @ClassName: TestDemo86
 * @Author: LENOVO
 * Date: 2020/5/23 10:15
 * project name: 20200512
 * @Version:
 * @Description:
 */

/**
 * 二叉树构建字符串1(2(4))(3)
 * 括号省略的规则:
 * 左右子树都为空 左右子树空括号可以省略
 * 左子树为空 右子树非空 不可以省略
 * 左子树非空 右子树为空可以省略
 */
/*class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}*/

//用sb表示最终结果
public class TestDemo86 {
    //StringBuilder线程不安全 不涉及多线程就可以去使用
    //StringBuffer线程安全
    private StringBuilder sb=new StringBuilder();
    public  String tree2str(TreeNode t){
        if(t==null){
            return "";
        }

        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void helper(TreeNode root) {
        if(root==null){
            return;
        }
        //先访问当前节点,此时的访问操作就是把元素加到StringBuilder中
        sb.append("(");
        sb.append(root.val);
        helper(root.left);
        if(root.left==null&&root.right!=null){
            sb.append("()");
        }
        helper(root.right);
        sb.append(")");
    }
}
