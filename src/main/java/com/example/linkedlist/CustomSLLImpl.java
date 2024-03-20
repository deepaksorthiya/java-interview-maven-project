package com.example.linkedlist;

public class CustomSLLImpl {

    private Node first;
    private Node last;

    private static class Node {
        private final int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public void addFirst(int data) {
        Node f = first;
        Node newNode = new Node(data, f);
        if (f == null) {
            last = newNode;
        }
        first = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data, null);
        if (first == null) {
            first = last = newNode;
            return;
        }
        Node l = last;
        l.next = newNode;
        last = newNode;
    }

    private void printll() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print(" null ");
    }

    public void reverseList() {
        Node prev = null;
        Node curr = first;
        last = curr;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        first = prev;
    }

    public static void main(String[] args) {

        CustomSLLImpl ll = new CustomSLLImpl();

        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);


        ll.printll();
        System.out.println();
        ll.reverseList();
        System.out.println();
        ll.printll();
    }


}
