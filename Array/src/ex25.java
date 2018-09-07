import java.util.*;

class MyList extends ArrayList
{
	List mylist=new ArrayList();
	MyList(List l) {mylist=l;}
	@SuppressWarnings("unchecked")
	MyList getreversed()
	{
		ListIterator lit=mylist.listIterator(mylist.size());
		List reverselist=new ArrayList();
		while(lit.hasPrevious())
		{
			reverselist.add(lit.previous());
		}
		return new MyList(reverselist);
	}
}
public class ex25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> alist=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
System.out.println(alist);
System.out.println(alist.get(4));
alist.add(new Integer(6));
alist.addAll(new ArrayList(Arrays.asList(7,8)));
System.out.println(alist);
MyList ml = new MyList(alist);
ml=ml.getreversed();
System.out.print(ml.mylist);
	}

}
