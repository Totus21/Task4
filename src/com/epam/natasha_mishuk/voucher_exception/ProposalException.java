package com.epam.natasha_mishuk.voucher_exception;

public class ProposalException extends Exception{


        public ProposalException() {
            super();
        }

        public ProposalException(String message) {
            super(message);

        }

        public ProposalException(String message, Throwable cause) {
            super(message,cause);
        }

        public ProposalException(Throwable cause){
            super(cause);
        }
    }


