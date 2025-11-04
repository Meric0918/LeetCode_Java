package TwoPointers;


/**
 * @Author: Meric
 * @CreateTime: 2025-10-27
 * @Description: 160. 相交链表
 * @Version: 1.0
 */

/**
 *  本题目先计算出ListA与ListB的长度，然后将A与B的末尾对齐，以短的链表为标准将指针p q指向（从后向前）同一长度的位置，
 *  在循环体中，如果找到p与q指向同一个节点就返回此节点（p）
 *  否则，p或者q指向null时候，直接退出返回null（p）
 */

public class intersectionOfTwoLinkedLists_160 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int len(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        int diff = 0;
        ListNode p, q;
        if (lenA > lenB) {
            p = headA;
            q = headB;
            diff = lenA - lenB;
        } else {
            p = headB;
            q = headA;
            diff = lenB - lenA;
        }
        while (diff > 0) {
            p = p.next;
            diff--;
        }
        while (p != null && q != null && p != q) {
        //while (p != null && q != null && p.val != q.val) {
        // leectode中p与q为共用节点，而这里构造的只是val一样
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static ListNode createListNode(int[] values){
        // 1. 创建一个虚拟头节点，它的值可以是任意的，因为它不会成为链表的一部分
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead; // current 指针从虚拟头节点开始

        // 2. 循环遍历所有元素，无需特殊处理第一个
        for (int val : values) {
            current.next = new ListNode(val); // 在 current 后面创建并连接新节点
            current = current.next;           // 将 current 指针移动到新节点上
        }

        // 3. 真正的链表头是虚拟头节点的下一个节点
        ListNode head = dummyHead.next;
        return head;
    }

    public static void printListNode(ListNode head){
        ListNode p = head;
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        int[] valuesA = {1, 9, 1, 2, 4};
        int[] valuesB = {3, 2, 4};
        ListNode headA = createListNode(valuesA);
        ListNode headB = createListNode(valuesB);
        printListNode(headA);
        printListNode(headB);
        System.out.println(getIntersectionNode(headA, headB));
    }
}
