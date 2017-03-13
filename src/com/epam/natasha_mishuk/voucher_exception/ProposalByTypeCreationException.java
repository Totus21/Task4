package com.epam.natasha_mishuk.voucher_exception;

public class ProposalByTypeCreationException extends ProposalException{
    public ProposalByTypeCreationException() {
        super();
    }

    public ProposalByTypeCreationException(String message) {
        super(message);

    }

    public ProposalByTypeCreationException(String message, Throwable cause) {
        super(message,cause);
    }

    public ProposalByTypeCreationException(Throwable cause){
        super(cause);
    }

}
