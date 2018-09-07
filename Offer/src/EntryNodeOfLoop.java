
public class EntryNodeOfLoop {
	public ListNode EntryNodeOfLoopMain(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
        	return null;
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
        	slow=slow.next;
        	fast=fast.next.next;
        	if(slow==fast){
        		fast=pHead;
        		while(fast!=slow){
        			fast=fast.next;
        			slow=slow.next;
        		}
        		return fast;
        	}
        }
        return null;
    }
}
   class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}