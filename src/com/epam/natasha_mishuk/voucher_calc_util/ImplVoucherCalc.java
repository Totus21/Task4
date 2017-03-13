package com.epam.natasha_mishuk.voucher_calc_util;

import com.epam.natasha_mishuk.available_option.AccommodationOption;
import com.epam.natasha_mishuk.available_option.TransportOption;
import com.epam.natasha_mishuk.voucher.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImplVoucherCalc implements ICalcCost {



    public void calcVoucherCost(Voucher objVoucher)
    {

        AccommodationOption accommodationOption=AccommodationOption.valueOf(objVoucher.getVoucherAccOption().name());
        TransportOption transportOption=TransportOption.valueOf(objVoucher.getVoucherTransport().name());

        objVoucher.setVoucherCost(accommodationOption.getAccommodationOptionCostPerDay(objVoucher.getVoucherCountry())*objVoucher.getVoucherNumberOfDays()+
                                  transportOption.getTransportOptionCostPerCountry(objVoucher.getVoucherCountry())*objVoucher.getVoucherNumberOfDays());
    }
}
