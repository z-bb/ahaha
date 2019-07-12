package DataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 栈
 * 特点：先进后出（类似于子弹夹）
 * 入栈和出栈的时间复杂度为O(1)
 */
public class MyStack {
    public static void main(String[] args) {
//        SimpleStack ss = new SimpleStack(3);
//        ss.push(1);
//        ss.push(2);
//        ss.push(3);
//        System.out.println(ss.isFull());
//        while (!ss.isEmpty()){
//            System.out.println(ss.pop());
//        }

        EnhanceStack es = new EnhanceStack();
        es.push(1);
        es.push(2);
        es.push(3);
        es.push("aa");
        System.out.println(es.peek());
        es.pop();
        es.pop();
        es.pop();
        System.out.println(es.peek());

        for (int i = 0; i < 15; i++){
            es.push(i);
        }
        System.out.println(es.peek());

    }
}

/**
 * 基于数组实现  通过构造方法创建指定容器的栈
 * maxSize：表示最大容量
 * top：指向栈顶变量
 */
class SimpleStack{
    private int[] arr;
    private int maxSize;
    private int top;

    SimpleStack(int size){
        this.maxSize = size;
        arr = new int[size];
        top = -1;
    }

    /**
     * 压入数据
     */
    public void push(int value){
        if (top < maxSize - 1){
            arr[++top] = value;
        }
    }

    /**
     * 弹出栈顶数据
     */
    public int pop(){
        return arr[top--];
    }

    /**
     * 访问栈顶数据
     */
    public int peek(){
        return arr[top];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 判断栈是否满了
     */
    public boolean isFull(){
        return (top == maxSize - 1);
    }
}

/**
 * 基于上述实现的栈基本功能满足，但是问题如下：
 * 1.通过构造方法创建指定容量的栈后，容量不能扩容
 * 2.数组类型单一（只能为int）
 *
 * 下面为改进版本
 */
class EnhanceStack{
    private Object[] elem;  //声明为Object类型，可接受任意类型 （java所有类的父类）
    private int size;  //栈的容量
    private int top;  //执行栈顶的指针

    public EnhanceStack(){
        this.elem = new Object[10];  //默认初始容量为10的栈
        this.size = 10;
        this.top = -1;
    }

    /**
     * 压入元素
     */
    public Object push (Object value){
        //判断是否需要扩容
        isGrow(top + 1);
        elem[++top] = value;
        return value;
    }

    /**
     * 弹出栈顶元素
     */
    public Object pop(){
        Object obj = peek();
        remove(top);
        return obj;
    }

    /**
     * 获取栈顶元素
     */
    public Object peek(){
        if (top == -1){
            throw new EmptyStackException();
        }
        return elem[top];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 删除栈顶元素
     */
    public void remove(int top){
        //栈顶元素置为null
        elem[top] = null;
        this.top--;
    }

    /**
     * 是否需要扩容，如果需要则扩大一倍，不需要则返回false
     */
    public boolean isGrow(int minCapacity){
        int oldCapacity = size;
        //如果当前元素压入栈后总容量大于前面定义的容量，则需要扩容
        if (minCapacity >= oldCapacity){
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大两倍
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0){  //扩大两倍是否大于int最大值
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);
            }
            this.size = newCapacity;
            elem = Arrays.copyOf(elem, size);
            return true;
        } else {
            return false;
        }
    }

}
