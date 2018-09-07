package algorithm;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> results = new ArrayList();
		int[] result = new int[2];
		for(int i=0;i<n;i++){
		int k = sc.nextInt();
		String s = sc.nextLine();
		//s = s.replaceAll(" ", "");
		String st[] = s.trim().split(" ");
		int[] number = new int[st.length];
		
		for (int l=0;l<st.length;l++){
			number[l] = Integer.parseInt(st[l]);
		}
		result = kthSmallestPrimeFraction(number, k);
		results.add(result[0]);
		results.add(result[1]);
		}
		
		for(int i=0;i<results.size();i+=2){
			System.out.println(results.get(i)+" "+results.get(i+1));
		}
	
	}

	 public static int[] kthSmallestPrimeFraction(int[] A, int K) {
	        Comparator<int[]> comparator = new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                return A[o1[0]] * A[o2[1]] - A[o1[1]] * A[o2[0]];
	            }
	        };
	        int n = A.length;
	        // Min heap
	        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
	        for(int i = 0; i < n - 1; i++) {
	            pq.add(new int[] {i, n-1});
	            if(i == K-1) {
	                break;
	            }
	        }
	        while(!pq.isEmpty()) {
	            if(--K == 0) {
	                break;
	            }
	            int[] top = pq.poll();
	            top[1]--;
	            if(top[1] > top[0]) {
	                pq.add(top);
	            }
	        }
	        return new int[] {A[pq.peek()[0]], A[pq.peek()[1]]};      
	    }
}