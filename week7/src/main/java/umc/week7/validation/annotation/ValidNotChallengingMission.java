package umc.week7.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.week7.validation.validator.NotChallengingMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotChallengingMissionValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNotChallengingMission {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}