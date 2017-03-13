package com.epam.natasha_mishuk.voucher_exception;


public class ProposalCreationException extends ProposalException{

    public ProposalCreationException() {
        super();
    }

    public ProposalCreationException(String message) {
        super(message);

    }

    public ProposalCreationException(String message, Throwable cause) {
        super(message,cause);
    }

    public ProposalCreationException(Throwable cause){
        super(cause);
    }
}
