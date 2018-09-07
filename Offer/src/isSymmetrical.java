
public class isSymmetrical {
	boolean isSymmetricalMain(TreeNode pRoot)
    {
        if(pRoot==null)
        	return true;
        return Symmetric(pRoot.left,pRoot.right);
    }
	public static boolean Symmetric(TreeNode left,TreeNode right){
		if(left==null) return right==null;
		if(right==null) return false;
		if(left.val!=right.val) return false;
		return Symmetric(left.right,right.left) && Symmetric(left.left,right.right);
	}
}
