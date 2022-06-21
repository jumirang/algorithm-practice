package queue;

interface Queue {
  boolean isEmpty();
  void enQueue(char item);
  char deQueue();
  void delete();
  char peek();
}

class ArrayQueue implements Queue {
  private int front;
  private int rear;
  private int queueSize;
  private char itemArray[];

  public ArrayQueue(int queueSize) {
    front = rear = -1;
    this.queueSize = queueSize;
    itemArray = new char[this.queueSize];
  }

  @Override
  public char deQueue() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Queue is empty!!");
      return 0;
    } else {
      return itemArray[++front];
    }
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Queue is empty!!");
    } else {
      front++;
    }
  }

  @Override
  public void enQueue(char item) {
    // TODO Auto-generated method stub
    if (isFull()) {
      System.out.println("Inserting fail! Array Queue is full!!");
    } else {
      itemArray[++rear] = item;
      System.out.println("Inserted Item : " + item);
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return front == rear;
  }

  public boolean isFull() {
    return rear == this.queueSize - 1;
  }

  @Override
  public char peek() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Peeking fail! Array Queue is empty!!");
      return 0;
    } else {
      return itemArray[front + 1];
    }
  }

  public void printStack() {
    if (isEmpty()) {
      System.out.println("Array Queue is empty!! %n %n");
    } else {
      System.out.println("Array Queue>> ");
      for (int i = front + 1; i <= rear; i++)
        System.out.printf("%c ", itemArray[i]);
      System.out.println(); System.out.println();
    }
  }
}

public class Queue_Array {
  public static void main(String args[]) {
    int queueSize = 5;
    char deletedItem;
    ArrayQueue Q = new ArrayQueue(queueSize);
    
    Q.enQueue('A');
    Q.printStack();
    Q.enQueue('B');
    Q.printStack();
    Q.enQueue('C');
    Q.printStack();

    deletedItem = Q.deQueue();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    Q.printStack();
  }
}
