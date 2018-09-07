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
	        //�����ƺ�Ľڵ���뵽ԭ�ڵ�ĺ���
	        while(pCurrent!=null){
	        	RandomListNode clone=new RandomListNode(pCurrent.label);
	        	RandomListNode pTemp=pCurrent.next;
	        	clone.random=null;
	        	pCurrent.next=clone;
                clone.next=pTemp;
	        	pCurrent=pTemp;
	        	
	        }
	        //�����ƽڵ�N'��randomָ��ָ��N��randomָ�����һ��ָ��
	        pCurrent=pHead;
	        while(pCurrent!=null){
	        pCurrent.next.random=pCurrent.random==null?null:pCurrent.random.next;
	        pCurrent=pCurrent.next.next;
	        
	        }
	        //������ֳ�������
	        pCurrent=pHead;
	        RandomListNode cloneHead=pHead.next;
	        while(pCurrent!=null){
	        	RandomListNode clone=pCurrent.next;//cloneָ���Ƶ�����
	        	pCurrent.next=clone.next;//pCurrentָ��ԭ��������
	        	clone.next=clone.next==null?null:clone.next.next;
	        	pCurrent=pCurrent.next;
	        }
	        return cloneHead;
	    }
}
