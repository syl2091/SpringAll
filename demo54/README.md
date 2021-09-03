# 工程简介
Spring batch 监听器


# 延伸阅读

# Spring Batch监听器
+ JobExecutionListener 在Job开始之前(beforeJob)和之后(aflerJob)触发
+ StepExecutionListener  在Step开始之前(beforeStep)和之后(afterStep)触发
+ ChunkListener 在 Chunk 开始之前(beforeChunk),之后(afterChunk)和错误后(afterChunkError)触发
+ ItemReadListener 在 Read 开始之前(beforeRead>,之后(afterRead)和错误后(onReadError)触发
+ ItemProcessListener 	在 Processor 开始之前(beforeProcess),之后(afterProcess)和错误后(onProcessError)触发
+ ItemWriterListener 在 Writer 开始之前(beforeWrite),之后(afterWrite)和错误后(onWriteError)触发

