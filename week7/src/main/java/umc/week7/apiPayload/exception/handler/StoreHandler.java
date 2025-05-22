package umc.week7.apiPayload.exception.handler;

import umc.week7.apiPayload.code.BaseErrorCode;
import umc.week7.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
