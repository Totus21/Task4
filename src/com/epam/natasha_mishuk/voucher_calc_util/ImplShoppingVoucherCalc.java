package com.epam.natasha_mishuk.voucher_calc_util;


import com.epam.natasha_mishuk.available_option.ShoppingOption;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;


public class ImplShoppingVoucherCalc extends ImplVoucherCalc {
    public void calcVoucherCost(ShoppingVoucher objShoppingVoucher) {
        //rework with validators and exceptions

        super.calcVoucherCost(objShoppingVoucher);
        ShoppingOption shoppingOption = ShoppingOption.valueOf(objShoppingVoucher.getShoppingOption().name());

        objShoppingVoucher.setVoucherCost(objShoppingVoucher.getVoucherCost() +
                shoppingOption.getShoppingOptionCostPerDay(objShoppingVoucher.getVoucherCountry()) * objShoppingVoucher.getVoucherNumberOfDays());
    }
}
