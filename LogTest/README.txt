项目的日志规范：slf4j+logback
slf4j+logback的使用实例
需要导入的jar包：
logback-access-1.1.7.jar
logback-classic-1.1.7.jar
logback-core-1.1.7.jar
slf4j-api-1.7.21.jar

logback.xml配置：
appender节点
file节点：指出日志文件名称和输出位置
filter节点：按照自定义规则过滤掉不同级别的日志输出
logger节点:日志输出

五种不同日志级别：
Trace:更细粒度的追踪，不建议使用。
Debug:用于记录调试信息，如非关键业务的调用流程与执行步骤。
Info:记录关键执行信息，用于
     1.追踪关键业务流转情况。
	 2.留存证据。
	 3.为有失败风险的调用提供核对用的数据。
Warn：用于记录有潜在风险，但还未产生错误的情况。Warn级别的日志应与监控联动，有dashboard可以追踪数据变化情况，酌情触发报警。
Error：用于记录异常或非异常的执行错误信息。Error级别的日志应与监控联动，有dashboard可以追踪数据变化情况，酌情触发报警。

本实例提供了四个测试类，用于测试四种不同的日志级别的输出，并且合并四个类的日志输出，利用过滤器过滤出需要的日志级别信息。