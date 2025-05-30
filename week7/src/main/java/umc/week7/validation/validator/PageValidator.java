package umc.week7.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.week7.apiPayload.code.status.ErrorStatus;
import umc.week7.apiPayload.exception.handler.PageHandler;
import umc.week7.validation.annotation.ValidPage;

public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1){
            throw new PageHandler(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        return true;
    }
}
