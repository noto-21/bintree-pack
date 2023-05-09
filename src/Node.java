public class Node
{
	private int data;
	private String dataS;
	public Node left, right;

	/*---Constructors---*/
	public Node(int val)//With integer
	{
		data = val;
		dataS = null;
		left = right = null;
	}
	public Node(String val)//With string
	{
		data = 0;
		dataS = val;
		left = right = null;
	}

	public void printData()//Print data
	{
		System.out.print(((dataS != null) ? dataS : data) + "\s");
	}

	/*----Change Data---*/
	public void changeData(String nVal)//Change to string data
	{
		if (dataS != null)
			dataS = nVal;
		else
		{
			data = 0;
			dataS = nVal;
		}
	}
	public void changeData(int nVal)//Change to integer data
	{
		if (dataS != null)
		{
			data = nVal;
			dataS = null;
		}
		else
			data = nVal;
	}

	public void clearChildren()//Delete all children of a node
	{
		left = right = null;
	}
}