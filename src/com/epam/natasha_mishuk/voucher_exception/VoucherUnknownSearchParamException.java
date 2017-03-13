package com.epam.natasha_mishuk.voucher_exception;

public class VoucherUnknownSearchParamException extends VoucherSearchException {

    public VoucherUnknownSearchParamException() {
        super();
    }

    public VoucherUnknownSearchParamException(String message) {
        super(message);

    }

    public VoucherUnknownSearchParamException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherUnknownSearchParamException(Throwable cause){
        super(cause);
    }
}
