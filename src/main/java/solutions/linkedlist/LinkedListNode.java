package solutions.linkedlist;

public class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int v) {
        data = v;
    }

    public void append(int v) {
        cleanLoops();
        if (next == null) next = new LinkedListNode(v);
        else next.append(v);
    }

    public LinkedListNode get(int n) {
        if (n == 0) return this;
        if (next == null) return null;
        return next.get(n - 1);
    }

    public void cleanLoops() {}
}