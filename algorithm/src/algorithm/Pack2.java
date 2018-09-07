package algorithm;

import java.util.Arrays;

public class Pack2 {
	public static int[][] V = new int[200][200];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {2,2,6,5,4};//��Ʒ������
	    int[] v = {6,3,5,4,6};//��Ʒ�ļ�ֵ
	    int[] x=new int[5];//��Ʒ��ѡȡ״̬
	    int n = 5;
	    int C=10;//�����������
        x=KnapSack(n,w,v,x,C);
        System.out.println(Arrays.toString(x));
	}
	public static int[] KnapSack(int n, int w[], int v[], int x[], int C)
	{
		
	    int i, j;
	    for (i = 0; i <= n; i++)
	        V[i][0] = 0;
	    for (j = 0; j <= C; j++)
	        V[0][j] = 0;
	    for (i = 1; i < n+1; i++){
	        for (j = 1; j < C+1; j++){
	            if (j<w[i-1])
	                V[i][j] = V[i - 1][j];
	            else
	                V[i][j] = Math.max(V[i - 1][j], V[i - 1][j - w[i-1]] + v[i-1]);
	        }
	    }
	    j = C;
	    for (i = n - 1; i >= 0; i--)
	    {
	        if (V[i][j]>V[i - 1][j])
	        {
	            x[i] = 1;
	            j = j - w[i-1];
	        }
	        else
	            x[i] = 0;
	    }
	    return x;

	}
}
