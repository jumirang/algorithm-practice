package stack;

interface Stack {
  boolean isEmpty();
  void push(char item);
  char pop();
  void delete();
  char peek();
}

class ArrayStack implements Stack {
  private int top;
  private int stackSize;
  private char itemArray[];

  public ArrayStack(int stackSize) {
    top = -1;
    this.stackSize = stackSize;
    itemArray = new char[stackSize];
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Stack is empty!!");
    } else {
      top--;
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return top == -1;
  }

  public boolean isFull() {
    return top == stackSize - 1;
  }

  @Override
  public char peek() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Peeking fail! Array Stack is empty!!");
      return 0;
    } else {
      return itemArray[top];
    }
  }

  @Override
  public char pop() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      System.out.println("Deleting fail! Array Stack is empty!!");
      return 0;
    } else {
      return itemArray[top--];
    }
  }

  @Override
  public void push(char item) {
    // TODO Auto-generated method stub
    if (isFull()) {
      System.out.println("Inserting fail! Array Stack is full!!");
    } else {
      itemArray[++top] = item;
      System.out.println("Inserted Item : " + item);
    }
  }

  public void printStack() {
    if (isEmpty()) {
      System.out.println("Array Stack is empty!! %n %n");
    } else {
      System.out.println("Array Stack>> ");
      for (int i = 0; i <= top; i++)
        System.out.printf("%c ", itemArray[i]);
      System.out.println(); System.out.println();
    }
  }
}

public class Stack_Array {
  public static void main(String args[]) {
    int stackSize = 5;
    char deletedItem;
    ArrayStack S = new ArrayStack(stackSize);
    
    S.push('A');
    S.printStack();
    S.push('B');
    S.printStack();
    S.push('C');
    S.printStack();

    deletedItem = S.pop();
    if (deletedItem != 0)
      System.out.println("deleted item : " + deletedItem);
    S.printStack();
  }
}
