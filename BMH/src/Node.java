public class Node
{
	private int data;

	/*---Constructor---*/
	public Node(int dIn)
	{
		data = dIn;
	}
	
	/*---Getters/Setters---*/
	public int getData()
	{
		return this.data;
	}
	public void setData(int dIn)
	{
		data = dIn;
	}
	
	public void printData()//Print the data
	{
		System.out.print(data + " ");
	}
}