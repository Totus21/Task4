package com.epam.natasha_mishuk.voucher_exception;


public class VoucherSearchException extends Exception {
    public VoucherSearchException() {
        super();
    }

    public VoucherSearchException(String message) {
        super(message);

    }

    public VoucherSearchException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherSearchException(Throwable cause){
        super(cause);
    }
}
