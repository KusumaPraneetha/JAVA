package hashset;

public class sortfind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {5,3,8,6,1,4,2};
		int x=0;
		
		for(int i =0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					x=arr[i];
					arr[i]=arr[j];
					arr[j]=x;
				}
			}
		}
		for(int i =0;i<arr.length;i++)
		{
			
				if(arr[i+1]!=arr[i]+1)
				{
					System.out.println(arr[i]+1);
				}
			
		}

	}

}
