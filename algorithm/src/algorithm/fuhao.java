package algorithm;
import java.util.*;
public class fuhao {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String exp=in.nextLine();
            ArrayDeque<String> expQue=new ArrayDeque<>();
            StringBuilder digit=new StringBuilder();
            for(int i=0;i<exp.length();i++){
                char ch=exp.charAt(i);
                //������⸺��
                if(digit.length()==0&&ch=='-'&&
                        (i==0||"/".equals(expQue.peekLast()) ||"*".equals(expQue.peekLast()))){
                  digit.append(ch);
                } else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                    if(digit.length()>0){//���������
                        expQue.add(digit.toString());
                        digit.delete(0,digit.length());
                    }
                    expQue.add(String.valueOf(ch));
                }else{
                    digit.append(ch);
                }
            }
            if(digit.length()>0) expQue.add(digit.toString());
            ArrayDeque<String> expQueTemp=new ArrayDeque<>();
            String first,numA,numB;

            //����+-��
            while(!expQue.isEmpty()){
                first=expQue.removeFirst();
                if("+".equals(first)){
                    numA=expQueTemp.pollLast();
                    numB=expQue.pollFirst();
                    expQueTemp.add(String.valueOf(Integer.parseInt(numA)+Integer.parseInt(numB)));
                }else if("-".equals(first)){
                    numA=expQueTemp.pollLast();
                    numB=expQue.pollFirst();
                    expQueTemp.add(String.valueOf(Integer.parseInt(numA)-Integer.parseInt(numB)));
                }else{
                    expQueTemp.add(first);
                }
            }
            expQue=expQueTemp;

            //����*/��
            expQueTemp=new ArrayDeque<>();
            while(!expQue.isEmpty()){
                first=expQue.removeFirst();
                if("*".equals(first)){
                    numA=expQueTemp.pollLast();
                    numB=expQue.pollFirst();
                    expQueTemp.add(String.valueOf(Integer.parseInt(numA)*Integer.parseInt(numB)));
                }else if("/".equals(first)){
                    numA=expQueTemp.pollLast();
                    numB=expQue.pollFirst();
                    expQueTemp.add(String.valueOf(Integer.parseInt(numA)/Integer.parseInt(numB)));
                }else{
                    expQueTemp.add(first);
                }
            }
            System.out.println(expQueTemp.removeFirst());
        }
        in.close();
    }
}
