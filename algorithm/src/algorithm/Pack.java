package algorithm;

import java.util.Arrays;

public class Pack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {3,4,5};//物品的重量
	    int[] v = {4,5,6};//物品的价值
	    int[] x=new int[4];//物品的选取状态
	    int n = 3;
	    int C=10;//背包最大容量
        x=BackPack_Solution(C,n,w,v,x);
        System.out.println(Arrays.toString(x));
	}
	/**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     * @param x 表示是否选中这个商品
     */
    public static int[] BackPack_Solution(int m, int n, int[] w, int[] p, int[] x) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
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
