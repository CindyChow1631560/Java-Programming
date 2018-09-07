package algorithm;
import java.util.*;
public class Main15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int cnt = 0 , cnt2 = 0;
        char c[] = str.toCharArray();
        for(int i = 1; i < c.length-1; i++){
        	if(c[i-1]!=c[i+1]){
        		cnt++;
        	}
        }
           
        System.out.println(cnt);
    }
}
