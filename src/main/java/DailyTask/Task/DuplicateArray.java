package DailyTask.Task;

public class DuplicateArray {

	public static void main(String[] args) {
		int a[]= {2,2,4,6,8,0,8,9,3,4,6};
		for (int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
	           if(a[i]==a[j]) 
	           {
	        	   System.out.println(a[j]+" "+"duplicate number and this position is"+" "+j);
	           }
			}
		}
	}

}
