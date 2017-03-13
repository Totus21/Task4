package com.epam.natasha_mishuk.voucher_exception;


public class VoucherWrongSearchParamException extends VoucherSearchException {

    public VoucherWrongSearchParamException() {
        super();
    }

    public VoucherWrongSearchParamException(String message) {
        super(message);

    }

    public VoucherWrongSearchParamException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherWrongSearchParamException(Throwable cause){
        super(cause);
    }
}
