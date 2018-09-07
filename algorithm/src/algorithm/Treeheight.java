package algorithm;
import java.util.*;
public class Treeheight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int n=in.nextInt();
HashMap<Integer,Integer> height=new HashMap<>();
HashMap<Integer,Integer> childNum=new HashMap<>();
height.put(0,1);
childNum.put(0,0);
int max=1;
int myheight=0;
for(int i=0;i<n-1;i++)
{
	int parent=in.nextInt();
	int num=in.nextInt();
	if(!height.containsKey(parent)||childNum.get(parent)>=2)
	{
		continue;
	}
	myheight=height.get(parent)+1;
	height.put(num,myheight);
	childNum.put(parent,childNum.get(parent)+1);
	childNum.put(num, 0);
	if(myheight>max)
		max=myheight;
}
System.out.println(max);
	}

}
