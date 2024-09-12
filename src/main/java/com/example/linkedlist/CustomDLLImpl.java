package com.example.linkedlist;

public class CustomDLLImpl {

    public Node first;
    public Node last;
    public int size = 0;

    private static class Node {
        private final int data;
        private Node next;
        private Node prev;

        public Node(Node prev, int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

       /* @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }*/
    }

    public void addFirst(int data) {
        Node f = first;
        //create node and set prev as null and next as curr first
        Node newNode = new Node(null, data, f);
        //set node as first
        first = newNode;
        //if empty then set last as newly node
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node l = last;
        Node newNode = new Node(l, data, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void printll() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(" null ");
        System.out.println();
    }

    public void reverseList() {
//        if (first == null || first.next == null) {
//            return;
//        }

        Node currNode = first;
        Node prevNode = null;

        // Traverse the list and reverse the links
        while (currNode != null) {

            // Swap the next and prev pointers
            prevNode = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = prevNode;

            // Move to the next node in the original list
            // (which is now previous due to reversal)
            currNode = currNode.prev;
        }

        // Update head of Doubly Linked List
        first = prevNode.prev;
    }

    public static void main(String[] args) {

        CustomDLLImpl ll = new CustomDLLImpl();

        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);


        ll.printll();
        System.out.println("First :: " + ll.first);
        System.out.println("Last :: " + ll.last);
        ll.reverseList();
        ll.printll();
        System.out.println("First :: " + ll.first);
        System.out.println("Last :: " + ll.last);
    }


}
