package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line= sc.nextLine();
		char[] ch = line.toCharArray();
		List<Character> aList = new ArrayList<>();
        for (char aChar : ch) {
            aList.add(aChar);
        }
		Collections.sort(aList,new Comparator<Character>() {
			public int compare(Character ch1, Character ch2){
				return ch2.compareTo(ch1);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ch.length;i++){
		   sb.append(aList.get(i));
		}
		System.out.println(sb.toString());
	}

}
