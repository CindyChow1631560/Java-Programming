import java.util.*;
public class StrToInt {
	public static void main(String[] args){
		String test = "+23";
		int num = StrToIntMain(test);
		System.out.println(num);
	}
public static int StrToIntMain(String str) {
	if(str.equals("") || str.length()==0)
		return 0;
	char[] strc = str.toCharArray();
	int sin = 0;
	if(strc[0]=='-')
		sin=1;
	int sum=0;
	for(int i=sin;i<strc.length;i++){
		if(i==0&&strc[i]=='+'){
			continue;
		}
		if(strc[i]<48||strc[i]>57)
			return 0;
		sum=sum*10+strc[i]-48;
	}
	return sin==0?sum:sum*(-1);
        
    }
}
