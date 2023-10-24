package leetcode;

/**
 * @author wei tan
 */
public class _2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));


        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //initialize the first node
        ListNode node = new ListNode();
        //keep the reference of the first node;
        ListNode result = node;

        //record carry
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            //add carry to current sum
            sum += carry;
            //update current value
            node.val = sum % 10;
            carry = sum / 10;

            //if it could have the next, add the next node
            //if it could have the next, add the next node
            if (l1 != null || l2 != null || carry != 0) {
                ListNode next = new ListNode();
                node.next = next;
                node = next;
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(val);
            toString(sb);
            return sb.reverse().toString();
        }

        private void toString(StringBuilder sb) {
            if (next == null){
                sb.append(val);
                return;
            }
            sb.append(val);
            next.toString(sb);
        }
    }
}
