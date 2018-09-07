package algorithm;
import java.util.HashMap;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int k=in.nextInt();
            int num=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int x=1;x<=n;x++){
                for(int y=1;y<=n;y++){
                    if(x%y>=k){
                       num++;
                    }
                }
            }
        System.out.println(num);
    }
}