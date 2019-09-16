package hashset;

public class triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {4,7,8,11,9,3,20};
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				for(int k=0;k<arr.length;k++)
				{
					if((arr[i]+arr[j])==arr[k])
					{
						System.out.println(arr[i]+ "+" +arr[j] +"="+arr[k]);
					}
				}
			}
		}

	}

}
