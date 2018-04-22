package SearchTree;/*
 *   Created by coder-pig@outlook.com on 2017/4/6.
 */

public class KthLargestElement {

    class Node {
        int val;
        int count;
        Node next;

        Node(int val) {
            this.val = val;
            this.count=1;
        }
    }

    private Node root;
    private int size;
    private int k;

    public KthLargestElement(int k, int[] nums) {
        this.k=k;
        root=new Node(Integer.MIN_VALUE);
        if(k<nums.length){
            for (int i = 0; i < k; i++) {
                insert(nums[i]);
            }

            for (int i = k+1; i <nums.length ; i++) {
                add(nums[i]);
            }
        }else{
            for (int num : nums) {
                insert(num);
            }
        }
    }

    private void insert( int val) {
        size++;
        Node node=root;
        boolean con=true;
        while (con && node!=null){
            con=false;
            if(node.val==val) node.count++;
            else if(node.next==null) node.next=new Node(val);
            else if(node.next.val>val){
                Node t=new Node(val);
                t.next=node.next;
                node.next=t;
            }else {
                node=node.next;
                con=true;
            }
        }
    }

    public int add(int val) {

        if(size<k){
            insert(val);
            return root.val;
        }else{
            insert(val);
            if(--root.count==0){
                root=root.next;
                return root.val;
            }
        }


        return 0;
    }
}
