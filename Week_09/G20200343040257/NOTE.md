# 学习笔记

讲到了字符串就顺便复习下Java中String的特性

## Java中的字符串

Java中操作字符串的类有String,StringBuilder,StringBuffer。  
其中StringBuilder和StringBuffer自JDK5引入，
他们均继承AbstractStringBuilder，AbstractStringBuilder和String一样使用字符数组保存储字符串。
* 字符串的内容永不可变(immutable),底层是被final修饰的数组 

```
    /** The value is used for character storage. */  
    private final char value[];
```
* 对字符串的任何改动相当于是在内存中创建了一个新的对象再把它的引用指向该对象。

* String对象创建后会在常量池中进行缓存，下次创建字符串对象时如果已存在于常量池中则直接返回相应的引用给创建者。

* StringBuffer可以在原对象修改且线程安全。

* StringBuilder不是线程安全的但是效率比StringBuffer高。

## 字符串匹配算法

* Rabin-Karp 算法的思想： 

  1. 假设子串的长度为 M (pat)，目标字符串的长度为 N (txt) 
  2. 计算子串的 hash 值 hash_pat 
  3. 计算目标字符串txt中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1次） 
  4. 比较 hash 值：如果 hash 值不同，字符串必然不匹配; 如果 hash 值相同，还需要使用朴素算法再次判断

```
    public final static int D = 256;
    public final static int Q = 9997;

    staticintRabinKarpSerach(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int patHash = 0, txtHash = 0;
        for (i = 0; i < M; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + txt.charAt(i)) % Q;
        }
        int highestPow = 1;  //
        pow(256, M - 1) for (i = 0; i < M - 1; i++) highestPow = (highestPow * D) % Q;
        for (i = 0; i <= N - M; i++) {
            // 枚举起点
            if (patHash == txtHash) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) break;
                }
                if (j == M) return i;
            }
            if (i < N - M) {
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
                if (txtHash < 0) txtHash += Q;
            }
        }
        return -1;
    }
```
* KMP 算法：  
KMP算法（Knuth-Morris-Pratt）的思想就是，当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功那 一部分的字符（包括子串与目标字符串）。
以阮一峰的文章为例，当空格与 D 不匹配时，你其实 知道前面六个字符是“ABCDAB”。KMP 算法的想法是，设法利用这个已知信息，
不要把“搜索位置” 移回已经比较过的位置，继续把它向后移，这样就提高了效率。  
http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
* Boyer-Moore 算法：https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
* Sunday 算法：https://blog.csdn.net/u012505432/article/details/52210975
