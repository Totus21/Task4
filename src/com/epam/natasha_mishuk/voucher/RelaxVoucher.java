package com.epam.natasha_mishuk.voucher;

import com.epam.natasha_mishuk.available_option.*;


@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class RelaxVoucher extends Voucher {
    private FoodOption relaxFoodOption;


    public RelaxVoucher(VoucherType voucherType,
                        CountriesOption voucherCountry,
                        TransportOption voucherTransport,
                        int voucherNumberOffDays,
                        AccommodationOption voucherAccOption,
                        FoodOption relaxFoodOption) {
        super(voucherType,voucherCountry, voucherTransport, voucherNumberOffDays, voucherAccOption);
        this.relaxFoodOption = relaxFoodOption;

    }


    public void setRelaxFoodOption(FoodOption relaxFoodOption) {
        this.relaxFoodOption = relaxFoodOption;
    }

    public FoodOption getRelaxFoodOption() {
        return relaxFoodOption;
    }

    @Override
    public String toString() {

        return
                super.toString() +
                        " |Food : " + relaxFoodOption;


    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;

        }

        RelaxVoucher tempRelaxVoucher = (RelaxVoucher) obj;
        if (!relaxFoodOption.name().equals(tempRelaxVoucher.relaxFoodOption.name())) {
            return false;
        }

        return true;
    }


    public int hashCode()
    {
        return super.hashCode()+ relaxFoodOption.hashCode()*27;
    }
}
