package com.epam.natasha_mishuk.voucher_factory;

import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplExcursionVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplShoppingVoucherCalc;
import com.epam.natasha_mishuk.voucher_exception.NoSuchVoucherTypeException;
import com.epam.natasha_mishuk.voucher_util.FileUtil;
import com.epam.natasha_mishuk.voucher_util.FileParameter;
import com.epam.natasha_mishuk.voucher_validator.VoucherValidator;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.natasha_mishuk.voucher_exception.VoucherCreationException;
import com.epam.natasha_mishuk.voucher_exception.VoucherInitialParamException;

import java.util.*;

public class VoucherCreator {

    Logger logger = LogManager.getLogger("VoucherCreator");

    public String[] generateVoucherInitializingOptions(VoucherType voucherType, String voucherInitialOptions) throws VoucherInitialParamException {
        logger.log(Level.INFO, "VoucherCreator.generateVoucherInitializingOptions-> begins voucher parameters initializing  ");
        VoucherValidator objValidator = new VoucherValidator();
        logger.log(Level.INFO, "VoucherCreator.generateVoucherInitializingOptions-> voucher validator object is created ");
        String[] VoucherOptions = voucherInitialOptions.split(",");
        logger.log(Level.INFO, "VoucherCreator.generateVoucherInitializingOptions->  validates if initial voucher parameters suites requirements");
        if (!objValidator.validateInitializingVoucherParameters(voucherType, VoucherOptions)) {
            logger.log(Level.WARN, "VoucherCreator.generateVoucherInitializingOptions.validateInitializingVoucherParameters->  initial voucher parameters DOESN'T suit requirements. Set VoucherOptions are set in NULL");
            throw new VoucherInitialParamException("VoucherCreator.generateVoucherInitializingOptions trows->VoucherOptions are null");
        }

        logger.log(Level.INFO, "VoucherCreator.generateVoucherInitializingOptions->initial voucher parameters["+voucherInitialOptions+"] are successfully verified"  );
        return VoucherOptions;

    }

    public Voucher generateVoucher(VoucherType voucherType, String voucherInitialOptions) throws VoucherCreationException {

        Voucher voucher = null;
        try {

            logger.log(Level.INFO, "VoucherCreator.generateVoucher calls generateVoucherInitializingOptions-> to initialize voucher[" + voucherType.name() + "] options from parameters:[" + voucherInitialOptions+ "]");
            String[] VoucherOptions = generateVoucherInitializingOptions(voucherType,voucherInitialOptions );
            logger.log(Level.INFO, "VoucherCreator.generateVoucher.generateVoucherInitializingOptions->successfully initialized voucher[" + voucherType.name() + "] options from parameters [" + voucherInitialOptions + "]");

            switch (voucherType) {
                case RELAX:

                    VoucherType relaxVoucherType = VoucherType.valueOf(VoucherOptions[0]);
                    CountriesOption relaxVoucherCountry = CountriesOption.valueOf(VoucherOptions[1]);
                    TransportOption relaxVoucherTransport = TransportOption.valueOf(VoucherOptions[2]);
                    int relaxVoucherDays = Integer.parseInt(VoucherOptions[3]);
                    AccommodationOption relaxVoucherAcc = AccommodationOption.valueOf(VoucherOptions[4]);
                    FoodOption relaxVoucherFood = FoodOption.valueOf(VoucherOptions[5]);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> create object of ImplRelaxVoucherCalc to calc and set voucher[ " + voucherType.name() + "] cost");
                    ImplRelaxVoucherCalc relaxVoucherCalc = new ImplRelaxVoucherCalc();

                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> creates voucher[" + voucherType.name() + "] from initial parameters");
                    voucher = new RelaxVoucher(
                            relaxVoucherType,
                            relaxVoucherCountry,
                            relaxVoucherTransport,
                            relaxVoucherDays,
                            relaxVoucherAcc,
                            relaxVoucherFood);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> call ImplRelaxVoucherCalc.calcVoucherCost to calc and set voucher[ " + voucherType.name() + "] cost");
                    relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher.ImplRelaxVoucherCalc.calcVoucherCost-> voucher[ " + voucherType.name() + "] cost is successfully calculated and set");


                   break;


                case EXCURSION:
                    VoucherType excursionVoucherType = VoucherType.valueOf(VoucherOptions[0]);
                    CountriesOption excursionVoucherCountry = CountriesOption.valueOf(VoucherOptions[1]);
                    TransportOption excursionVoucherTransport = TransportOption.valueOf(VoucherOptions[2]);
                    int excursionVoucherDays = Integer.parseInt(VoucherOptions[3]);
                    AccommodationOption excursionVoucherAcc = AccommodationOption.valueOf(VoucherOptions[4]);
                    ExcursionOption excursionVoucherOption = ExcursionOption.valueOf(VoucherOptions[5]);
                    InsuranceOption excursionVoucherInsurance = InsuranceOption.valueOf(VoucherOptions[6]);

                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> create object of ImplExcursionVoucherCalc to calc and set voucher[ " + voucherType.name() + "] cost");
                    ImplExcursionVoucherCalc excursionVoucherCalc = new ImplExcursionVoucherCalc();

                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> creates voucher[" + voucherType.name() + "] from initial parameters");
                    voucher = new ExcursionVoucher(
                            excursionVoucherType,
                            excursionVoucherCountry,
                            excursionVoucherTransport,
                            excursionVoucherDays,
                            excursionVoucherAcc,
                            excursionVoucherOption,
                            excursionVoucherInsurance);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> call ImplExcursionVoucherCalc.calcVoucherCost to calc and set voucher[ " + voucherType.name() + "] cost");

                    excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher.ImplExcursionVoucherCalc.calcVoucherCost-> voucher[ " + voucherType.name() + "] cost is successfully calculated and set");


                    break;


                case SHOPPING:

                    VoucherType shoppingVoucherType = VoucherType.valueOf(VoucherOptions[0]);
                    CountriesOption shoppingVoucherCountry = CountriesOption.valueOf(VoucherOptions[1]);
                    TransportOption shoppingVoucherTransport = TransportOption.valueOf(VoucherOptions[2]);
                    int shoppingVoucherDays = Integer.parseInt(VoucherOptions[3]);
                    AccommodationOption shoppingVoucherAcc = AccommodationOption.valueOf(VoucherOptions[4]);
                    ShoppingOption shoppingVoucherOption = ShoppingOption.valueOf(VoucherOptions[5]);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> create object of ImplShoppingVoucherCalc to calc and set voucher[ " + voucherType.name() + "] cost");
                    ImplShoppingVoucherCalc shoppingVoucherCalc = new ImplShoppingVoucherCalc();
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> creates voucher[" + voucherType.name() + "] from initial parameters");
                    voucher = new ShoppingVoucher(
                            shoppingVoucherType,
                            shoppingVoucherCountry,
                            shoppingVoucherTransport,
                            shoppingVoucherDays,
                            shoppingVoucherAcc,
                            shoppingVoucherOption);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher-> call ImplShoppingVoucherCalc.calcVoucherCost to calc and set voucher[ " + voucherType.name() + "] cost");

                    shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
                    logger.log(Level.INFO, "VoucherCreator.generateVoucher.ImplExcursionVoucherCalc.calcVoucherCost-> voucher[ " + voucherType.name() + "] cost is successfully calculated and set");


                    break;

                default:
                    throw new NoSuchVoucherTypeException("VoucherCreator.generateVoucher-> NoSuchVoucherTypeException for voucher[" + voucherType.name().toString());

            }

        } catch (NoSuchVoucherTypeException | IllegalArgumentException | IndexOutOfBoundsException | VoucherInitialParamException e) {
            logger.log(Level.WARN, "VoucherCreator.generateVoucher->" + e.getMessage() + e.getCause());
            throw new VoucherCreationException("VoucherCreator.generateVoucher->Voucher [" + voucherType.name() + "] is not created", e);
        }

        return voucher;

    }

}
