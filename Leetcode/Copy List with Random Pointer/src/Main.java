import java.util.*;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for(int i=2; i<6; i++){
            cur.next = new Node(i);
            cur.random = head;
            cur = cur.next;
        }
        Node newhead = copyRandomList(head);
        cur = newhead;
        while(cur != null){
            System.out.println(cur.val);
            if(cur.next != null){
                System.out.println(cur.next.val);
                System.out.println(cur.random.val);
            }
            System.out.print(" \n");
            cur = cur.next;
        }
        System.out.println("Is the same node?"+(head==newhead));
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        for(Node cur = head;cur != null;cur = cur.next){
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
        }
        for(Node cur = head;cur != null;cur = cur.next){
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }
        return map.get(head);
    }
}