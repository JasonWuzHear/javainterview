package solutions.queues;
import solutions.basics.Node;

public class Queue {
    public Node first, last;

    public void push(Object item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    public Object pull() {
        if (first == null) return null;
        Object item = first.data;
        first = first.next;
        return item;
    }
}