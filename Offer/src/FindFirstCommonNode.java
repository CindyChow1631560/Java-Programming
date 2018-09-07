
public class FindFirstCommonNode {
	 public ListNode FindFirstCommonNodeMain(ListNode pHead1, ListNode pHead2) {
         int l1 = ListLength(pHead1);
         int l2 = ListLength(pHead2);
         if(l1>l2){
         int dif = l1-l2;
         for(int i=1;i<=dif;i++){
        	 pHead1=pHead1.next;
         }
         }else {
        	 int dif = l2-l1;
        	 for(int i=1;i<=dif;i++){
            	 pHead2=pHead2.next;
             }
         }
         while(pHead1.next!=null&&pHead1!=pHead2){
        	 pHead1 = pHead1.next;
        	 pHead2 = pHead2.next;
         }
         ListNode result = pHead1.next;
         return result;
	    }
	    public int ListLength(ListNode pHead){
	        int len=0;
	        while(pHead.next!=null){
	        	pHead = pHead.next;
	        	len++;
	        }
	        return len;
	    }
	    class ListNode {
	        int val;
	        ListNode next = null;

	        ListNode(int val) {
	            this.val = val;
	        }
	    }
}
