import java.util.Stack;

public class KthNode {
	int index=0;
	 TreeNode KthNodeMain(TreeNode pRoot, int k)//µÝ¹é°æ±¾
	    {
	        if(pRoot!=null){
	        	TreeNode node =KthNodeMain(pRoot.left,k);
	        	if(node!=null)
	        		return node;
	        	index++;
	        	if(index==k)
	        		return pRoot;
	        	node = KthNodeMain(pRoot.right,k);
	        	if(node!=null)
	        		return node;
	        	
	        }
	        return null;
	        	
	    }
	 TreeNode KthNodeMain2(TreeNode pRoot, int k)//·ÇµÝ¹é°æ±¾
	    {
	       Stack<TreeNode> stack = new Stack<>();
	        	TreeNode p = pRoot;
	        	int index =0;
	        	TreeNode kthNode=null;
	        	while(p!=null||!stack.isEmpty()){
	        		while(p!=null){
	        			stack.push(p);
	        			p=p.left;
	        			
	        		}
	        		TreeNode node = stack.pop();
	        		index++;
	        		if(index==k)
	        			kthNode=node;
	        		p=node.right;
	        	}
	        	return kthNode;
	    }
	 
}
