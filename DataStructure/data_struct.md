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

## 栈

栈（stack）又名堆栈，它是一种运算受限的线性表。限定仅在表尾进行插入和删除操作的线性表。这一端被成为*栈顶*，相对的，把另一端成为*栈底*。向一个栈插入新元素又称为**进栈**、**入栈**或**压栈**，它是把新元素放到栈顶元素的上面，使之成为新的栈顶元素；从一个栈删除元素又称为**出栈**或**退栈**，它是把栈顶元素删除掉，使之相邻的元素称为新的栈顶元素。（类似于手枪的子弹夹）

![æ çæ¨¡å](https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/s%3D220/sign=4b2162dc1bd5ad6eaef963e8b1cb39a3/8b82b9014a90f603eab7c55f3912b31bb051eda7.jpg)

*栈的Java实现(基于数组)：*

```java
public class StackTest {
    public static void main(String[] args) throws Exception {
        StackFun stack = new StackFun(3);
        System.out.println("初始化时栈的容量为：" + stack.stackSize);
        stack.push(1);
        stack.push(2);
        stack.push("3");
        stack.push(6.23);
        System.out.println("入栈四个元素后栈的容量为：" + stack.stackSize);
        System.out.println("栈顶元素为：" + stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}

class StackFun {
    //创建一个Object类型的数组，用于存储任意类型的数据
    private Object[] elems;
    //指向栈顶的指针
    private int top;
    //栈的总容量
    public int stackSize;

    /**
     * 默认创建容量为10的栈
     */
    public StackFun(){
        this.elems = new Object[10];
        this.top = -1;
        this.stackSize = 10;
    }

    /**
     * 创建一个指定容量的栈
     * @param initCapacity 待创建栈的容量
     */
    public StackFun(int initCapacity) throws Exception {
        if (initCapacity < 0){
            throw new IllegalAccessException("栈的容量不能小于0：" + initCapacity);
        }

        this.elems = new Object[initCapacity];
        this.top = -1;
        this.stackSize = initCapacity;
    }

    /**
     * 数据压栈
     * @param elem 待压栈的元素
     * @return 成功的话返回该元素
     */
    public Object push(Object elem){
        //是否需要扩容
        isGrow(top + 1);
        elems[++top] = elem;
        return elem;
    }

    /**
     * 弹出元素
     * @return 返回弹出的元素
     */
    public Object pop(){
        remove(top);
        return peek();
    }

    /**
     * 获取栈顶的元素
     * @return 返回栈顶的元素
     */
    public Object peek(){
        if (top == -1){
            throw new EmptyStackException();
        }
        return elems[top];
    }

    /**
     * 判断栈是否为空
     * @return true为空
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 删除栈顶元素
     * @param top 栈顶的指针
     */
    public void remove(int top){
        elems[top] = null;
        this.top --;
    }

    /**
     *  判断栈是否需要扩容，需要的话如果扩大两倍后未超int最大值，则扩大两倍，否则扩大至int最大值
     * @param minCapacity 新元素入栈后栈的容量
     * @return 扩容返回true
     */
    public boolean isGrow(int minCapacity){
        int oldCapacity = stackSize;
        //判断当前元素压入栈之后总容量是否大于之前的容量，是的话进行扩容
        if (minCapacity >= oldCapacity){
            //定义扩容之后的栈的总容量
            int newCapacity = 0;
            //栈容量扩大俩倍
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0){
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);
            }
            this.stackSize = newCapacity;
            elems = Arrays.copyOf(elems, stackSize);
            return true;
        } else {
            return false;
        }
    }
}
```

*总结：*

堆栈是一个比较简单的数据结构，它最主要的特点是：**先进先出**，入栈和出栈的时间复杂度都为O(1)。

## 队列

队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限的线性表。进行插入操作的端称为队尾，进行删除操作的称为对头。

队列的数据元素又称为队列元素。在队列中插入一个队列元素称为入队，从队列中删除一个元素称为出队。因为队列只允许一端插入，在另一端删除，所以只有最早进入队列的元素才能最先从队列中删除，故队列又称为先进先出线性表（FIFO）。

*顺序队列*

建立顺序队列结构必须为静态分配或者动态申请一片连续的存储空间，并设置两个指针进行管理。一个队头指针front，它指向队头元素；另一个是队尾指针rear，它指向下一个入队元素的存储位置。

每次在队尾插入一个元素时，rear增1；每次在队头删除一个元素时，front增1.随着插入和删除操作的进行，队列元素的个数不断变化，队列所占的存储空间也在为队列结构所分配的连续空间中移动。当front = rear时，队列中没有任何元素，称为空队列。当rear增加到指向分配的连续空间之外时，队列无法再插入新元素，但这时往往还有大量可用空间未被占用，这些空间是已经出队的队列元素曾经占用过的存储空间。

![âéåâçå¾çæç´¢ç»æ](data:image/png;base64,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)

*循环队列*

在实际使用队列时，为了使队列空间能重复使用，往往对队列的使用方法稍加改进：无论插入或和删除，一旦rear指针增1或者front指针增1时超出了所分配的队列空间，就让它指向这片连续空间的起使位置。自己从MaxSize - 1增1变到0，可用取余运算rear % MaxSize和front % MaxSize来实现。这实际上是把队列空间想象成一个环形空间，环形空间中的存储单元循环使用，用这种方法管理的队列也就称为循环队列。

在循环队列中，当队列为空时，有front = rear，而当所有队列空间全占满时，也有front = rear。为了区别这两种情况，规定循环队列只能由MaxSize - 1个队列元素，当循环队列中只剩下一个空存储空间时，队列就已经满了。因此，队列判空的条件是front = rear，而队列判满的条件是front = （rear + 1） % MaxSize。

![âéåâçå¾çæç´¢ç»æ](data:image/png;base64,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)

*循环队列实现：*

```java
public class QueueTest {
    public static void main(String[] args) {
        QueueFun queue = new QueueFun(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert("a");
        System.out.println(queue.peekFront());
        System.out.println(queue.remove());
        System.out.println(queue.peekFront());
        System.out.println(queue.getSize());
        queue.insert(2.3);
        queue.insert(2L);

    }
}

class QueueFun {
    private Object[] queArr;
    //队列的总容量
    private int maxSize;
    //front
    private int front;
    //rear
    private int rear;
    //队列中元素的实际数目
    private int nItems;

    /**
     * 有参构造函数，初始化队列
     * @param len 创建队列的容量
     */
    public QueueFun(int len){
        this.maxSize = len;
        this.queArr = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    /**
     * 向对了中新增元素
     * @param value 待新增的元素
     */
    public void insert(Object value){
        if (isFull()){
            System.out.println("query is full !!!");
        } else {
            //如果队列尾部指向顶了，循环回来，执行队列的第一个元素
            if (rear == maxSize - 1){
                rear = -1;
            }

            //队尾 指针增1， 然后在队尾指针处插入新的数据
            queArr[++rear] = value;
            nItems ++;
        }
    }

    /**
     * 出队一个元素
     * @return 出对的元素
     */
    public Object remove(){
        Object removeElem = null;
        if (! isEmpty()){
            removeElem = queArr[front];
            queArr[front] = null;
            front ++;
            if (front == maxSize) {
                front = 0;
            }
            nItems --;
        }
        return removeElem;
    }

    /**
     * 查看队头元素
     */
    public Object peekFront(){
        return queArr[front];
    }

    /**
     * 返回队列的大小
     */
    public int getSize(){
        return nItems;
    }

    /**
     * 判断队列是否为空
     * @return true的话为空队列
     */
    public boolean isEmpty(){
        return (nItems == 0);
    }

    /**
     * 判断队列是否满了
     * @return true表示队列已满
     */
    public boolean isFull(){
        return (maxSize == nItems);
    }
}

```

*总结：*

队列是一个先进先出的线性表（可以理解成排队打饭），和栈（后进先出）正好相反。插入和删除的时间复杂度都为O(1)，搜索和空间复杂度为O(n)。



















