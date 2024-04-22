package vincent.algorithm;


/**
 * 判断是否是平衡二叉树。左右腿 之差不能大于1
 */
public class A6BalanceTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    public static boolean isBalance(TreeNode treeNode){
        if(treeNode == null){
            return true;
        }
        int l = getDepth(treeNode.left);
        int r = getDepth(treeNode.right);
        if(Math.abs(l - r) <= 1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 神奇的递归++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 先左腿 探底，递归 3 次，出来就会 + 3 次1
     * @param treeNode
     * @return
     */
    public static int getDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int left = getDepth(treeNode.left);
        int right = getDepth(treeNode.right);
        return (left > right ? left : right) + 1;
    }

    /**
     * 0
     * 1 11
     *     22
     *       33
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(11);
        root.setLeft(l1);
        root.setRight(r1);
        TreeNode r2 = new TreeNode(22);
        root.getRight().setRight(r2);
        TreeNode r3 = new TreeNode(33);
        root.getRight().getRight().setRight(r3);
        System.out.println(isBalance( root));
    }

}
