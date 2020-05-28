/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo82
 * @Author: LENOVO
 * Date: 2020/5/21 21:47
 * project name: 20200512
 * @Version:
 * @Description:
 */
public class TestDemo82 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //公共祖先就是两个节点的共同的祖先 自己也可以是自己的祖先
    //最近公共祖先 取公共祖先中离目标节点最近的祖先
    //靠递归 从根节点出发 同时找给定的两个节点
    //查找=>比较根节点+左子树查找+右子树查找
    //查找的情况:
    //1.从该节点出发,两个节点都没找到(该节点不是公共祖先)
    //2.从该节点出发,只找到其中一个节点(该节点只是一个节点的祖先,不是公共祖先)
    //3.从该节点出发,如果两个节点都找到了就是公共祖先
    //4.如果找到的两个目标节点分散在三个位置的两处,此时该节点就是最近公共祖先(三个位置 左子树 右子树 根节点)
    //如果同时出现在该节点的左子树/右子树,此时该节点一定不是最近公共祖先
    //针对每个子树都去查找pq
    //借助这个成员变量保存最近公共祖先
    private TreeNode lca=null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    //如果找到p/q返回true
    private boolean findNode(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }
        //后序遍历
        int left=findNode(root.left,p,q)?1:0;
        int right=findNode(root.right,p,q)?1:0;
        //访问根节点
        int mid=(root==p||root==q)?1:0;
        if(left+right+mid==2){
            lca=root;
        }
        return (left+right+mid)>0;
    }

}
