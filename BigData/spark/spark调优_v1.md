## Spark调优

*原则一：避免重复创建RDD*

*原则二：尽可能复用RDD*

*原则三：对多次使用的RDD进行持久化*

*原则四：尽量避免使用shuffle类算子*

*原则五：使用combiner算子(reduceByKey、aggregateByKey...)*

*原则六：使用高性能算子*

*原则七：广播变量*

*原则八：使用Kryo序列化方式(缺点：用户自定义类需要注册)*

*原则九：优化数据结构*

## 资源参数调优

**num-executors**

*参数说明：该参数用于设置spark作业总共要用多少executor进程来执行。Driver在向yarn集群管理器申请资源时，yarn集群管理器会尽可能按照你的设置在集群的各个工作节点上启动相应数量的executor进程。*

*参数调优建议：每个spark作业的运行一般设置50-100个左右的executor进程比较合适，设置太少或太多的executor进程都不好。设置的太少，无法充分利用集群资源；设置的太多的话，大部分队列可能无法给与充分的资源。*

**executor-cores**

*参数说明：该参数用于设置每个executor进程的cpu core数量。这个参数决定了每个executor进程并行执行task线程的能力。因为每个cpu core同一时间只能执行一个task线程，因此每个executor进程的cpu core数量越多，越能够快速地执行完全分配给自己的所有task线程。*

*参数调优建议：executor的cpu core数量设置为2-4个较为合适。*

**driver-memory**

*参数说明：该参数用于设置driver进程的内存。*

*参数调优建议：driver的内存通常来说不用设置，或者1G就够了。唯一需要注意的是，如果需要使用collect算子将rdd的数据全部拉取到driver端进行处理，那么必须确保driver的内存足够大，否则会出现oom内存溢出的问题。*

**spark.default.parallelism**

*参数说明：该参数用于设置每个stage的默认task数量。*

*参数调优建议：num-executors * executor-cores的2-3倍*。