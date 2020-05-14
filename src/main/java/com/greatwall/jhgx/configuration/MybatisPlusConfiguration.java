package com.greatwall.jhgx.configuration;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis-plus默认配置, 包括分页插件自动识别， 打印SQL（只有dev和test环境打印）
 * @author TianLei
 * @date 2019/05/04
 */
@Configuration
@MapperScan({"com.greatwall.jhgx.mapper*"})
@EnableTransactionManagement
public class MybatisPlusConfiguration extends DefaultMybatisPlusConfiguration {

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

}
