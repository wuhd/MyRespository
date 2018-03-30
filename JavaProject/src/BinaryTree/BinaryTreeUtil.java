package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTreeUtil {

	public static void main(String[] args) {
		// ���ڵ�
		TreeNode root = new TreeNode("1");
		// �ӽڵ�
		TreeNode leftChild = new TreeNode("2");
		TreeNode rightChild = new TreeNode("3");
		root.left = leftChild;
		root.right = rightChild;
		// �ڶ����ӽڵ�
		TreeNode secondLeftChild = new TreeNode("4");
		TreeNode secondRightChild = new TreeNode("5");
		leftChild.left = secondLeftChild;
		leftChild.right = secondRightChild;

		TreeNode secondLeftChild_r = new TreeNode("6");
		TreeNode secondRightChild_r = new TreeNode("7");
		rightChild.left = secondLeftChild_r;
		rightChild.right = secondRightChild_r;

		// ���1 2 3 4 5 6 7
		System.out.println("�ֲ�����������ڵ㣬�������");
		levelTraversal(root);
		System.out.println("\n\n�����ӡ������");
		printFromTopToBottom(root);

		// ���1 2 4 5 3 6 7
		System.out.println("\nǰ�����(�ݹ�)");
		preorderTravelsalRec(root);
		System.out.println("\n\nǰ�����(����)");
		preorderTravelsal(root);

		// ��� 4 2 5 1 6 3 7
		System.out.println("\n\n�������(�ݹ�)");
		inorderTravelsalRec(root);
		System.out.println("\n\n�������(����)");
		inorderTravelsal(root);

		// ���4 2 5 6 3 7 1
		System.out.println("\n\n�������(�ݹ�)");
		postderTravelsalRec(root);
		System.out.println("\n\n�������(����)");
		postderTravelsal(root);

	}

	// 1.1�ֲ�����������ڵ㣬�������
	public static void levelTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		// �������ͷ��
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

	// 1.2�����ӡ������
	public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
		// ��ǰ�������ӽڵ�
		TreeNode last = root;
		// ��һ�������ӽڵ�
		TreeNode nLast = root;
		queue.add(root);

		while (!queue.isEmpty()) {
			// ����
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
			// һ�б�����ϣ�����һ��
			if (out == last) {
				System.out.println("");
				last = nLast;
			}
		}

		return list;
	}

	// 2.1ǰ�����(�ݹ�)
	public static void preorderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.treeID + " ");
		preorderTravelsalRec(root.left);
		preorderTravelsalRec(root.right);
	}

	// 2.2ǰ�����(����)
	public static void preorderTravelsal(TreeNode root) {
		if (root == null) {
			return;
		}
		// ջ
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			// ��ջջ��Ԫ��
			TreeNode cur = stack.pop();
			System.out.print(cur.treeID + " ");
			// �ؼ��㣺��ѹ���ҽڵ㣬��ѹ����ڵ㣬
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		// ***����push��pop�Ĳ����Ѿ��ܽӽ�stack�Ĳ�����
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.push(root);// push�Ƿŵ�����
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

	// 3.1�������(�ݹ�)
	public static void inorderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTravelsalRec(root.left);
		System.out.print(root.treeID + " ");
		inorderTravelsalRec(root.right);
	}

	// 3.2�������(����)
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

	// 4.1�������(�ݹ�)
	public static void postderTravelsalRec(TreeNode root) {
		if (root == null) {
			return;
		}
		postderTravelsalRec(root.left);
		postderTravelsalRec(root.right);
		System.out.print(root.treeID + " ");
	}

	// 4.2�������(����)
	public static void postderTravelsal(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();// ��һ��stack�������Node���������ҽڵ�
		Stack<TreeNode> output = new Stack<TreeNode>();// �ڶ���stack���ڷ�ת��һ��stack���

		stack.push(root);
		while (!stack.isEmpty()) {// ȷ������Ԫ�ض���ת�Ƶ��ڶ���stack
			TreeNode cur = stack.pop();// ��ջ��Ԫ����ӵ��ڶ���stack
			output.push(cur);

			if (cur.left != null) {// ��ջ��Ԫ�ص������ӽڵ㣬����ӵ���һ��stack��
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
