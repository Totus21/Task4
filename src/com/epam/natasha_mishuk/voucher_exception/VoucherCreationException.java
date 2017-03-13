package com.epam.natasha_mishuk.voucher_exception;


public class VoucherCreationException extends VoucherException {

    public VoucherCreationException() {
        super();
    }

    public VoucherCreationException(String message) {
        super(message);

    }

    public VoucherCreationException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherCreationException(Throwable cause){
        super(cause);
    }
}
