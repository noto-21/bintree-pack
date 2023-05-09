public class BinSearchTree
{
	public static void main(String[] args)
	{
		//Create new Binary Search Tree
		Node bt = new Node(1);
		bt.left = new Node(2);
		bt.left.left = new Node(4);
		bt.right = new Node(3);
		bt.right.right = new Node(6);
		bt.right.left = new Node(5);
		bt.right.left.left = new Node(7);
		bt.right.left.right = new Node (8);

		//Traversals
		System.out.print("Tree #1:\nIn-Order Traversal:  ");
		inOrder(bt);
		System.out.print("\nPost-Order Traversal:  ");
		postOrder(bt);
		System.out.print("\nPre-Order Traversal:  ");
		preOrder(bt);

		//Create new Binary Search Tree
		Node bt2 = new Node("A");
		bt2.left = new Node("B");
		bt2.left.left = new Node("C");
		bt2.left.right = new Node(1);
		bt2.right = new Node(2);
		bt2.right.left = new Node(3);
		bt2.right.right = new Node("~Easy-Peasy!~");
		
		//Traversals
		System.out.print("\n\nTree #2:\nIn-Order Traversal:  ");
		inOrder(bt2);
		System.out.print("\nPost-Order Traversal:  ");
		postOrder(bt2);
		System.out.print("\nPre-Order Traversal:  ");
		preOrder(bt2);

		//Demonstration of data-change functions, using one Node
		System.out.println("\n");
		bt2.right.right.changeData("Ooh, not so ~easy-peasy!~...");
		bt2.right.right.printData();
		System.out.println("\n");
		bt2.right.right.changeData(17);
		bt2.right.right.printData();
		bt2.right.right.changeData(49);
		bt2.right.right.printData();
		System.out.println("\n");
		bt2.right.right.changeData("Oh, wait, still ~Easy-Peasy!~");
		bt2.right.right.printData();
		bt2.right.right.changeData("...I hope...");
		bt2.right.right.printData();

		//Demonstration of clearChildren() on a Node in a BST
		bt2.right.clearChildren();
		System.out.println("\n");
		preOrder(bt2);
	}

	/*---Recursive Tree Traversals---*/
	public static void inOrder(Node n)//In-Order
	{
		if (n != null)
		{
			inOrder(n.left);
			n.printData();
			inOrder(n.right);
		}
	}
	public static void postOrder(Node n)//Post-Order
	{
		if (n != null)
		{
			postOrder(n.left);
			postOrder(n.right);
			n.printData();
		}
	}
	public static void preOrder(Node n)//Pre-Order
	{
		if (n != null)
		{
			n.printData();
			preOrder(n.left);
			preOrder(n.right);
		}
	}
}