import java.util.*;
// "static void main" must be defined in a public class.
public class Main {
    private static double max = Integer.MIN_VALUE;
    private static TreeNode maxNode;
    public static void main(String[] args) {
        TreeNode l = new TreeNode(12, Arrays.asList(new TreeNode(11, null), new TreeNode(2, null), new TreeNode(3, null)));
        TreeNode r = new TreeNode(18, Arrays.asList(new TreeNode(15, null), new TreeNode(8, null)));
        TreeNode root = new TreeNode(20, Arrays.asList(l, r));
        TreeNode res = maxAvgSubtree(root);
        System.out.println(res.val);
    }

    public static TreeNode maxAvgSubtree(TreeNode root){
        if(root == null || root.children == null)   return null;
        recursiveCall(root);
        return maxNode;
    }

    public static double[] recursiveCall(TreeNode node){
        int count = 1;
        double total = node.val;
        if(node.children == null) return new double[]{count, total};
        for(TreeNode child : node.children){
            double[] sub = recursiveCall(child);
            count += sub[0];
            total += sub[1];
        }
        double avg = total/count;
        if(count > 1 && avg > max){
            maxNode = node;
            max = avg;
        }
        return new double[]{count, total};
    }
}

class TreeNode {
    public int val;
    public List<TreeNode> children;
    public TreeNode(int val, List<TreeNode> children){
        this.val = val;
        this.children = children;
    }
}