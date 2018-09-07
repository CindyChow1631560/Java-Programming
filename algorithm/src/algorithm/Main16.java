package algorithm;

import java.util.Scanner;

public class Main16 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		 String str = in.nextLine();//ÊäÈëÒ»ÐÐ×Ö·û´®
		 //str=str.trim();
		 String[] c = str.trim().split(" ");
		 int[] prices =new int[c.length];
		 for(int i=0;i<c.length;i++){
			 prices[i]=Integer.parseInt(c[i]);
	}
		 
		 int result = maxProfit(prices);
		 System.out.println(result);
	}
	
	public static int maxProfit(int[] prices) {
        int len=prices.length;
        if(len==0||len==1)
            return 0;
        int maxProfit=0;
        for(int i=0;i<len-1;i++){
            int price=prices[i];

            for(int j=i+1;j<len;j++){
                int profit=prices[j]-price;
                if(profit>maxProfit){

                    maxProfit=profit;

                }

            }

        }
        return maxProfit;
    }
		 
}





