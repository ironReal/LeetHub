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

 // Two Easiest In Order Traverse (Java)
class Solution {
    private int count = 1;
    private int answer = -1;

    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return answer;    
    }

    public void search(TreeNode node, int k) {
        if (node == null) {
            return ;
        }

        search(node.left, k);

        if (count++ == k) {
            answer = node.val;
        }

        search(node.right, k);
    }
}