package javaPractice.simple.lianbiao;

import io.swagger.annotations.Api;

@Api("链表节点")
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
