package com.epam.natasha_mishuk.voucher_comparator;

import com.epam.natasha_mishuk.voucher.ShoppingVoucher;

import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.ShoppingVoucherField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Comparator;


public class ImplShoppingVoucherComparator implements Comparator<Voucher> {
    Logger logger = LogManager.getLogger("ImplShoppingVoucherComparator");

    private ShoppingVoucherField sortShoppingField;
    private boolean sortASCE;

    public ImplShoppingVoucherComparator() {
        super();
        sortShoppingField = ShoppingVoucherField.VOUCHER_COUNTRY;
        sortASCE = true;

    }

    public ImplShoppingVoucherComparator(ShoppingVoucherField sortShoppingField, boolean sortASCE){
        this.sortShoppingField=sortShoppingField;
        this.sortASCE=sortASCE;
    }

    public void setSortShoppingField(ShoppingVoucherField sortShoppingField) {
        this.sortShoppingField = sortShoppingField;
    }

    public ShoppingVoucherField getSortShoppingField() {
        return sortShoppingField;
    }

    public void setSortASCE(boolean sortASCE) {
        this.sortASCE = sortASCE;
    }

    public boolean isSortASCE() {
        return sortASCE;
    }

    public int compare(Voucher obj1, Voucher obj2)
    {
        logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> called to compare voucher[" + obj1.toString() + "] with voucher [" + obj2.toString() + "]");

        if(!sortASCE){
            ShoppingVoucher tempVoucher=(ShoppingVoucher) obj1;
            obj1 = (ShoppingVoucher)obj2;
            obj2=tempVoucher;
        }
        switch (sortShoppingField) {
            case VOUCHER_TYPE:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TYPE");
               return obj1.getVoucherType().name().compareTo(obj2.getVoucherType().name());
            case VOUCHER_COUNTRY:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COUNTRY");
                return obj1.getVoucherCountry().name().compareTo(obj2.getVoucherCountry().name());
            case VOUCHER_ACCOMMODATION:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_ACCOMMODATION");
                return   obj1.getVoucherAccOption().name().compareTo(obj2.getVoucherAccOption().name());
            case VOUCHER_TRANSPORT:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TRANSPORT");
                return obj1.getVoucherTransport().name().compareTo(obj2.getVoucherTransport().name());
            case VOUCHER_DAYS:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_DAYS");
                return obj1.getVoucherNumberOfDays()-obj2.getVoucherNumberOfDays();
            case VOUCHER_COST:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COST");
                return (int)(obj1.getVoucherCost()-obj2.getVoucherCost());
            case VOUCHER_SHOPPING_OPTION:
                logger.log(Level.INFO, "ImplShoppingVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_SHOPPING_OPTION");
                return ((ShoppingVoucher)obj1).getShoppingOption().name().compareTo(((ShoppingVoucher) obj2).getShoppingOption().name());
            default:
                logger.log(Level.ERROR, "ImplShoppingVoucherComparator.compare-> field to compare voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by "+sortShoppingField.name()+"as it is not defined in ImplVoucherComparator.compare");
                throw new EnumConstantNotPresentException(ShoppingVoucherField.class,sortShoppingField.name());


        }
    }
}
