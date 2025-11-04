package HashTable;


/**
 * @Author: Meric
 * @CreateTime: 2025-11-01
 * @Description: 3217. 从链表中移除在数组中存在的节点
 * @Version: 1.0
 */

public class deleteNodesFromLinkedListPresentInArray_3217 {

     public class ListNode {
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
     }

    public ListNode modifiedList(int[] nums, ListNode head) {
        int[] arr = new int[100001];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy;
        for(int i : nums){
            arr[i]++;
        }
        while(p != null){
            //包含进行删除
            p = pre.next;
            if(arr[p.val] !=0 ){
                p = p.next;
                pre.next = p;
            }
            else{
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
