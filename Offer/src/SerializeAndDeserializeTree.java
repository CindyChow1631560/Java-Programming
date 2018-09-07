
public class SerializeAndDeserializeTree {
	int index=-1;
	String Serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
        if(root==null){
        	result.append("#,");
        	return result.toString();
        }
        result.append(root.val+",");
        result.append(Serialize(root.left));
        result.append(Serialize(root.right));
        return result.toString();
	  }
	    TreeNode Deserialize(String str) {
	       index++;
	       if(str==null)
	    	   return null;
	       String[] strarray = str.split(",");
	       TreeNode node =null;
	       while(!strarray[index].equals("#")){
	    	   node = new TreeNode(Integer.valueOf(strarray[index]));
	    	   node.left=Deserialize(str);
	    	   node.right=Deserialize(str);
	       }
	       return node;
	    		   
	  }
}
    /*class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}*/