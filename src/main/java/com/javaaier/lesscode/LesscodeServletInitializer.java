package com.javaaier.lesscode;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @BelongsProject: lesscode
 * @BelongsPackage: com.javaaier.lesscode
 * @Author: javaaier
 * @CreateTime: 2019-06-17 15:15
 * @Description: web容器中进行部署
 *
 * notes:
 *  笔记见/notes/SpringBoot/SpringBootServletInitializer.md
 */
public class LesscodeServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(LesscodeApplication.class);
    }
}

