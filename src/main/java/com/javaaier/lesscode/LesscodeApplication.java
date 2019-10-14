package com.javaaier.lesscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author javaaier
 *
 * notes:
 * exclude和excludeName用于关闭指定的自动配置，比如关闭数据源相关的自动配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LesscodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(LesscodeApplication.class, args);
        System.out.println("项目启动成功：" +
                "o                          .oPYo.             8        \n" +
                "8                          8    8             8        \n" +
                "8     .oPYo. .oPYo. .oPYo. 8      .oPYo. .oPYo8 .oPYo. \n" +
                "8     8oooo8 Yb..   Yb..   8      8    8 8    8 8oooo8 \n" +
                "8     8.       'Yb.   'Yb. 8    8 8    8 8    8 8.     \n" +
                "8oooo `Yooo' `YooP' `YooP' `YooP' `YooP' `YooP' `Yooo' \n" +
                "......:.....::.....::.....::.....::.....::.....::.....:\n" +
                ":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                ":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }

}
