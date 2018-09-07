package algorithm;
import java.util.*;
public class kangaroo
    {
	public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=input.nextInt();
        int sum=0;
        for(int i=0;i<n;)
            {
        	if(i==n-1&&num[i]!=0)
            {
            sum++;
            break;
        }
            int len=0,p=0;
            for(int j=i+1;j<=i+num[i];j++)
                {
                int l=j-i+num[j];
            if(l>=len)
                {
                len=l;
                p=j;
            }
            }
            i=p;
            ++sum;
            if(num[i]==0||p==0)
                System.out.print(-1);
            
            if(p+num[p]>n-1)
                {
                ++sum;
                break;
            }
        }
        System.out.print(sum);
    }
}


