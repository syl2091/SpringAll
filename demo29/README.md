# config 配置中心

# bus消息总线
Spring Cloud Bus支持RabbitMQ和Kafka等消息中间件，这里只介绍配合RabbitMQ的使用方式。RabbitMQ的安装与启动可以参考https://mrbird.cc/Spring-Cloud-Hystrix-Dashboard.html中的介绍。

# webhooks
配合WebHooks可以实现自动配置刷新，在配置得到修改的时候它可以代替我们向Config-Server发送刷新请求。以码云为例，添加一个WebHooks：

