import net.mindview.util.*;
public class Ex15 {
public static void main(String[] args){
	Stack<Character> stack =new Stack<Character>();
	char[] a={'U','n','c'};
	char[] b={'e','r','t'};
	char c='a';
	char d='i';
	char[] e={'n','t','y'};
	char[] f={'r','u'};
	char[] g={'l','e','s'};
	for(int i=0;i<a.length;i++)
		stack.push(a[i]);
	for(int m=0;m<3;m++)
		System.out.println(stack.pop());
}
}
