

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
        System.out.println("��Сֵ:"+bst.findMin());
        System.out.println("���ֵ:"+bst.findMax());
        System.out.println("����Ԫ��9�Ƿ����:"+bst.contains(9));
        System.out.println("����Ԫ��8�Ƿ����:"+bst.contains(8));
        System.out.println("����������");
        bst.printTree();
    }
}