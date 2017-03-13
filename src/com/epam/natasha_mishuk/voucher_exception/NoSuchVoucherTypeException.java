package com.epam.natasha_mishuk.voucher_exception;


public class NoSuchVoucherTypeException extends VoucherException{
    public NoSuchVoucherTypeException() {
        super();
    }

    public NoSuchVoucherTypeException(String message) {
        super(message);

    }

    public NoSuchVoucherTypeException(String message, Throwable cause) {
        super(message,cause);
    }

    public NoSuchVoucherTypeException(Throwable cause){
        super(cause);
    }
}
