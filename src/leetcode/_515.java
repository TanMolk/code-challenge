package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wei tan
 */
public class _515 {

    public List<Integer> largestValues(TreeNode root) {
        //store the result
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            //Store each level
            Queue<TreeNode> queue = new LinkedList<>();
            //add the first one
            queue.offer(root);

            while (!queue.isEmpty()) {
                //fix the current loop length;
                int length = queue.size();
                //store the max value
                int maxValue = Integer.MIN_VALUE;

                for (int i = 0; i < length; i++) {
                    TreeNode node = queue.poll();
                    maxValue = Math.max(maxValue, node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(maxValue);
            }

        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
