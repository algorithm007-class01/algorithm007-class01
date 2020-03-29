package com.steelhuasheng.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {

  public static void main(String[] args) {

    Deque<String> stackDeque = new LinkedList<String>();
    Deque<String> queueDeque = new LinkedList<String>();

    /** 第1种情况：当deque被当做stack，并使用stack的方法 **/
    System.out.println("第1种情况：当deque被当做stack，并使用stack的方法");
    stackDeque.push("a");
    stackDeque.push("b");
    stackDeque.push("c");
    System.out.println(stackDeque);// [c, b, a]

    String str1 = stackDeque.peek();
    System.out.println(str1);// c
    System.out.println(stackDeque);// [c, b, a]

    while (stackDeque.size() > 0) {
      System.out.println(stackDeque.pop());// c b a
    }
    System.out.println(stackDeque);// []

    /** 第2种情况：当deque被当做stack使用，并使用deque的方法 **/
    System.out.println("第2种情况：当deque被当做stack使用，并使用deque的方法");
    stackDeque.addFirst("a");
    stackDeque.addFirst("b");
    stackDeque.addFirst("c");
    System.out.println(stackDeque);// [c, b, a]

    String str2 = stackDeque.peekFirst();
    System.out.println(str2);// c
    System.out.println(stackDeque);// [c, b, a]

    while (stackDeque.size() > 0) {
      System.out.println(stackDeque.removeFirst());// c b a
    }
    System.out.println(stackDeque);// []

  }

}
