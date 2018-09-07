package chapter3;

public class BinarySearch<Key extends Comparable<Key>,Value> {
private Key[] keys;
private Value[] vals;
private int N;
public BinarySearch(int capacity)
{
	keys=(Key[])new Comparable[capacity];
	vals=(Value[]) new Object[capacity];
	
}
public int size()
{
	return N;
}
public Value get(Key key)
{
	if(isEmpty()) return null;
	int i=rank(key);
	if(i<N&&keys[i].compareTo(key)==0) return vals[i];
	else return null;
}
public int rank(Key key){
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
