package umc.week7.apiPayload.exception.handler;

import umc.week7.apiPayload.code.BaseErrorCode;
import umc.week7.apiPayload.exception.GeneralException;

public class PageHandler extends GeneralException {
    public PageHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
