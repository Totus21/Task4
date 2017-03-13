package com.epam.natasha_mishuk.voucher_exception;


public class VoucherListNullException extends VoucherException{

    public VoucherListNullException() {
        super();
    }

    public VoucherListNullException(String message) {
        super(message);

    }

    public VoucherListNullException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherListNullException(Throwable cause){
        super(cause);
    }

}
