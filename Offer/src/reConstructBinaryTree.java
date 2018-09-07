
public class reConstructBinaryTree {
     public TreeNode reConstructBinaryTreeMain(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
       }
     public TreeNode reConstructBinaryTree(int[] pre,int startpre,int endpre,int[] in,int startin,int endin){
    	 if(startpre>endpre||startin>endin)
    		 return null;
    	 TreeNode root= new TreeNode(pre[startpre]);
    	 for(int i=0;i<=endin;i++){
    		 if(in[i]==root.val){
    			root.left=reConstructBinaryTree(pre,startpre+1,startpre+i-startin,in,startin,i);
    			root.right=reConstructBinaryTree(pre,startpre+i-startin+1,endpre,in,i+1,endin);
    		 }
    	 }
    	 return root;
    	 
     }
}
