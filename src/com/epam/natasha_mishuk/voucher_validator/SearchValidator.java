package com.epam.natasha_mishuk.voucher_validator;

import com.epam.natasha_mishuk.available_option.VoucherType;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_exception.NoSuchVoucherTypeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchValidator {
    Logger logger = LogManager.getLogger("SearchValidator");


     public boolean validateIfSearchParameterAllowedForVoucherType(String searchParam, VoucherType voucherType) throws NoSuchVoucherTypeException {
        logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> called to check if voucher[" + voucherType.name() + "] can be searched by searchParam[" + searchParam + "]");

        switch (voucherType) {

            case BASIC:
                if (searchParam.equals("VoucherType") ||
                        searchParam.equals("VoucherCountry") ||
                        searchParam.equals("VoucherAccommodation") ||
                        searchParam.equals("VoucherTransport")) {
                    logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> voucher[" + voucherType + "] can be searched by searchParam[" + searchParam + "]");
                    return true;
            }
            break;
            case RELAX:
                if (searchParam.equals("VoucherType") ||
                        searchParam.equals("VoucherCountry") ||
                        searchParam.equals("VoucherAccommodation") ||
                        searchParam.equals("VoucherTransport") ||
                        searchParam.equals("VoucherFood")) {
                    logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> voucher[" + voucherType + "] can be searched by searchParam[" + searchParam + "]");
                    return true;
                }
                break;

            case EXCURSION:
                if (searchParam.equals("VoucherType") ||
                        searchParam.equals("VoucherCountry") ||
                        searchParam.equals("VoucherAccommodation") ||
                        searchParam.equals("VoucherTransport") ||
                        searchParam.equals("VoucherExcursionOption")||
                        searchParam.equals("VoucherInsuranceOption")) {
                    logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> voucher[" + voucherType + "] can be searched by searchParam[" + searchParam + "]");
                    return true;

                }
                break;

            case SHOPPING:
                if (searchParam.equals("VoucherType") ||
                        searchParam.equals("VoucherCountry") ||
                        searchParam.equals("VoucherAccommodation") ||
                        searchParam.equals("VoucherTransport") ||
                        searchParam.equals("VoucherShoppingOption")){
                    logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> voucher[" + voucherType + "] can be searched by searchParam[" + searchParam + "]");

                    return true;
                }
                break;
            default:{
                logger.log(Level.WARN, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> throws NoSuchVoucherTypeException as voucher[" + voucherType + "] is not available to  check searchParam[" + searchParam + "]");
                throw new NoSuchVoucherTypeException("No such voucher type["+voucherType+"] to  check searchParam["+searchParam+"]");
            }


        }

        logger.log(Level.INFO, "SearchValidator.validateIfSearchParameterAllowedForVoucherType-> voucher[" + voucherType + "] can NOT be searched by searchParam[" + searchParam + "]");
        return false;
    }
}
