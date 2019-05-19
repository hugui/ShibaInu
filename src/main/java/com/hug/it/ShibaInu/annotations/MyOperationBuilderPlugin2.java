package com.hug.it.ShibaInu.annotations;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;

import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE - 10)
public class MyOperationBuilderPlugin2 implements OperationBuilderPlugin {

    @Override
    public void apply(OperationContext context) {
        List<ApiOperation> list = context.findAllAnnotations(ApiOperation.class);
        if (list.size() == 0) {
            List<MyApiOperation> explainList = context.findAllAnnotations(MyApiOperation.class);
            if (explainList.size() > 0) {
                MyApiOperation explain = explainList.get(0);
                context.operationBuilder().summary(explain.value() + ",since:" + explain.since() + ",author:" + explain.author());//替换默认值
            }
        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

}