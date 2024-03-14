package com.lsepu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties")
})
public class MyFirstService {

    @Value("my custom prop")
    private String customProp;

    @Value("${test.prop}")
    private String propFromApplication;

    @Value("${my.prop}")
    private String myCustomProp;

    private final TestClass testClass;

    public MyFirstService(
            @Qualifier("firstBean") TestClass testClass) {
        this.testClass = testClass;
    }

    public String sayHello(){
        return "this is".concat(testClass.showHello())
                .concat(customProp)
                .concat(myCustomProp)
                .concat(propFromApplication);
    }

}
