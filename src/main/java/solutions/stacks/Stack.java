package solutions.stacks;
import solutions.basics.Node;

public class Stack {
    public Node top;

    public Object pop() {
        if (top == null) return null;

        Object item = top.data;
        top = top.next;
        return item;
    }

    public void push(Object item) {
        Node n = new Node(item);
        n.next = top;
        top = n;
    }
}