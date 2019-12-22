package cn.edu.nju.movietubeserver.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 *  @author dc
 *  @date 2019/12/20 18:06
 * 参数校验
 */
@Configuration
public class ValidatorConfig
{

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        final MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        // 设置 validator 模式为快速失败返回
        postProcessor.setValidator(this.validatorFailFast());
        return postProcessor;
    }

    @Bean
    public Validator validatorFailFast()
    {
        final ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
            .configure()
            .addProperty("hibernate.validator.fail_fast", "true")
            .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}