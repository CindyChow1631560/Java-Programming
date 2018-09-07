package algorithm;
import java.util.*;
public class shuixianhua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in= new Scanner(System.in);
while(in.hasNext())
{
	int m=in.nextInt();
	int n=in.nextInt();
	ArrayList list=new ArrayList();
	for(int j=m;j<=n;j++)
	{
		int a=j/100;//baiwei
		int b=(j-a*100)/10;//shiwei
		int c=(j-a*100-b*10);//gewei
		if (a*a*a+b*b*b+c*c*c==j)
			list.add(j);
	}
		Collections.sort(list);
		if(list.size()==0)
			System.out.println("no");
		else
		{
			for(int d=0;d<list.size()-1;d++)
				System.out.print(list.get(d)+" ");
			System.out.print(list.get(list.size()-1));
			
		}
	
}
	}

}
