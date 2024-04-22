package cn.vincent.algorithm;

/**
 * 牛客：反转链表   输入  {123}  返回  {321}
 */
public class A7ListNode {
    public static ListNode result = null;
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ListNode result = ReverseList(listNode);
        System.out.println(result);
    }
    public static ListNode ReverseList(ListNode head) {
        if(head.next == null){
            result = new ListNode(head.val);
        }else{
            ReverseList(head.next);
            setNext(result, new ListNode(head.val));
        }
        return result;
    }
    public static void setNext(ListNode listNode, ListNode end){
        if(listNode.next == null){
            listNode.next = end;
        }else{
            setNext(listNode.next, end);
        }
    }
}
