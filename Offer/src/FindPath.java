import java.util.ArrayList;
public class FindPath {
	 ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
     ArrayList<Integer> list = new ArrayList<>();
	 public ArrayList<ArrayList<Integer>> FindPathMain(TreeNode root,int target) {
	       
	        if(root==null) return all;
	        target=target-root.val;
	        list.add(root.val);
	        if(target==0&&root.left==null&&root.right==null)
	        	all.add(new ArrayList<Integer>(list));
	        FindPathMain(root.left,target);
	        FindPathMain(root.right,target);
	        list.remove(list.size()-1);
	        return all;
	        
	    }
}
