
 在guns开源项目看到这样一个类，于是查了下用途：若打包成war包,则需要继承 org.springframework.boot.context.web.SpringBootServletInitializer类,覆盖其config(SpringApplicationBuilder)方法

``` java
 /**
 * Guns Web程序启动类
 *
 * @author fengshuonan
 * @date 2017-05-21 9:43
 */
public class GunsServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GunsApplication.class);
    }
}
```
以下摘自：https://www.cnblogs.com/jiaoyiping/p/4251718.html

需要注意一下几点：

1.jar包中的打包方式根据自己的需要进行修改

2.若打包成war包,则需要继承 org.springframework.boot.context.web.SpringBootServletInitializer类,覆盖其config(SpringApplicationBuilder)方法

3.打包成war的话,如果打包之后的文件中没有web.xml文件的话自己可以加进去一个最简单的web.xml(只有根节点的定义,而没有子元素)，防止因缺乏web.xml文件而部署失败


---------------------
作者：自由乐
来源：CSDN
原文：https://blog.csdn.net/luckyzsion/article/details/81135438
版权声明：本文为博主原创文章，转载请附上博文链接！


