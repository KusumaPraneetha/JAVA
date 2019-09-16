package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class reversewords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "I love this program very much I love Java Java is the most used language Java is not easy";
		
		//System.out.println(reverseSentence(s1));
		//countStrings(s1);
		int[] num= {1,1,2,3,4,4,5,6,7,7,4,8,9,0,0};
		//countUnique(num);

	}
	public static void countUnique(int[] n)
	{
		Map<Integer,Integer> m=new HashMap<>();
		for(int i=0;i<n.length;i++)
		{
			if(m.containsKey(n[i]))
			{
				m.put(n[i],m.get(n[i]+1));
			}
			else
			{
				m.put(n[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> x : m.entrySet())
		{
			//System.out.println(xmap);
		
			if(x.getValue()==1)
			System.out.println(x.getKey() +" ");
		}
		//System.out.println(xmap);
	}
	
	public static String reverseSentence(String sen)
	{
		
		Pattern p = Pattern.compile("\\s");
		
		String[] arr = p.split(sen);
		
		String res="";
		
		for(int i=arr.length-1;i>=0;i--)
		{
			
			String word = arr[i];
			String rev = "";
			
			for(int j=arr[i].length()-1;j>=0;j--)
			{	
				
				rev += word.charAt(j);
			}
			
			res=res+" "+rev;
			}	
		return res;
	}

	public static void countStrings(String sen)
	{
		int count;
		Pattern p = Pattern.compile("\\s");
		String[] sArr=p.split(sen);
		List<String> list = new ArrayList<>();
		for(int i=0;i<sArr.length;)
		{
			count=0;
			if(list.contains(sArr[i]))
			{
				i++;
			}
			else {
				list.add(sArr[i]);
				
			
			for(int j=i+1;j<sArr.length;j++)
			{
				
				if(compareArrayStrings(sArr[j],sArr[i]))
				{
					count = count+1;
				}
			}
			System.out.println(sArr[i]+'='+(count+1));
			}
		}		
	}

	public static boolean compareArrayStrings(String a,String b)
	{
		if(a.equals(b))
			return true;
		return false;
	}
}
