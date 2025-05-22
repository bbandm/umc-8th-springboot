package umc.week7.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.week7.validation.validator.StoreExistsValidator;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreExistsValidator.class)
@Documented
public @interface StoreExists {
    String message() default "존재하지 않는 가게입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}