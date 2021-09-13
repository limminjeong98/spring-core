package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 지정하지 않아도 현재 폴더(hello.core) 하위로 componentscan 된다.
//        basePackageClasses =
//        basePackages = "hello.core.member", 이렇게 하면 order랑 discount는 componentscan이 안된다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// AppConfig 파일과 충돌나지 않게 하려고

public class AutoAppConfig {
}
