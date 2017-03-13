package com.epam.natasha_mishuk.voucher_exception;


public class VoucherException extends Exception {

    public VoucherException() {
        super();
    }

    public VoucherException(String message) {
        super(message);

    }

    public VoucherException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherException(Throwable cause){
        super(cause);
    }
}
