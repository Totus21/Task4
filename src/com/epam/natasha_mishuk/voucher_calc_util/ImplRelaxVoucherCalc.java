package com.epam.natasha_mishuk.voucher_calc_util;



import com.epam.natasha_mishuk.available_option.FoodOption;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;


public class ImplRelaxVoucherCalc extends ImplVoucherCalc {

    public void calcVoucherCost(RelaxVoucher objRelaxVoucher) {
        //rework with validators and exceptions
        super.calcVoucherCost(objRelaxVoucher);
        FoodOption foodOption = FoodOption.valueOf(objRelaxVoucher.getRelaxFoodOption().name());

        objRelaxVoucher.setVoucherCost(objRelaxVoucher.getVoucherCost() +
                                       foodOption.getFoodOptionCostPerDay(objRelaxVoucher.getVoucherCountry())*objRelaxVoucher.getVoucherNumberOfDays());
    }
}
