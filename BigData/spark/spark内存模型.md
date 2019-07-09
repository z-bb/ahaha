`spark1.6`之后的内存模型

作为一个`JVM`进程，`Executor` 的内存管理建立在 `JVM` 的内存管理之上，`Spark` 对 `JVM` 的堆内（`On-heap`）空间进行了更为详细的分配，以充分利用内存。同时，`Spark` 引入了堆外（`Off-heap`）内存，使之可以直接在工作节点的系统内存中开辟空间，进一步优化了内存的使用。

![img](https://www.ibm.com/developerworks/cn/analytics/library/ba-cn-apache-spark-memory-management/image001.png)