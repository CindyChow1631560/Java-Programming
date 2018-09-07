package algorithm;

class Solution3 {
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		ListNode headcur=head;
		head.next= new ListNode(2);
		head=head.next;
		head.next=new ListNode(3);
		head=head.next;
		head.next=new ListNode(4);
		head=head.next;
		head.next=null;
		ListNode res=swapPairs(headcur);
	
	}
    public static  ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur =dummy;
        while(cur.next!=null&&cur.next.next!=null){
        ListNode temp=cur.next;
        ListNode temp2=cur.next.next;
        temp.next=temp2.next;//next time temp=cur.next,so it is needed to know temp.next
        cur.next=temp2;
        cur.next.next=temp;
        
        cur=cur.next.next;//it equals to cur->temp
        
        }
        return dummy.next;
    }
}
