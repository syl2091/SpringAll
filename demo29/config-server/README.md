# Spring Cloud Config统一配置管理
config-server 服务端


# 优点
1.集中管理微服务配置，当微服务数量众多的时候，使用这种方式会更为方便；
2.通过Git管理微服务配置，方便追踪配置修改记录；
3.可以在应用运行期间修改配置，微服务能够自动更新配置。

Spring Cloud Config包含了服务端Server和客户端Client。服务端用于从Git仓库中加载配置，并且缓存到本地；客户端用于从服务端获取配置信息
# 加密解密
假如我们Git仓库的密码为mrbird123，要对其加密的话我们可以使用curl命令来获取加密后的密码:
curl -u syl:123456 localhost:12580/encrypt -d syl2091...