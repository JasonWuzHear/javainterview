package solutions.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int carry = sum/10;
        l1 = l1.next; l2 = l2.next;

        ListNode head = new ListNode(sum%10);
        ListNode node = head;
        
        while(l1 != null || l2 != null || carry > 0) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            
            node.next = new ListNode(sum%10);
            node = node.next;
        }

        return head;
    }
}