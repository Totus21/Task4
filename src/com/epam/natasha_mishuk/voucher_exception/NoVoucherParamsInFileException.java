package com.epam.natasha_mishuk.voucher_exception;

public class NoVoucherParamsInFileException extends VoucherException {
    public NoVoucherParamsInFileException() {
        super();
    }

    public NoVoucherParamsInFileException(String message) {
        super(message);

    }

    public NoVoucherParamsInFileException(String message, Throwable cause) {
        super(message,cause);
    }

    public NoVoucherParamsInFileException(Throwable cause){
        super(cause);
    }
}
