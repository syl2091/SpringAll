#dubbo高可用
Dubbo的一些自身特性确保了Dubbo的高可用，比如当注册中心宕机后，服务提供者和服务消费者仍能通过本地缓存通讯；注册中心对等集群，任意一台宕掉后，将自动切换到另一台；当有多台服务提供者提供服务时，Dubbo内置了几种负载均衡算法，并且服务提供者是无状态的，任意一台宕掉后，不影响使用；我们还可以通过整合Hystrix来实现服务降级。


#dubbo直连
```java
@Reference(url = "http://127.0.0.1:8080")
private HelloService helloService;
```
#负载均衡
Dubbo提供了四种负载均衡机制：RandomLoadBalance，LeastActiveLoadBalance，ConsistentHashLoadBalance和
##RandomLoadBalance
RandomLoadBalance是基于权重的负载均衡机制。假如现在有一个由三个服务提供者构成的集群，Server1的权重为100，Server2的权重为200，Server3的权重为300，那么当一个服务消费请求发送过来时，有1/6的几率命中Server1，1/3的记录命中Server2，1/2的记录命中Server3。
##LeastActiveLoadBalance
LeastActiveLoadBalance俗称最小活跃数负载均衡，假如现在有一个由Server1、Server2和Server3三个服务提供者构成的集群，在上一次请求中，Server1的耗时为100ms，Server2的耗时为200ms，Server3的耗时为300ms，那么当一个新的请求到来时，会命中耗时最少的那个服务，即Server1。
##ConsistentHashLoadBalance
详见官方文档介绍：http://dubbo.apache.org/zh-cn/docs/source_code_guide/loadbalance.html。
##RoundRobinLoadBalance
RoundRobinLoadBalance是基于权重的轮询负载均衡机制，即服务请求在轮询的同时还得考虑权重。举个例子：

假如现在有一个由三个服务提供者构成的集群，Server1的权重为100，Server2的权重为200，Server3的权重为300，现在有6个服务消费请求依法发送过来，按照轮询机制，第1个请求命中Server1，第2个请求命中Server2，第3个请求命中Server3，到这里三个服务提供者已经轮询完一次，第4个请求本应该从新开始轮询，命中Server1，但是由于Server1的权重为100（占1/6，即6次只会命中一次），所以第4个请求会被分配到Server2。

接着轮询，第5个请求将命中Server3，第6个请求命中Server2。所以这6个请求命中的顺序为123232，这个概率和服务提供者的权重比相匹配。

##机制选择
默认情况下，Dubbo采用RandomLoadBalance负载均衡机制。我们可以在服务提供者和服务消费者上指定使用哪种负载均衡：
```java
@Reference(loadbalance = RoundRobinLoadBalance.NAME)
private HelloService helloService;
```
在服务端的@Server注解上指定：
```java
@Service(interfaceClass = HelloService.class, loadbalance = RoundRobinLoadBalance.NAME)
```
## 权重分配
```java
@Service(interfaceClass = HelloService.class, weight = 100)
```
