# String源码学习
1. 学习String从注释开始
先来看一下String类的前两段的说明

```* The {@code String} class represents character strings. All
* string literals in Java programs, such as {@code "abc"}, are
* implemented as instances of this class.
//Java中所有的字符串都是String对象
* <p>
* Strings are constant; their values cannot be changed after they
* are created. String buffers support mutable strings.
* Because String objects are immutable they can be shared. 
//String是不可修改的常量，因为它不可变所以可以共享（String常量池）。
```

看一下类定义

```public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];
    /** Cache the hash code for the string */
    private int hash; // Default to 0

```String信息的存储是用的char[]数组，把String设计成不可变类，和它应该有不可分割的原因，毕竟数组的变化要求连续的空间，代价太高。

2. .构造函数
    String的构造函数个数目测有10+之多，此处只列举常用的几个
    
```//无参构造函数
    public String() {
        this.value = "".value;
    }
        //接String的构造函数
    public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
    }
        //接收char数组的构造函数
    public String(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

```
3.常用函数
charAt函数的时间复杂度O(1)
    
```public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new  StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }
```

查找字符串的位置，实现思路就是正常的一个一个字符去比较，时间复杂度较高O(m*n)
    
```public int indexOf(String str) {
        return indexOf(str, 0);
    }
    public int indexOf(String str, int fromIndex) {
        return indexOf(value, 0, value.length,
                str.value, 0, str.value.length, fromIndex);
    }
    static int indexOf(char[] source, int sourceOffset,  int sourceCount,
            char[] target, int targetOffset, int  targetCount,
            int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }
        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount -  targetCount);
        for (int i = sourceOffset + fromIndex; i <= max;  i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest  of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end &&  source[j]
                        == target[k]; j++, k++);
                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

```
字符串比较，思路比较明确，见注释
    
```public boolean equals(Object anObject) {
        //先判断地地址相等
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            //长度不相等，肯定不相等，最后才挨个字符判断
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

intern()方法，是native的。这个方法返回字符串常量池中的String对象，如果常量池中不存在相等的String对象，则将该对象加到常量池中并返回。（字符串常量是在堆区）

    
```/**
     * Returns a canonical representation for the string  object.
     * <p>
     * A pool of strings, initially empty, is maintained  privately by the
     * class {@code String}.
     * <p>
     * When the intern method is invoked, if the pool  already contains a
     * string equal to this {@code String} object as  determined by
     * the {@link #equals(Object)} method, then the string  from the pool is
     * returned. Otherwise, this {@code String} object is  added to the
     * pool and a reference to this {@code String} object  is returned.
     */
    public native String intern();
```

4.字符串拼接
jdk1.8对字符串拼接有了改进，使用+拼接字符串等同于使用StringBuilder进行拼接。看一个例子


```public class StringTest {
    public static void main(String[] args){
        String a="1"+"2";
        String b="3"+a;
        System.out.println(a);
    }
}
```
编译之后，再反编译

```public class StringTest {
    public StringTest() {
    }
    public static void main(String[] args) {
        String a = "12";
        (new StringBuilder()).append("3").append(a).toString();
        System.out.println(a);
    }
}
```
可以看到+号已被StringBuilder代替。

来看一下StringBuilder.
只留下了注释的第一行。这个是可以修改的字符序列。和它一起的还有一个线程安全的的类StringBuffer,言下之意就是它是线程不安全的。

```/**
* A mutable sequence of characters.  This class provides  an API compatible
* with {@code StringBuffer}, but with no guarantee of  synchronization.

public final class StringBuilder
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence
{

    public StringBuilder() {
        super(16);
    }

    public StringBuilder(int capacity) {
        super(capacity);
    }

    public StringBuilder(String str) {
        super(str.length() + 16);
        append(str);
    }

    public StringBuilder(CharSequence seq) {
        this(seq.length() + 16);
        append(seq);
    }
```
它的构造函数全部显示调用了父类的构造函数，实际的数据存储也是在父类中。看一下父类

```abstract class AbstractStringBuilder implements  Appendable, CharSequence {
    /**
     * The value is used for character storage.
     */
    char[] value;
    /**
     * The count is the number of characters used.
     */
    int count;
    //构造函数中申请了空间
    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }
```
又是数组进行存储的，凡是这种数组存储的，生成对象时最好给他一个预估的空间大小，不然后续可能会出现多次扩容，而扩容会涉及到新旧数组的数据复制，虽然没看也知道它调用的System.copyarray这个高校方法，但是再高效的方法都不如不调用来的损耗小。StringBuilder的构造函数都+16，就是对此的一个优化。
看一下StringBuilder的append方法
    
```public StringBuilder append(StringBuffer sb) {
        super.append(sb);//调用了父类的append
        return this;
    }
```
看一下父类的方法
    
```public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();//拼一个“null”字符串
        int len = str.length();
        ensureCapacityInternal(count + len);//确保空间够用
        str.getChars(0, len, value, count);//内部实现就是调用System.arraycopy
        count += len;
        return this;
    }

```传入str为空时 直接 return appendNull();
    
```private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;
        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;
        return this;
    }

```appendNull会拼一个“null”字符串，不明白为啥这么做。这一点拼接字符串时需需注意。
    
```private void ensureCapacityInternal(int  minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity));
        }
    }
```
//每次扩大为原来的2倍+2长度，不够直接使用老长度+新字符串长度
    
```private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE -  newCapacity < 0)
            ? hugeCapacity(minCapacity)
            : newCapacity;
    }

```
delete和insert方法内部都是调用System.arraycopy实现，其余不常用方法暂不关注。

瞅一眼StringBuffer,比StringBuilder多了个synchronized关键字，其余一样
    
```public synchronized StringBuffer append(String str) {
        toStringCache = null;
        super.append(str);
        return this;
    }
```