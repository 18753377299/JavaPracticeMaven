package javaPractice.simple.lianbiao;

public class ListNodeMain {
    public static void main(String []args){
        int [] nums = {3,5,6,4,2,9,7,8};
        int [] a  = {3,5,6};
        int [] b  = { 9,7,8};

        ListNode listNode = ListNodeUtils.getList(nums);
        ListNodeUtils.showList(listNode);

        ListNode l1 = ListNodeUtils.getList(a);
        ListNode l2 = ListNodeUtils.getList(b);
        ListNode l3 = ListNodeUtils.addTwoNumbers(l1,l2);
        ListNodeUtils.showList(l3);

        System.out.println("{删除链表节点}==============>");
        int [] delete   = {3,2,5,7,9,8,4,2,10};
        ListNode dl = ListNodeUtils.getList(delete);
        ListNode result = ListNodeUtils.deleteNodeByIndex(dl,3);
        ListNodeUtils.showList(result);

        System.out.println("{增加链表信息在结尾}==============>");
        ListNode addResult =  ListNodeUtils.addLinkNodeEnd(dl,4);
        ListNodeUtils.printLinkNode(addResult);

        System.out.println("{进行链表排序}==============>");
        ListNode sortResult = ListNodeUtils.linkSortAsc(addResult);
        ListNodeUtils.printLinkNode(sortResult);

        System.out.println("{删除链表重复数据}==============>");
        ListNode deleteRepeatResult = ListNodeUtils.deleteRepeatData(addResult);
        ListNodeUtils.printLinkNode(deleteRepeatResult);



    }

}
