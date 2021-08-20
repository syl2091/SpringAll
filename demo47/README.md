# 工程简介
Spring Security自定义用户认证  验证码登录  记住我功能 session管理 自定义退出登录 权限控制


# session集群处理
当我们登录成功后，用户认证的信息存储在Session中，
而这些Session默认是存储在运行运用的服务器上的，比如Tomcat，netty等。
当应用集群部署的时候，用户在A应用上登录认证了，后续通过负载均衡可能会把请求发送到B应用，
而B应用服务器上并没有与该请求匹配的认证Session信息，所以用户就需要重新进行认证。
要解决这个问题，我们可以把Session信息存储在第三方容器里（如Redis集群），
而不是各自的服务器，这样应用集群就可以通过第三方容器来共享Session了。

# 退出登录
Spring Security默认的退出登录URL为/logout，退出登录后，Spring Security会做如下处理：
1.是当前的Sesion失效；
2.清除与当前用户关联的RememberMe记录；
3.清空当前的SecurityContext；
4.重定向到登录页。