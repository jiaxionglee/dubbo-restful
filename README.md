### dubbo 泛化调用
##### 一、调用说明：
- 1、入参
下面的所有参数根据dubbo provider调整
- 2、URL是dubbo地址加dubbo端口
````json
{
    "application":"dubbo_provider_appname",
    "interfaceName":"com.xxx.xxx.XXXRemote",
    "version":"1.1",
    "method":"dubbo_method",
    "timeout":150000,
    "url":"dubbo://127.0.0.1:20895",
    "parameterTypes":[],
    "args":[]
}
````
##### 二、查找dubbo地址和端口
- 连接zookeeper
```shell script
# 切换到zookeeper的bin目录下
./zkCli.sh -server zk服务地址:zk服务端口
ls /dubbo_group/com.xxx.xxx.xxxService/providers
# 将结果解码即可得到
```
##### 三、telnet测试dubbo
```shell script
telnet dubbo_provider_ip dubbo_port
# 显示服务详细信息列表
ls -l
# 显示服务的方法详细信息列表
ls -l xxxService
invoke xxxService.method
```