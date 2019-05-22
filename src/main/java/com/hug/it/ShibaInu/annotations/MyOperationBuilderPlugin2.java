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
        String summary = "";
        if (list.size() == 0) {
            List<MyApiOperation> myApiOperations = context.findAllAnnotations(MyApiOperation.class);
            if (myApiOperations != null && myApiOperations.size() > 0) {
                summary = myApiOperations.get(0).value();
            } else {
                List<ActivityApiOperation> activityApiOperations = context.findAllAnnotations(ActivityApiOperation.class);
                if (activityApiOperations != null && activityApiOperations.size() > 0) {
                    summary = activityApiOperations.get(0).value();
                }
            }
            context.operationBuilder().summary(summary);//替换默认值
        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

}