package com.example.pattern.conetxt;

import ch.qos.logback.core.spi.ContextAware;
import com.example.pattern.ChainPatternDemoApplication;
import com.example.pattern.handler.AbtractHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ValueChainContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<String, AbtractHandler> handlerMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("applicationContext: {}", applicationContext);
        this.applicationContext = applicationContext;
        setHandlerMap0();
    }

//    public ValueChainContext(){
//        log.info("ValueChainContext init...");
//        setHandlerMap0();
//    }
    public void setHandlerMap0() {
        //获取所有实现了AbtractHandler接口的类
        handlerMap = applicationContext.getBeansOfType(AbtractHandler.class);
        log.info("handlerMap: {}", handlerMap);
        //按照mark排序
        handlerMap.values().stream().sorted((o1, o2) -> o1.getMark() - o2.getMark()).forEach(handler -> {});
    }
    public void handle(Integer value) {
        for (AbtractHandler handler : handlerMap.values()) {
            handler.handle(value);
        }
    }
}
