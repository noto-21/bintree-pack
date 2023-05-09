public class Main
{
	public static void main(String[] args)
	{
		BinMaxHeap[] bin =
			{
				new BinMaxHeap(10),
				new BinMaxHeap(10),
				new BinMaxHeap(10),
				new BinMaxHeap(7)
			};//New BMH's, w/varying sizes
		
		Node[] nodes =
			{
				new Node(16),
				new Node(10),
				new Node(14),
				new Node(9),
				new Node(7),
				new Node(1),
				new Node(4),
				new Node(2),
				new Node(8),
				new Node(3)
			};//Node array
		
		for (Node n : nodes)//Insert into first BMH
			bin[0].InsertUpSift(n);
		
		for (int i = nodes.length - 1; i >= 0; i--)//Insert into second BMH, in reverse
			bin[1].InsertUpSift(nodes[i]);
		
		for (int l = (nodes.length / 2) + 1; l < nodes.length; l++)//Insert into third BMH, split-style
			bin[2].InsertUpSift(nodes[l]);
		for (int k = nodes.length / 2; k >= 0; k--)
			bin[2].InsertUpSift(nodes[k]);
		
		//Print each BMH
		System.out.print("BMH #1: ");
		bin[0].Print();
		System.out.print("\nBMH #2: ");
		bin[1].Print();
		System.out.print("\nBMH #3: ");
		bin[2].Print();
		
		System.out.println("\n\nAs can be seen, inserting the same nodes in different orders"
				+ " may, in fact, produce slightly different trees.\nHowever, this does not matter,"
				+ " since in all cases, the maximum value always becomes the root of the max heap.");//Demo explanation
		
		//Manual insertions into BMH #4
		bin[3].bmh[1] = new Node(1);
		bin[3].amount++;
		bin[3].bmh[2] = new Node(5);
		bin[3].amount++;
		bin[3].bmh[3] = new Node(3);
		bin[3].amount++;
		bin[3].bmh[4] = new Node(7);
		bin[3].amount++;
		bin[3].bmh[5] = new Node(11);
		bin[3].amount++;
		bin[3].bmh[6] = new Node(2);
		bin[3].amount++;
		
		//BMH w/o Max-Heap property
		System.out.print("\nBMH #4: ");
		bin[3].Print();
		
		//Sifting from root (grant MHP)
		bin[3].SiftDown(1);
		bin[3].SiftDown(1);
		System.out.print("\nBMH #4 - Sifted Down: ");
		bin[3].Print();
		
		//Extract max val. (root) demo
		System.out.print("\nBMH #4 - Extracted Max: " + bin[3].ExtractMax() + "\nBMH #4 - Post Extraction: ");
		bin[3].Print();
		
		//Remove @ index demo
		bin[3].Remove(3);
		System.out.print("\nBMH #4 - Post Removal: ");
		bin[3].Print();
	}
}