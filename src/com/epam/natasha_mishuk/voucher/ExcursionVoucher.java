package com.epam.natasha_mishuk.voucher;

import com.epam.natasha_mishuk.available_option.*;

@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class ExcursionVoucher extends Voucher {
    private ExcursionOption excursionOption;
    private InsuranceOption excursionInsuranceOption;

    public ExcursionVoucher(VoucherType voucherType,
                            CountriesOption voucherCountry,
                            TransportOption voucherTransport,
                            int voucherNumberOffDays,
                            AccommodationOption voucherAccOption,
                            ExcursionOption excursionOption,
                            InsuranceOption excursionInsuranceOption) {
        super(voucherType, voucherCountry, voucherTransport, voucherNumberOffDays, voucherAccOption);
        this.excursionOption = excursionOption;
        this.excursionInsuranceOption = excursionInsuranceOption;
    }

    public void setExcursionOption(ExcursionOption excursionOption) {
        this.excursionOption = excursionOption;
    }

    public void setExcursionInsuranceOption(InsuranceOption excursionInsuranceOption) {
        this.excursionInsuranceOption = excursionInsuranceOption;
    }

    public ExcursionOption getExcursionOption() {
        return excursionOption;
    }

    public InsuranceOption getExcursionInsuranceOption() {
        return excursionInsuranceOption;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Excursion option : " + excursionOption +
                " | Insurance type : " + excursionInsuranceOption;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;

        }

        ExcursionVoucher tempExcursionVoucher = (ExcursionVoucher) obj;
        if (!excursionOption.name().equals(tempExcursionVoucher.excursionOption.name())) {
            return false;
        }

        if (!excursionInsuranceOption.name().equals(tempExcursionVoucher.excursionInsuranceOption.name())) {
            return false;
        }

        return true;


    }

    public int hashCode()
    {
        return super.hashCode()+excursionOption.hashCode()*31+excursionInsuranceOption.hashCode()*33;
    }
}
