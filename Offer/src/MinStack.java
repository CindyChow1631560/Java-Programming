import java.util.Stack;
public class MinStack {
	 Stack<Integer> stack1=new Stack();
	    Stack<Integer> stack2=new Stack();
	    public void push(int node) {
	        stack1.push(node);
	        if(stack2.isEmpty())
	            stack2.push(node);
	        else if(stack2.peek()>node)
	            stack2.push(node);
	    }
	    
	    public void pop() {
	        //if(stack1.top()==stack2.top())
	            //stack2.pop();
	        stack1.pop();
	    }
	    
	    public int top() {
	       return stack1.peek();
	    }
	    
	    public int min() {
	        return stack2.peek();
	    }
}
