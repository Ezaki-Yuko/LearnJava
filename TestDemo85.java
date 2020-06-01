/**
 * @PackgeName: com.bit
 * @ClassName: TestDemo85
 * @Author: LENOVO
 * Date: 2020/5/23 10:15
 * project name: 20200512
 * @Version:
 * @Description:
 */
//根据前序遍历和中序遍历构建二叉树
//先序遍历结果第一个元素一定是根节点
//先序遍历结果=>根节点+左子树先序结果+右子树先序结果
//中序结果=>左子树中序结果+根节点+右子树中序结果
/*class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}*/
//preorder这个数组的长度和inorder相同
//辅助遍历 能够搞清楚preorder访问到那个元素
//还是通过index记录
public class TestDemo85 {
    private int index=0;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        index=0;
        //借助下面这个方法进行递归 为了更好的描述子树,在方法中加入一对参数
        //表示当前子树对应的中序遍历结果的区间
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    //[inorderLeft,inorderRight)表示当前这个子树的中序遍历区间
    //递归过程中 preorder和inorder参数始终没变 inorderLeft和inorderRight在发生变化
    //inorderLeft inorderRight是判断元素有效
    private TreeNode buildTreeHelper(int[] preoder,int[] inorder,int inoderLeft,int inoderRight){
        if(inoderLeft>=inoderRight){
            //中序区间为空
            return null;
        }
        if(index>=preoder.length){
            //先序中的所有元素都访问完
            return null;
        }
        //根据index取出当前树的根节点的值,并构建根节点
        TreeNode newNode=new TreeNode(preoder[index]);
        //知道根节点 根据根节点去中序中找到左子树和右子树范围
        //左子树对应中序区间是[inorderLeft,pos)
        //右子树对应中序区间是[pos+1,inorderRight)
        int pos=find(inorder,inoderLeft,inoderRight,newNode.val);
        index++;//index只自增一次
        newNode.left=buildTreeHelper(preoder,inorder,inoderLeft,pos);
        newNode.right=buildTreeHelper(preoder,inorder,pos+1,inoderRight);
        return newNode;
    }

    private int find(int[] inorder, int inoderLeft, int inoderRight, int val) {
        for(int i=inoderLeft;i<inoderRight;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
}
/**
 * 根据后序和中序构建一颗二叉树
 * 逆置后序遍历的结果 这个结果相当于是一个镜像的先序"NRL"
 *
 */