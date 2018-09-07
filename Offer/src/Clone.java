class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
	 public RandomListNode CloneMain(RandomListNode pHead)
	    {
	        if(pHead==null)
	        	return null;
	        RandomListNode pCurrent=pHead;
	        //将复制后的节点插入到原节点的后面
	        while(pCurrent!=null){
	        	RandomListNode clone=new RandomListNode(pCurrent.label);
	        	RandomListNode pTemp=pCurrent.next;
	        	clone.random=null;
	        	pCurrent.next=clone;
                clone.next=pTemp;
	        	pCurrent=pTemp;
	        	
	        }
	        //将复制节点N'的random指针指向N的random指针的下一个指针
	        pCurrent=pHead;
	        while(pCurrent!=null){
	        pCurrent.next.random=pCurrent.random==null?null:pCurrent.random.next;
	        pCurrent=pCurrent.next.next;
	        
	        }
	        //将链表分成两部分
	        pCurrent=pHead;
	        RandomListNode cloneHead=pHead.next;
	        while(pCurrent!=null){
	        	RandomListNode clone=pCurrent.next;//clone指向复制的链表
	        	pCurrent.next=clone.next;//pCurrent指向原来的链表
	        	clone.next=clone.next==null?null:clone.next.next;
	        	pCurrent=pCurrent.next;
	        }
	        return cloneHead;
	    }
}
