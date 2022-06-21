package queue;

interface Queue {
  boolean isEmpty();
  void enQueue(char item);
  char deQueue();
  void delete();
  char peek();
}

class ArrayCQueue implements Queue {
  private int front;
  private int rear;
  private int queueSize;
  private char itemArray[];
  
  public ArrayCQueue(int queueSize) {
    front = rear = 0;
    this.queueSize = queueSize;
    itemArray = new char[this.queueSize];
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public boolean isFull() {
    return (rear + 1) % this.queueSize == front;
  }

  public void enQueue(char item) {
    if (isFull()) {
      System.out.println("Inserting fail! Array Circular Queue is full!!");
    } else {
      rear = (rear + 1) % this.queueSize;
      itemArray[rear] = item;
      System.out.println("Inserted Item : " + item);
    }
  }

  public char deQueue() {
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Circular Queue is empty!!");
      return 0;
    } else {
      front  = (front + 1) % this.queueSize;
      return itemArray[front];
    }
  }

  public void delete() {
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Circular Queue is empty!!");
    } else {
      front  = (front + 1) % this.queueSize;
    }
  }

  public char peek() {
    if (isEmpty()) {
      System.out.println("Peeking fail! Array Circular Queue is empty!!");
      return 0;
    } else {
      return itemArray[(front + 1) % this.queueSize];
    }
  }

  public void printStack() {
    if (isEmpty()) {
      System.out.println("Array Circular Queue is empty!! %n %n");
    } else {
      System.out.println("Array Circular Queue>> ");
      for (int i = (front + 1) % this.queueSize; i != (rear + 1) % this.queueSize; i = ++i % this.queueSize)
        System.out.printf("%c ", itemArray[i]);
      System.out.println(); System.out.println();
    }
  }
}

public class CircularQueue_Array {
  public static void main(String args[]) {
    int queueSize = 4;
    char deletedItem;
    ArrayCQueue CQ = new ArrayCQueue(queueSize);

    CQ.enQueue('A');
    CQ.printStack();

    CQ.enQueue('B');
    CQ.printStack();

    deletedItem = CQ.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    CQ.printStack();

    CQ.enQueue('C');
    CQ.printStack();

    CQ.enQueue('D');
    CQ.printStack();

    CQ.enQueue('E');
    CQ.printStack();
  }
}
