package com.epam.natasha_mishuk.voucher_exception;


public class VoucherInitialParamException extends VoucherException{
    public VoucherInitialParamException() {
        super();
    }

    public VoucherInitialParamException(String message) {
        super(message);

    }

    public VoucherInitialParamException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherInitialParamException(Throwable cause){
        super(cause);
    }
}
