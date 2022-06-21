package queue;

interface Queue {
  boolean isEmpty();
  void enQueue(char item);
  char deQueue();
  void delete();
  char peek();
}

class QueueNode {
  char data;
  QueueNode link;
}

class LinkedQueue implements Queue {
  QueueNode front;
  QueueNode rear;

  @Override
  public boolean isEmpty() {
    return front == null;
  }

  @Override
  public void enQueue(char item) {
    QueueNode newNode = new QueueNode();
    newNode.data = item;
    newNode.link = null;
    if (isEmpty()) {
      front = newNode;
      rear = newNode;
    } else {
      rear.link = newNode;
      rear = newNode;
    }
    System.out.println("Inserted Item : " + item);
  }
  
  @Override
  public char deQueue() {
    if (isEmpty()) {
      System.out.println("Deleting fail! Linked Queue is empty!!");
      return 0;
    } else {
      char item = front.data;
      front = front.link;
      if (front == null) rear = null;
      return item;
    }
  }

  @Override
  public void delete() {
    if (isEmpty()) {
      System.out.println("Deleting fail! Linked Queue is empty!!");
    } else {
      front = front.link;
      if (front == null) rear = null;
    }
  }

  @Override
  public char peek() {
    if (isEmpty()) {
      System.out.println("Deleting fail! Linked Queue is empty!!");
      return 0;
    } else {
      return front.data;
    }
  }

  public void printQueue() {
    if (isEmpty()) {
      System.out.printf("Linked Queue is empty!! %n %n");
    } else {
      QueueNode temp = front;
      System.out.printf("Linked Queue >> ");
      while (temp != null) {
        System.out.printf("%c ", temp.data);
        temp = temp.link;
      }
      System.out.println();
      System.out.println();
    }
  }
}

public class Queue_LinkedList {
  public static void main(String args[]) {
    char deletedItem;
    LinkedQueue LQ = new LinkedQueue();

    LQ.enQueue('A');
    LQ.printQueue();

    LQ.enQueue('B');
    LQ.printQueue();

    deletedItem = LQ.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    LQ.printQueue();

    LQ.enQueue('C');
    LQ.printQueue();

    deletedItem = LQ.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    LQ.printQueue();

    deletedItem = LQ.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    LQ.printQueue();

    deletedItem = LQ.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    LQ.printQueue();
  }
}
