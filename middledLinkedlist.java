import java.lang.classfile.components.ClassPrinter.ListNode;

class solution{

    int length(ListNode head){
        int len =0; 
        ListNode cur = head;
        while(cur!= null){
            cur cur.next;
            len+= 1;
        }

        return len;
    }

    public ListNode middleNode (ListNode head){
        int N  =  length(head);
        ListNode cur = head;
        for(int i =0; i<N/2; i++){
            cur = cur.next;
            return cur;
        }
    }
}