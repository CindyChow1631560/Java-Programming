package algorithm;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
   
        ListNode head =new ListNode(0);
        ListNode cur =head;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                if(l1.val<l2.val){
                    return -1;
                }else if(l1.val==l2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for(ListNode temp:lists){
            if(temp!=null){
                q.add(temp);
            }
        }
        while(!q.isEmpty()){
            cur.next=q.poll();
            cur=cur.next;
            if(cur.next!=null){
                q.add(cur.next);
            }
            
        }
        return head.next;
    }
}
