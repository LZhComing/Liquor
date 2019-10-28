package com.liquorcloud.liquor.common.security.annotation;

import com.liquorcloud.liquor.common.security.component.LiquorResourceServerAutoConfiguration;
import com.liquorcloud.liquor.common.security.component.LiquorSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author lengleng
 * @date 2019/03/08
 * <p>
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({LiquorResourceServerAutoConfiguration.class, LiquorSecurityBeanDefinitionRegistrar.class})
public @interface EnableLiquorResourceServer {

}
