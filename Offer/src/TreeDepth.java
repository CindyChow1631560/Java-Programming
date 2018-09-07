
import java.util.Queue;
import java.util.LinkedList;
  class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeDepth {
	 public int TreeDepthMain(TreeNode root) {
		 if(root==null)
			 return 0;
	        int levelCount=0,depth=0,levelNodeNum=1;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while(q.size()!=0){
	        	TreeNode peek = q.remove();
	        	levelCount++;
	        	if(peek.left!=null){
	        		q.add(peek.left);
	        	}
	        	if(peek.right!=null){
	        		q.add(peek.right);
	        	}
	        	if(levelCount==levelNodeNum){
	        		levelNodeNum=q.size();
	        		levelCount=0;
	        		depth++;
	        	}
	        }
	        return depth;
	    }
}
