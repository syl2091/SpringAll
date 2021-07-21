# 工程简介
Shiro Redis  Ehcache Thymeleaf(Shiro标签)


# 延伸阅读


# 问题记录
## shiro redis session  
### redis.clients.jedis.ScanResult.getStringCursor()Ljava/lang/String;
使用redis时 这里的 springboot 依赖的 jedis是 3.* 版本  没有
```java
public String getCursor()
```
这个方法 需要自行在pom文件中引入jedis 2.9.3版本
