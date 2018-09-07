import java.util.Stack;
import java.util.ArrayList;

public class printListFromTailToHead {
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        Stack<Integer> s = new Stack();
	        ArrayList<Integer> array = new ArrayList<>();
	        while(listNode.next!=null){
	        	s.push(listNode.val);
	        	listNode=listNode.next;
	        }
	        array.add(listNode.val);
	        while(!s.isEmpty()){
	        	array.add(s.pop());
	        }
	        return array;
	    }
}
