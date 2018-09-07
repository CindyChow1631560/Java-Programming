package algorithm;
import java.util.*;

public class Main
    {
    public static void main(String[] args)
   {
    Scanner input=new Scanner(System.in);
    int n=input.nextInt();
    int[] x=new int[n];
    int[] y=new int[n];
    for(int i=0;i<n;i++)
        {
        x[i]=input.nextInt();
        y[i]=input.nextInt();
    }
     System.out.println(counter(x,y));   
   
   }
  
    private static int counter(int[] x,int[] y)
        {
    	  if (x.length<=3)
              return x.length;
    	  point[] ps=new point[x.length];
    	    for(int i=0;i<ps.length;i++)
    	        {
    	        ps[i]=new point(x[i],y[i]);
    	    }
    	    int max=0;
    	  
      
        for(int j=0;j<x.length;j++)
            for(int i=0;i<x.length;i++)
            {
            if(i!=j)
                {
                for(int m=0;m<x.length;m++)
                    {
                    if(m!=i&&m!=j)
                        {
                    	  int count=3;
                        for(int k=0;k<x.length;k++)
                            {
                            if(k!=m&&k!=j&&k!=i)
                                {
                                if(parellel(ps[i],ps[j],ps[k])||vertical(ps[i],ps[j],ps[m],ps[k]))
                                    count++;
                            }
                        }
                        max=Math.max(count,max);
                       }
                   
                }
                   
            }
        }
        return max;
    }
  


private static boolean parellel(point s1,point s2,point s3)
{
return (s2.y-s1.y)*(s3.x-s1.x) == (s3.y-s1.y)*(s2.x-s1.x);
}

private static boolean vertical(point s1,point s2,point s3,point s4)
{
return (s2.x-s1.x)*(s3.x-s4.x) == (s2.y-s1.y)*(s4.y-s3.y);
}
static class point
    {
    int x;
    int y;
    public point(int x,int y)
        {
        this.x=x;
        this.y=y;
    }
}
}