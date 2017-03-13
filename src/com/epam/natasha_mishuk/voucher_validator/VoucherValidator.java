package com.epam.natasha_mishuk.voucher_validator;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.Voucher;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class VoucherValidator {
    Logger logger = LogManager.getLogger("VoucherValidator");

    public boolean validateNumberOfVoucherParameters(VoucherType localVoucherType, String[] voucherInitializingOptions) {

        logger.log(Level.INFO, "VoucherValidator.validateNumberOfVoucherParameters-> validates number of parameters for " + localVoucherType.name());

        if (localVoucherType.equals(VoucherType.BASIC) && voucherInitializingOptions.length != 5) {
            logger.log(Level.WARN, "VoucherValidator.validateNumberOfVoucherParameters-> expected number of initial parameters for " + localVoucherType.name() + "is [5] but actual number of received parameters is [" + voucherInitializingOptions.length + "]");
            return false;
        }
        if (localVoucherType.equals(VoucherType.RELAX) && voucherInitializingOptions.length != 6) {
            logger.log(Level.WARN, "VoucherValidator.validateNumberOfVoucherParameters-> expected number of initial parameters for " + localVoucherType.name() + "is [6] but actual number of received parameters is [" + voucherInitializingOptions.length + "]");
            return false;
        }
        if (localVoucherType.equals(VoucherType.SHOPPING) && voucherInitializingOptions.length != 6) {
            logger.log(Level.WARN, "VoucherValidator.validateNumberOfVoucherParameters-> expected number of initial parameters for " + localVoucherType.name() + "is [6] but actual number of received parameters is [" + voucherInitializingOptions.length + "]");
            return false;
        }
        if (localVoucherType.equals(VoucherType.EXCURSION) && voucherInitializingOptions.length != 7) {
            logger.log(Level.WARN, "VoucherValidator.validateNumberOfVoucherParameters-> expected number of initial parameters for " + localVoucherType.name() + "is [7] but actual number of received parameters is [" + voucherInitializingOptions.length + "]");
            return false;
        }
        logger.log(Level.INFO, "VoucherValidator.validateNumberOfVoucherParameters->validateNumberOfVoucherParameters successfully validates number of parameters for " + localVoucherType.name());
        return true;

    }

    public boolean validateValuesOfVoucherParameters(VoucherType localVoucherType, String[] voucherInitializingOptions) {

        logger.log(Level.INFO, "VoucherValidator.validateValuesOfVoucherParameters-> validates if received voucher initial parameters corresponds to expected by type/possible value " + localVoucherType.name());

        try {

            VoucherType.valueOf(voucherInitializingOptions[0]);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial VoucherType parameter is not one of [" + VoucherType.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }

        try {
            CountriesOption.valueOf(voucherInitializingOptions[1]);
        } catch (IllegalArgumentException e) {

            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial CountriesOption parameter is not one of [" + CountriesOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }

        try {
            TransportOption.valueOf(voucherInitializingOptions[2]);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial TransportOption parameter is not one of [" + TransportOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }
        try {
            Integer.parseInt(voucherInitializingOptions[3]);
        } catch (NumberFormatException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial NumberOfDays parameter is not digital integer value [" + voucherInitializingOptions[3] + "] for voucher[" + localVoucherType.name() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }

        try {
            AccommodationOption.valueOf(voucherInitializingOptions[4]);
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial AccommodationOption parameter is not is not one of [" + TransportOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }

        try {
            if (localVoucherType.equals(VoucherType.RELAX)) {
                FoodOption.valueOf(voucherInitializingOptions[5]);
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial FoodOption parameter is not is not one of [" + FoodOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }
        try {
            if (localVoucherType.equals(VoucherType.SHOPPING)) {
                ShoppingOption.valueOf(voucherInitializingOptions[5]);
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial ShoppingOption parameter is not is not one of [" + ShoppingOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }

        try {
            if (localVoucherType.equals(VoucherType.EXCURSION)) {
                ExcursionOption.valueOf(voucherInitializingOptions[5]);

            }


        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial ExcursionOption parameter is not is not one of [" + ExcursionOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }
        try {
            if (localVoucherType.equals(VoucherType.EXCURSION)) {

                InsuranceOption.valueOf(voucherInitializingOptions[6]);
            }


        } catch (IllegalArgumentException e) {
            logger.log(Level.WARN, "VoucherValidator.validateValuesOfVoucherParameters-> initial InsuranceOption parameter is not is not one of [" + InsuranceOption.values() + "] for voucher[" + localVoucherType.name() + "]");
            return false;
        }
        logger.log(Level.INFO, "VoucherValidator.validateValuesOfVoucherParameters->  successfully validates that initial parameters corresponds to expected by type/possible value for " + localVoucherType.name());

        return true;

    }


    public boolean validateInitializingVoucherParameters(VoucherType localVoucherType, String[] voucherInitializingOptions) {
        logger.log(Level.INFO, "VoucherValidator.validateInitializingVoucherParameters-> validates if received number/types/values of voucher initial parameters corresponds to expected for " + localVoucherType.name());

        if (!validateNumberOfVoucherParameters(localVoucherType, voucherInitializingOptions)) {
            logger.log(Level.WARN, "VoucherValidator.validateInitializingVoucherParameters.validateNumberOfVoucherParameters-> fails for voucher[" + localVoucherType.name() + "]");
            return false;
        }


        if (!validateValuesOfVoucherParameters(localVoucherType, voucherInitializingOptions)) {
            logger.log(Level.WARN, "VoucherValidator.validateInitializingVoucherParameters.validateNumberOfVoucherParameters-> fails for voucher[" + localVoucherType.name() + "]");
            return false;

        }


        logger.log(Level.INFO, "VoucherValidator.validateInitializingVoucherParameters-> successfully validates that initial parameters corresponds to expected by number/type/possible value for voucher[" + localVoucherType.name() + "]");


        return true;
    }



}
