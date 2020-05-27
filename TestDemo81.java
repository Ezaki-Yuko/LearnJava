import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo81
 * @Author: LENOVO
 * Date: 2020/5/21 21:03
 * project name: 20200512
 * @Version:
 * @Description:层序遍历
 */
//解决方法还是层序遍历 加上一个辅助参数  用来表示当前节点的层数  根据这个层数来决定这个节点应该在哪行
public class TestDemo81 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //把结果作为一个成员变量来使用
    //递归过程中每层递归方法都可以很方便的操作同一个结果
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root==null){
            return result;
        }
        //对我们的树进行先序遍历 递归时需要加上一个层数作为参数 从0开始算
        //最好加上clear 防止多组数据的操作
        result.clear();
        levelOderHelper(root,0);
        return result;
    }
    private void levelOderHelper(TreeNode root,int level){
        if(level==result.size()){
            //当前level在result中没有对应的行
            //防止下面的get操作 出现下标越界
            //第一次调用当前方法level是0 result.size()也是0,如果没有add操作 此时get(level)就会触发下标越界异常
            //首次访问到这一行时add 后续再访问的时候已经存在就不要创建了
            result.add(new ArrayList<>());
        }
        List<Integer> curRow=result.get(level);
        curRow.add(root.val);//先序遍历的"访问操作"
        if(root.left!=null){
            levelOderHelper(root.left,level+1);
        }
        if(root.right!=null){
            levelOderHelper(root.right,level+1);
        }
    }
}
