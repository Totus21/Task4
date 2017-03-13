package com.epam.natasha_mishuk.voucher_comparator;

import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.VoucherField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;


public class ImplVoucherComparator implements Comparator<Voucher> {
    Logger logger = LogManager.getLogger("ImplVoucherComparator");
    private VoucherField sortField;
    private boolean sortASCE;

    public ImplVoucherComparator() {
        super();
        sortField = VoucherField.VOUCHER_COUNTRY;
        sortASCE = true;
    }

    public ImplVoucherComparator(VoucherField sortField, boolean sortASCE) {
        this.sortField = sortField;
        this.sortASCE=sortASCE;
    }

    public void setSortField(VoucherField sortField) {
        this.sortField = sortField;
    }

    public VoucherField getSortField() {
        return sortField;
    }

    public void setSortASCE(boolean sortASCE) {
        this.sortASCE = sortASCE;
    }

    public boolean isSortASCE() {
        return sortASCE;
    }

    @Override
    public int compare(Voucher obj1, Voucher obj2) throws EnumConstantNotPresentException {
        logger.log(Level.INFO, "ImplVoucherComparator.compare-> called to compare voucher[" + obj1.toString() + "] with voucher [" + obj2.toString() + "]");

        if(!sortASCE){
            Voucher tempVoucher=obj1;
            obj1 = obj2;
            obj2=tempVoucher;
         logger.log(Level.INFO, "ImplVoucherComparator.compare-> comparing voucher[" + obj1.toString() + "] with voucher [" + obj2.toString() + "] using DESC order");

        }
        switch (sortField) {
            case VOUCHER_TYPE:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TYPE");
                return obj1.getVoucherType().name().compareTo(obj2.getVoucherType().name());
            case VOUCHER_COUNTRY:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COUNTRY");
                return obj1.getVoucherCountry().name().compareTo(obj2.getVoucherCountry().name());
            case VOUCHER_ACCOMMODATION:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_ACCOMMODATION");
                return   obj1.getVoucherAccOption().name().compareTo(obj2.getVoucherAccOption().name());
            case VOUCHER_TRANSPORT:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TRANSPORT");
                return obj1.getVoucherTransport().name().compareTo(obj2.getVoucherTransport().name());
            case VOUCHER_DAYS:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_DAYS");
                return obj1.getVoucherNumberOfDays()-obj2.getVoucherNumberOfDays();
            case VOUCHER_COST:
                logger.log(Level.INFO, "ImplVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COST");
                return (int)(obj1.getVoucherCost()-obj2.getVoucherCost());
            default:
                logger.log(Level.ERROR, "ImplVoucherComparator.compare-> field to compare voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by "+sortField.name()+"as it is not defined in ImplVoucherComparator.compare");
                throw new EnumConstantNotPresentException(VoucherField.class,sortField.name());

        }


    }
}
