package com.epam.natasha_mishuk.voucher_validator;

import com.epam.natasha_mishuk.voucher.Voucher;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class ProposalValidator {
    Logger logger = LogManager.getLogger("VoucherValidator");

    public boolean validateIfVoucherProposalEmpty(List<Voucher> listVoucher) {
       logger.log(Level.INFO, "ProposalValidator.validateIfVoucherProposalEmpty-> is called");
       int localNullCounter=0;
        if (listVoucher.isEmpty()) {
            logger.log(Level.INFO, "ProposalValidator.validateIfVoucherProposalEmpty-> VoucherProposal is empty");
            return true;
        }

        for (Voucher obj:listVoucher
             ) {
            if(obj==null){
                localNullCounter++;
            }

        }
        if(listVoucher.size()==localNullCounter){
            logger.log(Level.INFO, "ProposalValidator.validateIfVoucherProposalEmpty-> VoucherProposal is empty");
            return true;
        }

        logger.log(Level.WARN, "ProposalValidator.validateIfVoucherProposalEmpty-> VoucherProposal is not empty");
        return false;
    }
}
