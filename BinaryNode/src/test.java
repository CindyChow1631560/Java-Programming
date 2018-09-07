

public class test{

    public static void main(String[] args) {
        
        BinarySearchTree<Integer> bst=new BinarySearchTree<>();
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
        bst.insert(9);
        bst.insert(6);
        bst.insert(4);
        System.out.println("最小值:"+bst.findMin());
        System.out.println("最大值:"+bst.findMax());
        System.out.println("查找元素9是否存在:"+bst.contains(9));
        System.out.println("查找元素8是否存在:"+bst.contains(8));
        System.out.println("遍历二叉树");
        bst.printTree();
    }
}