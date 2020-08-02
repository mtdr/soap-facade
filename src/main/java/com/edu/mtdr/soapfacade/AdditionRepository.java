package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.wsdl.Addition;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdditionRepository {
//    private static final Map<String, Addition> additions = new HashMap<>();
//
//    @PostConstruct
//    public void initData() {
//        Addition addition = new Addition();
//        Addition.Body.Add add = new Addition.Body.Add();
//        add.setIntA("1");
//        add.setIntB("2");
//        Addition.Body body = new Addition.Body();
//        body.setAdd(add);
//        addition.setBody(body);
//        additions.put("1", addition);
//    }
//
//    public Addition findAddition(String name) {
//        Assert.notNull(name, "Id must not be null");
//        return additions.get(name);
//    }
}
