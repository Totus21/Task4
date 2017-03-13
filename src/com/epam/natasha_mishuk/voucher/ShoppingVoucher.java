package com.epam.natasha_mishuk.voucher;


import com.epam.natasha_mishuk.available_option.*;

@SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
public class ShoppingVoucher extends Voucher {

    private ShoppingOption shoppingOption;

    public ShoppingVoucher(VoucherType voucherType,
                           CountriesOption voucherCountry,
                           TransportOption voucherTransport,
                           int voucherNumberOffDays,
                           AccommodationOption voucherAccOption,
                           ShoppingOption shoppingOption)
    {
        super(voucherType,voucherCountry, voucherTransport,voucherNumberOffDays, voucherAccOption);

        this.shoppingOption=shoppingOption;

    }



    public void setShoppingOption(ShoppingOption shoppingOption) {
        this.shoppingOption = shoppingOption;
    }


    public ShoppingOption getShoppingOption() {
        return shoppingOption;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                " |Shopping option " + shoppingOption;
    }

    public boolean equals(Object obj)
    {
        if (!super.equals(obj))  {
            return false;
        }

        ShoppingVoucher tempShoppingVoucher=(ShoppingVoucher)obj;

        if (!shoppingOption.name().equals(tempShoppingVoucher.shoppingOption.name()))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return super.hashCode()+shoppingOption.hashCode()*29;
    }


}
