package algorithm;

import java.util.ArrayList;
class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	      }
	  }
public class BinarySearch {

	  public ListNode detectCycle(ListNode head) {
	        if(head==null)
	            return null;
	        ListNode fast=head;
	        ListNode slow=head;
	        
	        while(fast!=null&&fast.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	            if(slow==fast)
	                break;
	        }
	        if(fast==null||fast.next==null)
	            return null;
	        slow=head;
	        while(slow!=fast){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        return slow;
	    }
}
