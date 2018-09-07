package algorithm;

import java.util.Arrays;

public class Pack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {3,4,5};//��Ʒ������
	    int[] v = {4,5,6};//��Ʒ�ļ�ֵ
	    int[] x=new int[4];//��Ʒ��ѡȡ״̬
	    int n = 3;
	    int C=10;//�����������
        x=BackPack_Solution(C,n,w,v,x);
        System.out.println(Arrays.toString(x));
	}
	/**
     * @param m ��ʾ�������������
     * @param n ��ʾ��Ʒ����
     * @param w ��ʾ��Ʒ��������
     * @param p ��ʾ��Ʒ��ֵ����
     * @param x ��ʾ�Ƿ�ѡ�������Ʒ
     */
    public static int[] BackPack_Solution(int m, int n, int[] w, int[] p, int[] x) {
        //c[i][v]��ʾǰi����Ʒǡ����һ������Ϊm�ı������Ի�õ�����ֵ
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
                //(1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
                //(2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒi�ļ�ֵ
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])){
                    	//x[i-1]=1;
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                        
                    }
                    else{
                    	//x[i-1]=0;
                        c[i][j] = c[i - 1][j];
                        
                    }
                } else{
                    c[i][j] = c[i - 1][j];
                    //x[i-1]=0;
                }
               
            }
        }
        for (int i = n; i >= 1; i--)
	    {
	        if (c[i][m]>c[i - 1][m])
	        {
	            x[i] = 1;
	            m = m - w[i-1];
	        }
	        else
	            x[i] = 0;
	    }
        return x;
    }

}
