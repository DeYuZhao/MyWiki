# SpringBoot框架

## 开发问题：Controller调用Service层的接口，接口返回值无法返回到Controller
使用secureCRT配置本地127.0.0.1端口转发到远端zookeeper的端口，
但是在Spring boot开发中，转发的目标端口同时接入了测试环境的端口，
导致本机调用service方法时，servic返回的结果无法返回到本机，返回到了测试环境，
后来在本机安装zookeeper，删除secureCRT中转发的zookeeper隧道解决问题。

## 整合mybatis框架，dao与xml的映射

## ajax与controller的交互
(1):简单的参数传值：
```
data:{
   "test1": test
}
controller使用@RequestParam
```
(2):简单对象类型:
```
public class User{
   private String name;
   private int age;
   //getters and setters
}
$.ajax({
   url : "someurl",
   type : "POST",
   dataType : "JSON",
   data : {
   'name : 'test',
   'age' : 10
   },
   success : function (data) {
      console.log(data)
   }
})
controller:
public @ResponseBody SomeData objects(@ModelAttribute User user)
```
(3):复杂对象
```
public class User{
   private String name;
   private int age;
   private List<String> contacts;
   //或是 private String[] contacts;
   //getters and setters
}
ajax:
dataType : "JSON",
contentType:"application/json",
controller:
public @ResponseBody SomeData complicateObject(@RequestBody User user)
```







