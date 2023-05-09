public class BinMaxHeap
{
	public Node[] bmh;//Node array
	public int maxSize, amount;//Size limit, current size
	
	/*---Constructor---*/
	public BinMaxHeap(int maxSizeIn)
	{
		maxSize = maxSizeIn;
		amount = 0;
		bmh = new Node[maxSize + 1];
	}
	
	/*---Return Key Nodes---*/
	public int Parent(int ind)
	{
		return (int)Math.floor(ind / 2);//Parent Node index
	}
	public int LeftChild(int ind)
	{
		return (ind * 2);//LC index
	}
	public int RightChild(int ind)
	{		
		return ((ind * 2) + 1);//RC index
	}
	
	/*---Sifts---*/
	public void SiftUp(int index)//Up @ index
	{		
		while (index > 1 && bmh[(Parent(index))].getData() < bmh[index].getData())//Swap-Sort
		{
			Node temp = bmh[(Parent(index))];
			bmh[(Parent(index))] = bmh[index];
			bmh[index] = temp;
			
			index = Parent(index);//Update index
		}
	}
	public void SiftDown(int index)//Down @ index (Recursive)
	{		
		int maxIndex = index, l = LeftChild(index), r = RightChild(index);//Indices (current, LC, RC)
		
		if (l <= amount && bmh[l].getData() > bmh[maxIndex].getData())//If LC is greater, then LC index --> target
			maxIndex = l;
		
		if (r <= amount && bmh[r].getData() > bmh[maxIndex].getData())//If RC is greater, then RC index --> target
			maxIndex = r;
		
		if (index != maxIndex)//Swap-Sort if necessary
		{
			Node temp = bmh[index];
			bmh[index] = bmh[maxIndex];
			bmh[maxIndex] = temp;
			
			SiftDown(maxIndex);//Recursive call until base-case (Node is @ proper index)
		}
	}
	
	public void InsertUpSift(Node p)//Insert new Node + Sift-Up
	{
		if (amount == maxSize)//BMH is full
		{
			System.out.print("\nBinary Heap is full!");
			return;
		}
		else//BMH is not full
		{
			amount++;
			bmh[amount] = p;//Insert @ last pos.
			SiftUp(amount);//Sift-Up @ pos.
		}
	}
	public void InsertDownSift(Node p)//Insert new Node + Sift-Down
	{
		if (amount == maxSize)//BMH is full
		{
			System.out.print("\nBinary Heap is full!");
			return;
		}
		else//BMH is not full
		{
			amount++;
			bmh[amount] = p;//Insert @ last pos.
			SiftDown(1);//Sift-Down from root
		}
	}
	
	public int ExtractMax()//Get Node w/Max-Value and remove
	{
		Node result = bmh[1];
		bmh[1] = bmh[amount];
		bmh[amount] = null;
		amount--;
		
		SiftDown(1);//Maintain MH-property
		
		return result.getData();
	}
	
	public void Remove(int index)//Remove Node @ index
	{
		bmh[index].setData(Integer.MAX_VALUE);
		
		SiftUp(index);//Maintain MH-property
		
		ExtractMax();//Maintain MH-property
	}
	
	public void Print()//Print BMH
	{
		for (int i = 1; i < bmh.length; i++)
			if (bmh[i] != null)
				bmh[i].printData();
	}
}