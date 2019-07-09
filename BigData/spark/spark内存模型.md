# `spark1.6`之后的内存模型

作为一个`JVM`进程，`Executor` 的内存管理建立在 `JVM` 的内存管理之上，`Spark` 对 `JVM` 的堆内（`On-heap`）空间进行了更为详细的分配，以充分利用内存。同时，`Spark` 引入了堆外（`Off-heap`）内存，使之可以直接在工作节点的系统内存中开辟空间，进一步优化了内存的使用。

​       图一.堆内和堆外内存示意图

![img](https://www.ibm.com/developerworks/cn/analytics/library/ba-cn-apache-spark-memory-management/image001.png)

图二.统一内存管理 堆内内存

![img](https://www.ibm.com/developerworks/cn/analytics/library/ba-cn-apache-spark-memory-management/image004.png)

从图中可以看出有一下几个区域：

1. `Execution` 内存：主要用于存放`Shuffle`、`Join`、`Sort`、`Aggregation` 等计算过程中的临时数据，内存占比为 `UsableMemory * spark.memory.fraction * (1 - spark.memory.storageFraction)`。
2. `Storage` 内存：主要用于缓存和广播变量数据，内存占比为 `UsableMemory * spark.memory.fraction * spark.memory.storageFraction`。
3. `Other`：主要用于存储 RDD 转换操作所需要的数据，例如 RDD 依赖等信息。内存占比为 `UsableMemory * (1 - spark.memory.fraction)`。
4. 预留内存(`Reserved Memory`)：系统预留内存。默认是`300MB`

   图三.堆外内存

![img](https://www.ibm.com/developerworks/cn/analytics/library/ba-cn-apache-spark-memory-management/image005.png)

堆外内存分为两类：`Execution` 内存和 `Storage` 内存。

默认情况下堆外内存不启用，可以通过配置`spark.memory.offHeap.enabled` 参数启用，通过配置`spark.memory.offHeap.size` 参数设定堆外内存空间的大小。

如果堆外内存被启用，那么 `Executor` 内将同时存在堆内和堆外内存，`Executor` 中的 `Execution` 内存是堆内的 `Execution` 内存和堆外的 `Execution` 内存之和，同理，`Storage` 内存也一样。

   图四.动态占用机制

![spark-memory-eviction](http://arganzheng.life/img/in-post/spark-memory-eviction.png)

动态占用机制规则如下：

1. 设定基本的`Storage` 内存和`Execution` 内存区域(通过`spark.storage.storageFraction`配置比例，默认是0.5，即各占一半)
2. `Storage` 内存和`Execution` 内存都不足时，则存储到硬盘;若己方空间不足而对方空余时，可借用对方的空间;(存储空间不足是指不足以放下一个完整的 `Block`)
3. `Execution` 内存空间被对方占用后，可让对方将占用的部分转存到硬盘，然后"归还"借用的空间
4. `Storage` 内存空间被对方占用后，无法让对方"归还"，因为实现起来较为复杂。