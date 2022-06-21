package list;

public class SimpleLinkedList {
  public static void main(String args[]) {
    LinkedList L = new LinkedList();
    System.out.println("(1) Insert 3 node in blank list");
    L.insertLastNode("Mon");
    L.insertLastNode("Wed");
    L.insertLastNode("Sun");
    L.printList();

    System.out.println("(2) Insert Fri node behind Wed node");
    ListNode pre = L.searchNode("Wed");
    if (pre == null) {
      System.out.println("Search failure >> there are no finding data");
    } else {
      L.insertMiddleNode(pre, "Fri");
      L.printList();
    }

    System.out.println("(3) Change list node reversely");
    L.reverseList();
    L.printList();

    System.out.println("(4) Delete the last node in list");
    L.deleteLastNode();
    L.printList();
  }
}

class LinkedList {
  private ListNode head;
  public LinkedList() {
    head = null;
  }
  public void insertMiddleNode(ListNode pre, String data) {
    ListNode newNode = new ListNode(data);
    newNode.link = pre.link;
    pre.link = newNode;
  }
  public void insertLastNode(String data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
    } else {
      ListNode temp = head;
      while (temp.link != null) temp = temp.link;
      temp.link = newNode;
    }
  }
  public void deleteLastNode() {
    ListNode pre, temp;
    if (head == null) return;
    if (head.link == null) {
      head = null;
    } else {
      pre = head;
      temp = head.link;
      while (temp.link != null) {
        pre = temp;
        temp = temp.link;
      }
      pre.link = null;
    }
  }
  public ListNode searchNode(String data) {
    ListNode temp = head;
    while (temp != null) {
      if (data == temp.getData()) return temp;
      else temp = temp.link; 
    }
    return temp;
  }
  public void reverseList() {
    ListNode next = head;
    ListNode current = null;
    ListNode pre = null;
    while (next != null) { // pre - current - next
      pre = current;
      current = next;
      next = next.link;
      current.link = pre;
    }
    head = current;
  }
  public void printList() {
    ListNode temp = head;
    System.out.printf("L = (");
    while (temp != null) {
      System.out.printf(temp.getData());
      temp = temp.link;
      if (temp != null) {
        System.out.printf(", ");
      }
    }
    System.out.println(")");
  }
}

class ListNode {
  private String data;
  public ListNode link;
  public ListNode() {
    this.data = null;
    this.link = null;
  }
  public ListNode(String data) {
    this.data = data;
    this.link = null;
  }
  public ListNode(String data, ListNode link) {
    this.data = data;
    this.link = link;
  }
  public String getData() {
    return this.data;
  }
}
