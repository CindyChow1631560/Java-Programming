//import java.util.ArrayList;
import java.util.*;
public class PrintInZhiForm {
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();
		System.out.println(minHeap.isEmpty());
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		list.add(1);
		list.add(2);
		result.add(list);
		System.out.println(result.toString());
		//Collections.reverse(list);
		list.clear();
		list.add(4);
		list.add(5);
		list.add(6);
		result.add(list);
		System.out.println(result.toString());
	}
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		
            int count=0,cur=1;//cur record the number of nodes in the current level
            int level=0;//record the level is even or odd;
            ArrayList<Integer> temp =new ArrayList<>();
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if(pRoot==null)
    			return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(pRoot);
            while(!q.isEmpty()){
            	TreeNode t = q.poll();
            	count++;
            	temp.add(t.val);	
            	if(t.left!=null){
            		q.add(t.left);
            	}
            	if(t.right!=null){
            		q.add(t.right);
            	}
            	if(count==cur){
            		level++;
            		if(level%2==0){
            			Collections.reverse(temp);
            			result.add(temp);
            			}else{
            				result.add(temp);
            			}
            		
            		cur=q.size();
            		count=0;
            		//result.add(temp);
            		//temp.clear();//之前引用的地址会被清空;当temp更改时，result中原先的temp也会被更改
            		temp =new ArrayList<>();//之前引用的地址不会被清空
            	}
            }
            return result;
	}
}
