package com.epam.natasha_mishuk.voucher_exception;


public class VoucherUnknownEnumSearchParamException  extends VoucherSearchException {

    public VoucherUnknownEnumSearchParamException() {
        super();
    }

    public VoucherUnknownEnumSearchParamException(String message) {
        super(message);

    }

    public VoucherUnknownEnumSearchParamException(String message, Throwable cause) {
        super(message,cause);
    }

    public VoucherUnknownEnumSearchParamException(Throwable cause){
        super(cause);
    }
}
