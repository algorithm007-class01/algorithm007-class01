# Week 02

> 原本的作业是分析 Queue 和 Priority Queue 的源码和一个关于 HashMap 的小总结。

## Swift 中的 Hash

Swift 中对 NSObject 子类对象使用 == 时要是该子类没有实现这个操作符重载的话将回滚到 -isEqual: 方法。

对于哈希计算，Swift 也采用了类似的策略。Swift 类型中提供了一个叫做 Hashable 的协议，实现这个协议即可为该类型提供哈希支持：
protocol Hashable : Equatable {
    var hashValue: Int { get }
} 

Swift 的原生 Dictionary 中，key 一定是实现了 Hashable 协议的类型。像 Int，String 这些 Swift 基础类型已经实现了这个协议
> 王巍 (onevcat). “Swifter - Swift 必备 Tips (第四版)。

自定义的类型，如果需要直接判断两个实例是否相等，就需要让类型实现 Hashable 的协议，和实现一个 == 的方法

哈希表相关资料
https://www.raywenderlich.com/206-swift-algorithm-club-hash-tables

根据上述教程中创建一个哈希表数据结构，深入了解哈希表，依次实现了哈希表的基本使用方法。

队列介绍
https://github.com/raywenderlich/swift-algorithm-club/tree/master/Queue

优先级队列
https://github.com/raywenderlich/swift-algorithm-club/tree/master/Priority%20Queue


Swift 中没有直接可以用的队列。最常用的方式是用数组的形式存储堆，然后用堆当做优先级队列使用。

---- 
发现一个有趣的网站，是专门集合 Swift 算法的 github 
https://github.com/raywenderlich/swift-algorithm-club