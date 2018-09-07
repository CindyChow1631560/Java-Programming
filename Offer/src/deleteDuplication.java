
public class deleteDuplication {
	  public ListNode deleteDuplicationMain(ListNode pHead)
	    {
            if(pHead==null||pHead.next==null){
            	return pHead;
            }
            if(pHead.val==pHead.next.val){
            	ListNode pCurrent = pHead.next;
            	while(pCurrent!=null && pCurrent.val==pHead.val){
            		pCurrent=pCurrent.next;
            	}
            	return deleteDuplicationMain(pCurrent);
            	
            }else{
            	pHead.next=deleteDuplicationMain(pHead.next);
            	return pHead;
            }
	    }
}
