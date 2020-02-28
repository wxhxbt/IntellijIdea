public class Main {
    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        TreeNode head2 = new TreeNode(2);
        head2.left = new TreeNode(4);
        System.out.println("Is s the subtree of t?"+isSubtree(head, head2));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return s == t;
        if(s.val == t.val){
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public static boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null || t == null)
            return s==t;
        if(s.val == t.val)
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        else
            return false;
    }
}
