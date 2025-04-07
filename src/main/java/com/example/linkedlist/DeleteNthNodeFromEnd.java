package com.example.linkedlist;

/**
 * Java Program for the deleting a node from end <br>
 * <a href="https://www.geeksforgeeks.org/delete-nth-node-from-the-end-of-the-given-linked-list/">GFG Link</a> </a>
 */
public class DeleteNthNodeFromEnd {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node deleteNthNodeFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;

        // Move the fast pointer n nodes
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // If fast becomes NULL, then head
        // is the nth node from end.
        if (fast == null) {
            return head.next;
        }
        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Remove the nth node from the end
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = deleteNthNodeFromEnd(head, 2);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
