package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTreeUtil {

	public static void main(String[] args) {
		// 根节点
		TreeNode root = new TreeNode("1");
		// 子节点
		TreeNode leftChild = new TreeNode("2");
		TreeNode rightChild = new TreeNode("3");
		root.left = leftChild;
		root.right = rightChild;
		// 第二层子节点
		TreeNode secondLeftChild = new TreeNode("4");
		TreeNode secondRightChild = new TreeNode("5");
		leftChild.left = secondLeftChild;
		leftChild.right = secondRightChild;

		TreeNode secondLeftChild_r = new TreeNode("6");
		TreeNode secondRightChild_r = new TreeNode("7");
		rightChild.left = secondLeftChild_r;
		rightChild.right = secondRightChild_r;

		levelTraversal(root);

		printFromTopToBottom(root);
	}

	// 1.分层遍历二叉树节点，宽度优先
	public static void levelTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		// 推入队列头部
		queue.push(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			System.out.println(cur.treeID);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	// 按层打印二叉树
	public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
		// 当前行最右子节点
		TreeNode last = root;
		// 下一行最右子节点
		TreeNode nLast = root;
		queue.add(root);

		while (!queue.isEmpty()) {
			// 队首
			TreeNode out = queue.poll();
			System.out.print(out.treeID + " ");
			list.add(Integer.parseInt(out.treeID));
			if (out.left != null) {
				queue.add(out.left);
				nLast = out.left;
			}
			if (out.right != null) {
				queue.add(out.right);
				nLast = out.right;
			}
			// 一行遍历完毕，换下一行
			if (out == last) {
				System.out.println("");
				last = nLast;
			}
		}

		return list;
	}

}
