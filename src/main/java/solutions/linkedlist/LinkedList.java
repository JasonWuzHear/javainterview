package solutions.linkedlist;

public class LinkedList<T> {
    public Node<T> head;

    public LinkedList() {

    }

    public void append(Node<T> n) {
        last().next = n;
    }

    public Node<T> get(int index) {
        Node<T> n = head;
        for(int i = 0; i < index; i++) {
            if (n == null) break;
            n = n.next;
        }
        return n;
    }

    public Node<T> last() {
        Node<T> n = head;
        while(n.next != null) {
            n = n.next;
        }
        return n;
    }

    public int length() {
        int len = 1;
        Node<T> n = head;
        while(n.next != null) {
            len++;
            n = n.next;
        }
        return len;
    }
}