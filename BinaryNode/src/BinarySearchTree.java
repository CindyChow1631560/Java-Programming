
public class BinarySearchTree<T extends Comparable<T>>{

    
    private static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;
        
        public Node(T data){
            this(data,null,null);
        }
        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    //˽�б��� ���ڵ�root
    private Node<T> root;
    
    //�޲ι��캯��,���ڵ�Ϊnull
    public BinarySearchTree(){
        root=null;
    }
    
    //��ն��������
    public void makeEmpty(){
        root=null;
    }
    //�ж����Ƿ�Ϊ��
    public boolean isEmpty(){
        
        return root==null;
    }
    //���Ҽ������Ƿ���Ԫ��value,�з���true
    public boolean contains(T value){
        
        return contains(value,root);
    }
    
    private boolean contains(T value, Node<T> t) {
        
        if(t==null){
            return false;
        }
        int result=value.compareTo(t.data);
        if(result<0){
            return contains(value,t.left);
        }else if(result>0){
            return contains(value,t.right);
        }else{
            return true;
        }
    }

    //���Ҽ����е���Сֵ
    public T findMin(){
        
        return  findMin(root).data;
    }
    private Node<T> findMin(Node<T> t) {
        if(t==null){
            return null;
        }else if(t.left==null){
            return t;
        }
        
        
        return findMin(t.left);
    }

    //���Ҽ����е����ֵ
    public T findMax(){
        
        return findMax(root).data;
    }
    
    private Node<T> findMax(Node<T> t) {
        if(t!=null){
            while(t.right!=null){
                t=t.right;
            }
        }
        
        return t;
    }

    //����Ԫ��
    public void insert(T value){
        
        root =insert(value,root);
    }

    private Node<T> insert(T value, Node<T> t) {
        if(t==null){
            return new Node(value,null,null);
        }
        int result=value.compareTo(t.data);
        if(result<0){
            t.left=insert(value,t.left);
        }else if(result>0){
            t.right=insert(value,t.right);
        }
        return t;
    }
    //�Ƴ�Ԫ��
    public void remove(T value){
        root=remove(value,root);
        
        
    }

    private Node<T> remove(T value, Node<T> t) {
        if(t==null){
            return t;
        }
        
        int result=value.compareTo(t.data);
        if(result<0){
            t.left=remove(value,t.left);
        }else if(result>0){
            t.right=remove(value,t.right);
        }else if(t.left!=null&&t.right!=null){//�����ɾ���ڵ�����������
            //1.��ǰ�ڵ�ֵ��������������Сֵ����
            t.data=findMin(t.right).data;
            //������������Сֵɾ��
            t.right=remove(t.data, t.right);
        }else{
            //�����ɾ���ڵ���һ��Ҷ�� ��ֻ��һ������
            t=(t.left!=null)?t.left:t.right;
        }
        
        return t;
    }
    
    //���������ӡ
    public void printTree(){
        printTree(root);
    }

    private void printTree(Node<T> t) {
        
        if(t!=null){
            printTree(t.left);
            System.out.println(t.data);
            printTree(t.right);
        }
    }
}