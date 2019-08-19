## 数据结构和算法简介

**数据结构是计算机存储、组织数据的方式，指相互之间存在一种或多种特定关系的数据元素集合。**

*常见的数据结构：*

![img](https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=18e82edcd93f8794d3aa4028e22b22cc/a6efce1b9d16fdfa25fc0b8ab98f8c5495ee7bc6.jpg)

*这几种结构的特点：*

| 数据结构 |                  优点                  |                         缺点                         |
| :------: | :------------------------------------: | :--------------------------------------------------: |
|   数组   |                 插入快                 |      查找慢，删除慢，大小固定，只能存储单一元素      |
| 有序数组 |            比无序数组查询快            |      插入慢，删除慢，大小固定，只能存储单一元素      |
|    栈    |         提供后进先出的存取方式         |                    存取其他项很慢                    |
|   队列   |         提供先进先出的存取方式         |                    存取其他项很慢                    |
|   链表   |             插入快，删除快             |                        查找慢                        |
|  二叉树  | 如果树是平衡的，则查找，插入，删除都快 |                     删除算法复杂                     |
|  红黑树  |   查找，删除，插入都快。树总是平衡的   |                       算法复杂                       |
|  哈希表  |       如果是关键字已知则存取极快       | 删除慢，如果不知道关键字存取慢，对存储空间使用不充分 |
|    堆    |    插入，删除快，对最大数据项存取快    |                  对其他数据项存取慢                  |
|    图    |             对现实世界建模             |                   有些算法慢且复杂                   |

*算法的五个特征：*

1. **有穷性（Finiteness）**：算法的有穷性是指算法必须能在执行有限个步骤之后终止；
2. **确切性(Definiteness)**：算法的每一步骤必须有确切的定义；
3. **输入项(Input)**：一个算法有0个或多个输入，以刻画运算对象的初始情况，所谓0个输入是指算法本身定出了初始条件；
4. **输出项(Output)**：一个算法有一个或多个输出，以反映对输入数据加工后的结果。没有输出的算法是毫无意义的；
5. **可行性(Effectiveness)**：算法中执行的任何计算步骤都是可以被分解为基本的可执行的操作步，即每个计算步都可以在有限时间内完成（也称之为有效性）。

*算法的评定*

同一问题可用不同算法解决，而一个算法的质量优劣将影响到算法乃至程序的效率。算法分析的目的在于选择合适算法和改进算法。一个算法的评价主要从**时间复杂度**和**空间复杂度**来考虑。

##### 时间复杂度

算法的时间复杂度是指执行算法所需要的计算工作量。一般来说，计算机算法是问题规模n 的函数f(n)，算法的时间复杂度也因此记做。

T(n)=Ο(f(n))

因此，问题的规模n 越大，算法执行的时间的增长率与f(n) 的增长率正相关，称作**渐进时间复杂度（Asymptotic Time Complexity）**。

##### 空间复杂度

算法的空间复杂度是指算法需要消耗的内存空间。其计算和表示方法与**时间复杂度**类似，一般都用复杂度的*渐近性*来表示。同时间复杂度相比，空间复杂度的分析要简单得多。

##### 正确性

算法的正确性是评价一个算法优劣的最重要的标准。

##### 可读性

算法的可读性是指一个算法可供人们阅读的容易程度。

##### 健壮性

健壮性是指一个算法对不合理数据输入的反应能力和处理能力，也称为**容错性**。



## 数组



在Java中，数组是用来存放*同一种数据类型*的集合！

*数组的声明：*

```java
//数据类型[] 数组名称 = new 数组类型[数组长度];
int[] arr1 = new int[5];
//数据类型[] 数组名称 = {elem1, elem2, elem3 ...}
int[] arr2 = {1, 2, 3, 4, 5};
```

*访问数组元素：*

```java
//声明一个长度为5，且只能存储int类型的数组
int[] arr = new int[5];
//数组可以通过下标进行查找和赋值，初始偏移量为0
//将数组的第一个元素赋值为1
arr[0] = 1;  
System.out.println(arr[0]);
```

*数组的遍历：*

```java
int[] arr = {1, 2, 3, 4, 5};
for(int i = 0; i < arr.length; i++){
    System.out.println(arr[i]);
}
```

*数组的基本功能：*

```java
public class ArrayTest {
    public static void main(String[] args) {
        ArrayFun arr = new ArrayFun();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.disPlay();
        System.out.println(arr.getLength());
        int elem = arr.getElem(0);
        System.out.println(elem);
        System.out.println(arr.delete(1));
        arr.disPlay();

    }
}

class ArrayFun{

    //定义一个数组
    private int[] arr;
    //定义数组的长度
    private int arrLength;
    //定义一个数组中元素的个数
    private int elemCount;

    /**
     * 默认无参构造函数，定义一个长度为10的数组
     */
    public ArrayFun(){
        arrLength = 10;
        elemCount = 0;
        arr = new int[arrLength];
    }

    /**
     * 有参的构造函数，定义一个指定长度的数组
     * @param len 要构造数组的长度
     */
    public ArrayFun(int len){
        arrLength = len;
        elemCount = 0;
        arr = new int[arrLength];
    }

    /**
     * 获取数组中有效元素的个数
     * @return 数组中元素的个数
     */
    public int getLength(){
        return elemCount;
    }

    /**
     * 遍历数组元素
     */
    public void disPlay(){
        System.out.println("数组中的元素为：");
        for (int i = 0; i < elemCount; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 向数组中添加元素
     * @param elem 元素
     * @return 返回值，成功为true 失败为false
     */
    public boolean add(int elem){
        if (elemCount == arrLength){
            return false;
        } else {
            arr[elemCount] = elem;
            elemCount ++;
        }
        return true;
    }

    /**
     * 根据数组下标获取元素
     * @param index 数组下标
     * @return 数组下标对应元素
     */
    public int getElem(int index){
        if (index < 0 || index > arrLength){
            System.out.println("访问数组下标越界！");
            return -1;
        }
        return arr[index];
    }

    /**
     * 根据元素查找在数组中所在下标
     * @param elem  要查找的元素
     * @return  -1该元素不存在，
     */
    public int searchElem(int elem){
        int i;
        for (i = 0; i < elemCount; i++){
            if (arr[i] == elem){
                break;
            }
        }
        if (i == elemCount){
            return -1;
        }
        return i;
    }

    /**
     * 删除数组中元素
     * @param elem 待删除元素
     * @return 成功返回true
     */
    public boolean delete(int elem){
        int j = searchElem(elem);

        if(j == -1){
            return false;
        } else {
            if (j == elemCount - 1){
                elemCount--;
            } else {  //将之后的元素向前移动一位
                for (int i = j; i < elemCount; i++){
                    arr[i] = arr[i + 1];
                }
                elemCount--;
            }
            return true;
        }
    }

    /**
     * 修改数据
     * @param oldElem 要修改的元素
     * @param newElem 修改后的元素
     * @return 成功返回true
     */
    public boolean update(int oldElem, int newElem){
        int j = searchElem(oldElem);

        if (j == -1){
            System.out.println("数据不存在！");
            return false;
        } else {
            arr[j] = newElem;
            return true;
        }
    }
}
```

*总结（无序数组）：*

1. 插入快，只需在数组尾添加元素就可以了。
2. 查找慢，需从第一个元素开始遍历，直到找到该元素。
3. 删除慢，如果找到待删除元素的位置，并将之后的元素向前移动一位（如果删除的是第一位，所有元素都需移动）
4. 长度不可变，数组一旦创建，大小就固定了。不能进行动态扩容，如果初始化一个很大的数组，会浪费空间；如果小了，会超过数组容量的最大值。

































