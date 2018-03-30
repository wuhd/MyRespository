package BinaryTree;

public class Tree<AnyType extends Comparable<? super AnyType>> {

	public BinaryNode<AnyType> root;

	public void insert(AnyType x) {
		root = insert(x, root);
	}

	public BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null) {
			return new BinaryNode<AnyType>(x);
		}

		int compareResult = x.compareTo(t.treeID);
		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		}
		return t;
	}

	public static class BinaryNode<AnyType> {

		public AnyType treeID;
		public BinaryNode<AnyType> left;
		public BinaryNode<AnyType> right;

		public BinaryNode(AnyType treeID) {
			this(treeID, null, null);
		}

		public BinaryNode(AnyType treeID, BinaryNode<AnyType> left,
				BinaryNode<AnyType> right) {
			this.treeID = treeID;
			this.right = left;
			this.left = right;
		}

	}
}
