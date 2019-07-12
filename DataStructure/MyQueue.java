package DataStructure;

/**
 * 队列
 * 特点：先进先出（类似于排队打饭）
 * 只允许在前端进行删除操作，在后端进行插入操作
 */
public class MyQueue {
    public static void main(String[] args) {
        SinQjueue ss = new SinQjueue(5);
        ss.insert(1);
        ss.insert(2);
        ss.insert(3);
        ss.insert("aa");
        System.out.println(ss.peekFront());
        ss.remove();
        System.out.println(ss.peekFront());
        ss.insert("aa");
        ss.insert("bb");
        ss.insert("cc");

    }
}

class SinQjueue{
    private Object[] queArr;
    private int maxSize;  //队列总大小
    private int front;  //前端
    private int rear;  //后端
    private int nItems;  //队列中元素的实际数目

    public SinQjueue(int s){
        maxSize = s;
        queArr = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 队列中新增元素
     */
    public void insert(Object value){
        if (isFull()){
            System.out.println("队列已满！");
        } else {
            //如果队列尾部指向顶了，循环，执行队列的第一个元素
            if (rear == maxSize - 1){
                rear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            queArr[++rear] = value;
            nItems++;
        }
    }

    /**
     * 移除元素
     */
    public Object remove(){
        Object removeValue = null ;
        if(!isEmpty()){
            removeValue = queArr[front];
            queArr[front] = null;
            front++;
            if(front == maxSize){  //如果前端走到队尾，循环，将前端置为0
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }


    /**
     * 查看队头数据
     */
    public Object peekFront(){
        return queArr[front];
    }


    /**
     * 判断队列是否满了
     */
    public boolean isFull(){
        return (nItems == maxSize);
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return (nItems ==0);
    }

    /**
     * 返回队列的大小
     */
    public int getSize(){
        return nItems;
    }
}

