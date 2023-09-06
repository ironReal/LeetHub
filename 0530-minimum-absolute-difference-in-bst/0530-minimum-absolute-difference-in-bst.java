/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int prev = Integer.MAX_VALUE;
    private int answer = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        searchMin(root);
        return answer;
    }

    public void searchMin(TreeNode node) {
        if (node.left != null) {
            searchMin(node.left);
        }

        answer = Math.min(answer, Math.abs(node.val - prev));
        prev = node.val;

        if (node.right != null) {
            searchMin(node.right);
        }   
    }    
    
}