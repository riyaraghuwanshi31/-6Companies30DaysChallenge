// User function Template for Java

/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
          Node current = head;

        while (current != null) {
            // Skip m nodes
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            // If we've reached the end, break
            if (current == null) {
                break;
            }

            // Start deleting n nodes
            Node temp = current.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }

            // Connect the remaining part of the list
            current.next = temp;
            current = temp;
        }
    }
}
