package com.epam.natasha_mishuk.voucher;

import com.epam.natasha_mishuk.available_option.AccommodationOption;
import com.epam.natasha_mishuk.available_option.CountriesOption;
import com.epam.natasha_mishuk.available_option.TransportOption;
import com.epam.natasha_mishuk.available_option.VoucherType;

public class Voucher {

    private CountriesOption voucherCountry;
    private TransportOption voucherTransport;
    private AccommodationOption voucherAccOption;
    private int voucherNumberOfDays;
    private double voucherCost;
    private VoucherType voucherType;


    public Voucher(VoucherType voucherType,
                   CountriesOption voucherCountry,
                   TransportOption voucherTransport,
                   int voucherNumberOfDays,
                   AccommodationOption voucherAccOption) {
        this.voucherType = voucherType;
        this.voucherCountry = voucherCountry;
        this.voucherTransport = voucherTransport;
        this.voucherNumberOfDays = voucherNumberOfDays;
        this.voucherAccOption = voucherAccOption;

    }

    public void setVoucherCountry(CountriesOption voucherCountry) {
        this.voucherCountry = voucherCountry;
    }

    public void setVoucherTransport(TransportOption voucherTransport) {
        this.voucherTransport = voucherTransport;
    }


    public void setVoucherNumberOfDays(int voucherNumberOfDays) {
        this.voucherNumberOfDays = voucherNumberOfDays;
    }

    public void setVoucherAccOption(AccommodationOption voucherAccOption) {
        this.voucherAccOption = voucherAccOption;
    }

    public void setVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherCost(double voucherCost) {
        this.voucherCost = voucherCost;
    }

    public CountriesOption getVoucherCountry() {
        return voucherCountry;
    }

    public TransportOption getVoucherTransport() {
        return voucherTransport;
    }

    public int getVoucherNumberOfDays() {
        return voucherNumberOfDays;
    }


    public AccommodationOption getVoucherAccOption() {
        return voucherAccOption;
    }

    public double getVoucherCost() {
        return voucherCost;
    }


    public String toString() {
        return super.toString() +
                "|Voucher Type :" +voucherType+
                " |Country : " + voucherCountry +
                " |Number of Days  " + voucherNumberOfDays +
                " |Transport : " + voucherTransport +
                " |Accommodation : " + getVoucherAccOption()+
                " |Cost :" + getVoucherCost();



    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        Voucher tempVoucher = (Voucher) obj;

        if (!voucherType.name().equals(tempVoucher.voucherType.name())) {
            return false;
        }

        if (!voucherCountry.name().equals(tempVoucher.voucherCountry.name())) {
            return false;
        }

        if (!voucherTransport.name().equals(tempVoucher.voucherTransport.name())) {
            return false;
        }

        if (!voucherAccOption.name().equals(tempVoucher.voucherAccOption.name())) {
            return false;
        }

        if (voucherNumberOfDays != tempVoucher.voucherNumberOfDays) {
            return false;
        }

        if (voucherCost != tempVoucher.voucherCost) {
            return false;
        }

        return true;
    }

    public int hashCode() {

     return voucherType.hashCode()+voucherCountry.hashCode()*3+voucherTransport.hashCode()*7+voucherAccOption.hashCode()*9+(voucherNumberOfDays+13)*17+((int)voucherCost+19)*23;
    }
}

