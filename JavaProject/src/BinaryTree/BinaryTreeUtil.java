package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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

		// 输出1 2 3 4 5 6 7
		System.out.println("分层遍历二叉树节点，宽度优先");
		levelTraversal(root);
		System.out.println("\n\n按层打印二叉树");
		printFromTopToBottom(root);

		// 输出1 2 4 5 3 6 7
		System.out.println("\n前序遍历(递归)");
		preorderTravelsalRec(root);
		System.out.println("\n\n前序遍历(迭代)");
		preorderTravelsal(root);

		// 输出 4 2 5 1 6 3 7
		System.out.println("\n\n中序遍历(递归)");
		inorderTravelsalRec(root);
		System.out.println("\n\n中序遍历(迭代)");
		inorderTravelsal(root);

		// 输出4 2 5 6 3 7 1
		System.out.println("\n\n后序遍历(递归)");
		postderTravelsalRec(root);
		System.out.println("\n\n后序遍历(迭代)");
		postderTravelsal(root);

	}

	// 1.1分层遍历二叉树节点，宽度优先
	public static void levelTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		// 推入队列头部
		queue.push(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			System.out.print(cur.treeID + " ");
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	// 1.2按层打印二叉树
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

	// 2.1前序遍历(递归)
	public static void preorderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.treeID + " ");
		preorderTravelsalRec(root.left);
		preorderTravelsalRec(root.right);
	}

	// 2.2前序遍历(迭代)
	public static void preorderTravelsal(TreeNode root) {
		if (root == null) {
			return;
		}
		// 栈
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			// 出栈栈顶元素
			TreeNode cur = stack.pop();
			System.out.print(cur.treeID + " ");
			// 关键点：先压入右节点，再压入左节点，
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		// ***队列push，pop的操作已经很接近stack的操作了
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.push(root);// push是放到队首
		while (!queue.isEmpty()) {
			TreeNode cur = queue.pop();
			// System.out.print(cur.treeID + " ");
			if (cur.right != null) {
				queue.push(cur.right);
			}
			if (cur.left != null) {
				queue.push(cur.left);
			}
		}
	}

	// 3.1中序遍历(递归)
	public static void inorderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTravelsalRec(root.left);
		System.out.print(root.treeID + " ");
		inorderTravelsalRec(root.right);
	}

	// 3.2中序遍历(迭代)
	public static void inorderTravelsal(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				System.out.print(cur.treeID + " ");
				cur = cur.right;
			}
		}
	}

	// 4.1后序遍历(递归)
	public static void postderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		postderTravelsalRec(root.left);
		postderTravelsalRec(root.right);
		System.out.print(root.treeID + " ");
	}

	// 4.2后序遍历(迭代)
	public static void postderTravelsal(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();// 第一个stack用于添加Node和它的左右节点
		Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出

		stack.push(root);
		while (!stack.isEmpty()) {// 确保所有元素都被转移到第二个stack
			TreeNode cur = stack.pop();// 把栈顶元素添加到第二个stack
			output.push(cur);

			if (cur.left != null) {// 把栈顶元素的左右子节点，都添加到第一个stack中
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}

		while (!output.isEmpty()) {
			System.out.print(output.pop().treeID + " ");
		}
	}

}
