package com.linkedlist;

public class SingleLinkedListDemo {
  public static void main(String[] args) {
    //创建节点
    HeroNode hero1 = new HeroNode(1, "宋江");
    HeroNode hero2 = new HeroNode(2, "卢俊义");
    HeroNode hero3 = new HeroNode(3, "吴用");
    //创建单链表
    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.addByOrder(hero1);
    singleLinkedList.addByOrder(hero3);
    singleLinkedList.addByOrder(hero2);
    //显示单链表
    singleLinkedList.list();
    System.out.println("----------------------");
    HeroNode hero4 = new HeroNode(2, "玉麒麟");
    singleLinkedList.update(hero4);
    singleLinkedList.list();
  }
}

//定义SingleLinkedList
class SingleLinkedList {
  //先初始化一个头节点
  private HeroNode head = new HeroNode(0, "");

  //添加节点到单向列表尾部
  //思路：当不考虑编号顺序时
  //1.找到当前链表的最后节点
  //2.将最后这个节点的next指向新的节点
  public void add(HeroNode heroNode) {
    //因为head节点不能动，所以我们需要一个辅助遍历temp
    HeroNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = heroNode;
  }

  //根据id添加节点到相应位置
  public void addByOrder(HeroNode heroNode) {
    //因为head节点不能动，所以我们需要一个辅助遍历temp
    HeroNode temp = head;
    boolean flag = false;
    while(true){
      if(temp.next == null){
        break;
      }
      if(temp.next.no == heroNode.no){
        flag = true;
        break;
      } else if (temp.next.no > heroNode.no) {
        break;
      }
      temp = temp.next;
    }
    if(flag){
      System.out.println("已存在");
    }else{
      heroNode.next = temp.next;
      temp.next = heroNode;
    }
  }

  //修改节点的信息，根据no编号来修改
  public void update(HeroNode newHeroNode){
    if(head.next == null){
      System.out.println("链表为空");
      return;
    }
    HeroNode temp = head.next;
    boolean flag = false;//表示是否找到该节点
    while(true){
      if(temp == null){
        break;//已经遍历完链表
      }
      if(temp.no == newHeroNode.no){
        //找到
        flag = true;
        break;
      }
      temp = temp.next;
    }
    //根据flag判断是否找到
    if(flag){
      temp.name = newHeroNode.name;
    }else{
      System.out.println("没有这个编号的节点");
    }
  }

  //显示链表（遍历
  public void list() {
    //判断链表是否为空
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    //因为head节点不能动，所以我们需要一个辅助遍历temp
    HeroNode temp = head.next;
    while (temp != null) {
      System.out.println(temp);
      temp = temp.next;
    }
  }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
  public int no;
  public String name;
  public HeroNode next;//指向下一个节点

  //构造器
  public HeroNode(int no, String name) {
    this.no = no;
    this.name = name;
  }

  //为了显示方便，重写toString
  @Override
  public String toString() {
    return "HeroNode{" +
      "no=" + no +
      ", name='" + name + '\'' +
      '}';
  }
}
