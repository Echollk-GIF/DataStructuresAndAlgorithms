package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
  public static void main(String[] args) {
  }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
  private int maxSize;//表示数组的最大容量
  private int front;//指向队列头
  private int rear;//指向队列尾
  private int[] arr;//用于存放数据

  //创建队列的构造器
  public ArrayQueue(int arrMaxSize){
    this.maxSize = arrMaxSize;
    this.arr = new int[this.maxSize];
    this.front = -1;//指向队列头部第一个数据的前一个位置
    this.rear = -1;//指向队列尾部（即就是队列最后一个数据）
  }

  //判断队列是否满
  public boolean isFull(){
    return this.rear == this.maxSize-1;
  }
  //判断队列是否为空
  public boolean isEmpty(){
    return this.front == this.rear;
  }
  //添加数据到队列
  public void addQueue(int n){
    //判断队列是否满
    if(isFull()){
      System.out.println("队列满，不能加入数据");
      return;
    }
    this.rear++;
    this.arr[rear] = n;
  }
  //获取队列的数据，出队列
  public int getQueue(){
    if(isEmpty()){
      System.out.println("队列已空");
      throw new RuntimeException("队列为空,不能取数据");
    }
    this.front++;
    return this.arr[this.front];
  }
  //输出所有数据
  public void showQueue(){
    if(isEmpty()){
      System.out.println("队列为空，没有数据");
    }
    for(int i= 0;i<this.arr.length;i++){
      System.out.printf("arr[%d]=%d",i,this.arr[i]);
    }
  }
  //显示队列头数据（注意不是取出数据）
  public int headQueue(){
    if(isEmpty()){
      throw new RuntimeException("队列空，无数据");
    }
    return this.arr[this.front+1];
  }
}
