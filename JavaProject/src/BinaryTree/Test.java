package BinaryTree;

import BinaryTree.Tree.BinaryNode;

public class Test {
	public static void main(String[] args) {
		int[] input = new int[] { 4, 2, 6, 1, 3, 5, 7, 8, 10 };
		Tree<Integer> tree = new Tree<Integer>();
		for (int i = 0; i < input.length; i++) {
			tree.insert(input[i]);
		}
		System.out.println("ºóÐò±éÀú(µÝ¹é)");
		postderTravelsalRec(tree.root);
	}

	// 4.1ºóÐò±éÀú(µÝ¹é)
	public static void postderTravelsalRec(BinaryNode<Integer> node) {
		if (node == null) {
			return;
		}
		postderTravelsalRec(node.left);
		postderTravelsalRec(node.right);
		System.out.print(node.treeID + " ");
	}
}
