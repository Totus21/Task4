package com.epam.natasha_mishuk.voucher_calc_util;

import com.epam.natasha_mishuk.available_option.ExcursionOption;
import com.epam.natasha_mishuk.available_option.InsuranceOption;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;


public class ImplExcursionVoucherCalc extends ImplVoucherCalc {
    public void calcVoucherCost(ExcursionVoucher objExcursionVoucher) {
        //rework with validators and exceptions

        super.calcVoucherCost(objExcursionVoucher);
        ExcursionOption excursionOption = ExcursionOption.valueOf(objExcursionVoucher.getExcursionOption().name());
        InsuranceOption insuranceOption=InsuranceOption.valueOf(objExcursionVoucher.getExcursionInsuranceOption().name());

        objExcursionVoucher.setVoucherCost(objExcursionVoucher.getVoucherCost() +
                excursionOption.getExcursionOptionCostPerDay(objExcursionVoucher.getVoucherCountry())*objExcursionVoucher.getVoucherNumberOfDays()+
                insuranceOption.getInsuranceOptionCostPerDay(objExcursionVoucher.getVoucherCountry())*objExcursionVoucher.getVoucherNumberOfDays());
    }
}
