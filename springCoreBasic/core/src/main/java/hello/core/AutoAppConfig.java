package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // Configuration class 는 수동으로 빈에 등록하는 클래스이므로 충돌나기 때문에 제외
        // @Configuration 를 들어가보면 @Component 어노테이션이 붙어있음. 그래서 자동으로 등록되기 때문에 제외
)
public class AutoAppConfig {
}
