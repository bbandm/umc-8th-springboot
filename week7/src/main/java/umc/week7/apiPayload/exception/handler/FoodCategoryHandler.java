package umc.week7.apiPayload.exception.handler;

import lombok.Getter;
import umc.week7.apiPayload.code.BaseErrorCode;
import umc.week7.apiPayload.exception.GeneralException;

@Getter
public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}