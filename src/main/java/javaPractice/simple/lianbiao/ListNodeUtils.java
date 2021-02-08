package javaPractice.simple.lianbiao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://blog.csdn.net/qq_36213352/article/details/88082364
 *
 * https://www.cnblogs.com/bjh1117/p/8335108.html
 *
 * */
@Api("单链表的使用")
public class ListNodeUtils {

    @ApiOperation(value="将数组转换为链表形式")
    public static ListNode getList(int [] nums){
        ListNode first = new ListNode(0);
        ListNode  two = first;
        for (int val : nums){
            two.next = new ListNode(val);
            two  = two.next;
        }
//        System.out.println("{response}=========>"+first+":"+first.next);
        return first.next;
    }
    @ApiOperation(value="将链表转换为List形式")
    public static List  showList(ListNode listNode){
        ArrayList list = new ArrayList();
        if(null == listNode){
            return list;
        }
        while(listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            System.out.print(" ");
        }
        System.out.println("===========end");
        return list;
    }

    @ApiOperation(value="")
    public static ListNode  addTwoNumbers(
            ListNode listNode1, ListNode listNode2){
        ListNode first = new ListNode(0);
        ListNode curr = first;
        int result  = 0;
        while(listNode1!=null || listNode2!=null){
            int x = listNode1!=null?listNode1.val: 0;
            int y = listNode2!=null?listNode2.val: 0;
            int sum = result+ x + y;
            result = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(listNode1!=null){
                listNode1 = listNode1.next;
            }
            if(listNode2!=null){
                listNode2 = listNode2.next;
            }
        }
        if(result>0){
            curr.next = new ListNode(result);
        }
        return first.next;
    }
    @ApiOperation(value="求链表的长度")
    public static int length(ListNode listNode){
        int length = 0 ;
        if(null == listNode){
            return length;
        }
        ListNode result = listNode;
        while(null != result){
            result = result.next;
            length++;
        }
        return length;
    }

    @ApiOperation(value="删除链表节点")
    public static boolean deleteNode(ListNode listNode, int index){
        boolean result = false;
       int nodeLength = length(listNode);
       if(index<1 || index>nodeLength){
           result = false;
           System.out.println("{result0}==========>"+result);
           return result;
       }
        ListNode head = listNode;
       if(index == 1){
           head= head.next;
           result =  true;
           System.out.println("{result1}==========>"+result);
           return result;
       }
       ListNode headNext = head.next;
       int i=2;
       while(null!=headNext){
           if(i == index){
               head.next =  headNext.next;
               result = true;
           }
           head = head.next;
           headNext = headNext.next;
           i++;
       }
        System.out.println("{result2}==========>"+result);
       return result;
    }
    @ApiOperation(value="删除指定索引的链表节点，返回链表信息",notes = "需要区分是不是头节点")
    public static ListNode deleteNodeByIndex(ListNode listNode, int index){
       if(index<1 || index > length(listNode)){
           return null;
       }
       ListNode head = listNode;
       if(1 == index){
           head = head.next;
           return head;
       }
       ListNode curr = head.next;
       int i =2;
       while (null != curr){
           if(i ==index){
               head.next = curr.next;
               break;
           }
           head = head.next;
           curr = curr.next;
           i++;
       }
       return listNode;
    }
    @ApiOperation("打印链表信息")
    public static void printLinkNode(ListNode listNode){
        ListNode head = listNode;
        while(null !=head ){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    @ApiOperation("在结尾添加链表信息")
    public static ListNode addLinkNodeEnd(ListNode listNode,int data){
         if(null == listNode){
             ListNode head = new ListNode(data);
             return head;
         }
         ListNode head =listNode;
         while(null!=head.next){
             head = head.next;
         }
         head.next = new ListNode(data);
         return listNode;
    }

    @ApiOperation("链表排序")
    public static ListNode linkSortAsc(ListNode listNode){
        ListNode currNode = listNode;
        while(null!= currNode){
            ListNode nextNode = currNode.next;
            while(null != nextNode){
                if(currNode.val > nextNode.val){
                    int temp = currNode.val;
                    currNode.val = nextNode.val;
                    nextNode.val = temp;
                }
                nextNode = nextNode.next;
            }
            currNode = currNode.next;
        }
        return listNode;
    }
    @ApiOperation("去除链表重复数据")
    public static ListNode deleteRepeatData(ListNode listNode){
        ListNode currNode = listNode;
        Map<Integer,String> map =new HashMap<>();
        ListNode preNode = null;
        while(null != currNode){
             if(map.containsKey(currNode.val)){
                 preNode.next = currNode.next;
             }else {
                 map.put(currNode.val,"");
                 preNode = currNode;
             }
            currNode = currNode.next;
        }
        return listNode;
    }









}
