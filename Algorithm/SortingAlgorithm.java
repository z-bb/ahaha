package sort;

/**
 * 插入排序
 *      直接插入
 *      希尔排序
 * 选择排序
 *      简单选择
 *      堆排序
 * 交换排序
 *      冒泡排序
 *      快速排序
 * 归并排序
 *
 * 当n较大时，则应采用时间复杂度为O(nlogn)的排序方法：快速排序、堆排序、归并排序
 *
 * 快速排序时目前基于比较大的内部排序中被认为最好的方法，当待排的关键字是随机分布时，快排的平均时间最短
 * 如果大体有序的话，可以选择插入排序
 */
public class SortingAlgorithm {
    private static int[] arr = {4, 2, 9, 0, 1, 7, 5, 6, 3, 8};
    public static void main(String[] args) {
//        insertSort(arr);  //直接插入
//        shellSort(arr);  //希尔排序
//        selectSort(arr);  //简单选择
//        heapSort(arr);  //堆排序
//        bubbleSort(arr);  //冒泡排序
//        quickSort(0, arr.length - 1);  //快速排序
        mergeSort(arr, 0, arr.length - 1);  //归并排序
        showArr(arr);

        System.out.println("索引位置：" + binarySearch(arr, 9));  //索引位置：9
    }

    /**
     * 插入排序
     *      直接插入
     * 每步将一个待排序的记录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
     *
     * 平均时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void insertSort(int[] arr){
        //定义一个临时变量，用于存放待插入元素
        int temp;
        for (int i = 1; i < arr.length; i++){
            temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (arr[j] > temp){
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 插入排序
     *      希尔排序
     * 基于直接插入排序的思想，缩小增量排序，减少元素移动(优化)
     * 把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
     * 当增量减至1时，整个文件恰被分成一组，算法便终止
     *
     * 平均时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void shellSort(int[] arr){
        //获取数组长度，确定增量gap
        int gap = arr.length / 2;
        //定义临时变量，用于存储待插入元素
        int temp;
        while (gap > 0){
            for (int i = gap; i < arr.length; i++){
                temp = arr[i];
                //获取待比较的前一个元素的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;  //缩小增量
        }
    }

    /**
     * 选择排序
     *      简单选择
     * 设所排序序列的记录个数为n。i取1,2,…,n-1,从所有n-i+1个记录（Ri,Ri+1,…,Rn）中找出排序码最小的记录，与第i个记录交换。执行n-1趟 后就完成了记录序列的排序
     *
     * 平均时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void selectSort(int[] arr){
        int temp;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *      堆排序
     * 借助完全二叉树进行排序，将数据构建成大根堆或者小根堆，然后将顶点的元素和最后一个元素互换，然后再将其他元素构建堆的过程
     * 设一个节点为R[i]
     *      则左孩子节点为R[2i + 1], 右孩子节点为R[2i + 2]
     *      最后一个非叶子节点为R[(len - 1) / 2]
     *
     * 平均时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static void heapSort(int[] arr){
        //循环建立初始堆
        for (int i = (arr.length) / 2 - 1; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }

        //进行n - 1次循环，完成排序
        for (int i = arr.length - 1; i > 0; i--){
            //最后一个元素和第一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //然后将除最后一个元素继续大根堆的建立
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 建立堆
     */
    private static void heapAdjust(int[] arr, int parent, int length) {
        int temp = arr[parent];//保存当前父节点
        int child = parent * 2 + 1;

        while(child < length){
            //判断是否有右孩子，并且右孩子的值大于左孩子，则选择右孩子
            if(child + 1 < length && arr[child] < arr[child + 1]){
                child++;
            }
            //如果孩子节点的值大于父节点的值，则交换，并重新设置待调整的下一个索引
            if(temp < arr[child]){
                arr[parent] = arr[child];
                parent = child;
                child = parent * 2 + 1;
            }else {  //如果父节点的值大于孩子节点的值，则直接退出
                break;
            }

            //当前待调整的结点放到比其大的孩子结点位置上
            arr[parent] = temp;

        }
    }

    /**
     * 交换排序
     *      冒泡排序
     * 相邻的两个元素进行比较，大的或者小的元素往后放
     *
     * 平均时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    private static void bubbleSort(int[] arr){
        //定义临时变量
        int temp;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j <= arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 交换排序
     *      快速排序
     *
     * 选取第一个元素作为基准元素，两端各设两个哨兵，右边哨兵先开始移动，直到遇到小于基准元素时停止，接着左边的哨兵开始移动，直到遇到
     * 大于基准元素时停止，然后两元素进行交换，重复此过程，直到两哨兵相遇，将基准元素和相遇的值进行交换，此时基准元素左边的元素均小于基准
     * 元素，基准元素右边的值均大于基准元素，然后将基准元素左右两端的元素重复此过程，直至完全有序。
     *
     * 平均时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static void quickSort(int left, int right){
        int i, j, t, temp;
        if (left > right){
            return;
        }

        temp = arr[left];  //基准元素
        i = left;  //左哨兵
        j = right; //右哨兵

        while (i != j){  //顺序很重要，要右哨兵 先开始移动
            while (arr[j] >= temp && i < j){
                j--;
            }

            while (arr[i] <= temp && i < j){
                i++;
            }

            if (i < j){  //交换两个数在数组中的位置
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //最终将基准元素归位
        arr[left] = arr[i];
        arr[i] = temp;

        quickSort(left, i - 1);
        quickSort(i + 1, right);

    }

    /**
     * 归并排序
     * 建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，
     * 称为二路归并
     *
     * 平均时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static void mergeSort(int[] arr, int left, int right){
        int mid = (right + left) / 2;
        if (left < right){
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     *合并 排序
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //创建一个临时数组用于存放排好序的数据
        int[] temp = new int[right - left + 1];
        int i = left;  //左指针
        int j = mid + 1;  //右指针
        int k = 0;

        //将小的元素添加到临时数组中
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //将左边或右边剩余的元素添加到临时数组
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }

        //将临时组组添加到原数组中
        k = 0;
        while(left <= right){
            arr[left++] = temp[k++];
        }
    }

    /**
     * 二分查找
     * 前提条件：必须有序
     */
    private static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int min = 0;
        while(start <= end){
            min = (start + end) / 2;
            if(target == arr[min]){
                return min;
            } else if(target < arr[min]){
                end = min - 1;
            } else if(target > arr[min]){
                start = min + 1;
            }
        }
        return -1;
    }


    /**
     * 打印数组
     */
    private static void showArr(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

