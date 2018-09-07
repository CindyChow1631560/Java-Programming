package algorithm;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line= sc.nextLine();
		String[] c = line.split(";");
		String input1=c[0];
		String input2=c[1];
		System.out.println(compare (input1,input2));
	}
	public static boolean compare(String a, String b) {
        if (b.isEmpty()) return true;
        if (a.isEmpty()) return false;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        List<Character> aList = new ArrayList<>();
        for (char aChar : charA) {
            aList.add(aChar);
        }
        List<Character> bList = new ArrayList<>();
        for (char bChar : charB) {
            bList.add(bChar);
        }
        int index;
        for (int i = bList.size() - 1; i >= 0; i--) {
            index = aList.indexOf(bList.get(i));
            if (index != -1) {
                bList.remove(i);
                aList.remove(index);
            } else {
                return false;
            }
        }
        return true;
    }

}
