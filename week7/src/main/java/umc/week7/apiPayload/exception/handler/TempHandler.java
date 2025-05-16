package umc.week7.apiPayload.exception.handler;

import umc.week7.apiPayload.code.BaseErrorCode;
import umc.week7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
