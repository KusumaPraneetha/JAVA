package hashset;

public class subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =new int[] {1,2,3,7,5};
		
		int s=12;
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				
				sum=sum+arr[i];
				while(sum<s)
				{
					sum=sum+arr[j++];
				}
				if(sum>s)
				{
					sum=sum-arr[i];
					if(sum==s)
					{
						System.out.println((i+1)+" "+(j-1));
						break;
					}
					else {
						break;
						
					}
					
				}
				
			}
			break;
		}
		
		

	}

}
