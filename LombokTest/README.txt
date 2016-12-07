lombok使用实例：

需要导入的jar包：lombok.jar
在类中加入注解即可

本实例有一个简单的javabean Person，包含三个成员变量 name,sex,address
使用@Data注解直接生成无参构造，GetSet方法，hashcode，toString，equals等方法。
测试类无参构造实例，设值并将值读出。

lombok主要作用就是简化javabean文件的编写，消除臃肿的代码，缺点在于javabean阅读起来不友好。