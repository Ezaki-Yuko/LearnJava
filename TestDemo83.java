/**
 * @PackgeName: PACKAGE_NAME
 * @ClassName: TestDemo83
 * @Author: LENOVO
 * Date: 2020/5/22 19:54
 * project name: 20200512
 * @Version:
 * @Description:
 */

/**
 * 二叉搜索树转换成排序双向链表
 */
class TreeNode{
    int val=0;
    TreeNode left=null;
    TreeNode right=null;

    public TreeNode(int val) {
        this.val = val;
    }
}
//二叉搜索树:左子树中所有节点都小于根节点 右子树中所有节点都大于根节点(不能存在两个值相同的节点)
//查找过程类似于二分查找
//二叉搜索树的中序遍历结果是有序的
//树的Node 包含left和right 转成双向链表 left指向前一个节点(prev) right指向后一个(next)
//中序遍历(递归) 访问节点操作就是构建链表 把当前节点连接到链表中
public class TestDemo83 {
    //返回值的含义是链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            //只有一个根节点,得到的链表也只有一个节点
            return pRootOfTree;
        }
        //递归处理左子树,把左子树转换成双向链表
        //left就是左子树链表的头结点
        TreeNode left=Convert(pRootOfTree.left);
        //处理根节点,把根节点追加到左子树链表的末尾
        //这就相当于链表尾插,找到前面链表的最后一个节点
        TreeNode leftTail=left;
        while(leftTail!=null&&leftTail.right!=null){
            leftTail=leftTail.right;
        }
        //上述循环结束之后leftTail就是left这个链表的最后一个节点
        //把当前节点尾插过去
        //left为空 leftTail就是空,防止空指针异常
        if(leftTail!=null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //递归处理右子树,right就是右子树链表的头结点
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null){
            //根节点和右子树连接到一起
            right.left=pRootOfTree;
            pRootOfTree.right=right;
        }
        //返回整个链表头结点
        return left!=null?left:pRootOfTree;
    }
}