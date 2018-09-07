package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
String name;
int grade;
Student(String name, int grade) 
{
	this.name = name;
	this.grade =grade;
}

}

public class tt{
	public static void main(String[] args) {
Scanner in = new Scanner(System.in);
ArrayList<Student> als = new ArrayList<>();
while (in.hasNext()) {
als.clear();
int n = in.nextInt();
int flag = in.nextInt();
for (int i = 0; i < n; i++) {
als.add(new Student(in.next(), in.nextInt()));
}
Comparator c=new Comparator<Student>() {
// <a href="/profile/992988" data-card-uid="992988" class="js-nc-card" target="_blank" style="color: #25bb9b">
                @Override
public int compare(Student s1, Student s2) {
if (s1.grade < s2.grade) {
return 1;
} else if (s1.grade > s2.grade) {
return -1;
                       
}
       else
      return 0;
}
};
als.sort(c);
if (flag == 0)
{
      for (int i = 0; i < als.size() ; i++) 
      {
System.out.println(als.get(i).name + " " + als.get(i).grade);
}
            }
else {
      for (int i = als.size() - 1; i >= 0 ; i--) 
     {
    	  System.out.println(als.get(i).name + " " + als.get(i).grade);
}
}
}
}
}
	