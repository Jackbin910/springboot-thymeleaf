package com.yangbin1.springbootthymeleaf.demo;

import org.thymeleaf.context.Context;
import org.thymeleaf.messageresolver.StandardMessageResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Properties;

public class ThymeleafEngineDemo {
    public static void main(String[] args) {
        //构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        Properties properties = new Properties();
        properties.setProperty("name_zh_CN","杨斌");
        properties.setProperty("name_en","yangbin1");
        //国际化
        StandardMessageResolver messageResolver = new StandardMessageResolver();
        messageResolver.setDefaultMessages(properties);
        templateEngine.setMessageResolver(messageResolver);
        //创建渲染上下文
        Context context = new Context();
        context.setVariable("message","hello");
        //渲染内容
        String content = "<p th:text=\"#{name}\">222</p>";
        //渲染结果
        String result = templateEngine.process(content, context);
        System.out.println(result);

    }
}
