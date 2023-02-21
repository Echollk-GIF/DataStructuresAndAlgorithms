package com.queue;

public class CircleArrayQueueDemo {
  public static void main(String[] args) {

  }
}

class CircleArray {
  private int maxSize;
  private int front;
  private int rear;
  private int[] arr;

  public CircleArray(int maxSize) {
    this.maxSize = maxSize;
    this.arr = new int[maxSize];
  }

  public boolean isFull() {
    return (rear + 1) % maxSize == front;
  }

  public boolean isEmpty() {
    return rear == front;
  }

  public void addQueue(int n) {
    if (isFull()) {
      return;
    }
    arr[rear] = n;
    rear = (rear + 1) % maxSize;
  }

  public int getQueue() {
    if (isEmpty()) {
      throw new RuntimeException("队列为空");
    }
    int value = arr[front];
    front = (front + 1) % maxSize;
    return value;
  }

  public void showQueue() {
    if (isEmpty()) {
      return;
    }
    //从front开始遍历
    for (int i = front; i < front + size(); i++) {
      System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
    }
  }

  //求出当前队列有效数据的个数
  public int size() {
    return (rear - front + maxSize) % maxSize;
  }
  //显示头元素
  public int headQueue(){
    if(isEmpty()){
      throw new RuntimeException("空队列");
    }
    return arr[front];
  }
}
