package com.epam.natasha_mishuk.voucher_comparator;


import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.ExcursionVoucherField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ImplExcursionVoucherComparator implements Comparator<Voucher>{
    Logger logger = LogManager.getLogger("ImplExcursionVoucherComparator");
    private ExcursionVoucherField sortExcursionField;
    private boolean sortASCE;

    public ImplExcursionVoucherComparator() {
        super();
        sortExcursionField = ExcursionVoucherField.VOUCHER_COUNTRY;
        sortASCE = true;

    }

    public ImplExcursionVoucherComparator(ExcursionVoucherField sortExcursionField, boolean sortASCE){
        this.sortExcursionField=sortExcursionField;
        this.sortASCE=sortASCE;
    }

    public void setSortExcursionField(ExcursionVoucherField sortExcursionField) {
        this.sortExcursionField = sortExcursionField;
    }

    public void setSortASCE(boolean sortASCE) {
        this.sortASCE = sortASCE;
    }

    public ExcursionVoucherField getSortExcursionField() {
        return sortExcursionField;
    }

    public boolean isSortASCE() {
        return sortASCE;
    }

    public int compare(Voucher obj1, Voucher obj2)
    {
        logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> called to compare voucher[" + obj1.toString() + "] with voucher [" + obj2.toString() + "]");

        if(!sortASCE){
            ExcursionVoucher tempVoucher=(ExcursionVoucher) obj1;
            obj1 = (ExcursionVoucher)obj2;
            obj2=tempVoucher;
        }
        switch (sortExcursionField) {
            case VOUCHER_TYPE:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TYPE");
                return obj1.getVoucherType().name().compareTo(obj2.getVoucherType().name());
            case VOUCHER_COUNTRY:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COUNTRY");
                return obj1.getVoucherCountry().name().compareTo(obj2.getVoucherCountry().name());
            case VOUCHER_ACCOMMODATION:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_ACCOMMODATION");
                return   obj1.getVoucherAccOption().name().compareTo(obj2.getVoucherAccOption().name());
            case VOUCHER_TRANSPORT:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TRANSPORT");
                return obj1.getVoucherTransport().name().compareTo(obj2.getVoucherTransport().name());
            case VOUCHER_DAYS:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_DAYS");
                return obj1.getVoucherNumberOfDays()-obj2.getVoucherNumberOfDays();
            case VOUCHER_COST:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COST");
                return (int)(obj1.getVoucherCost()-obj2.getVoucherCost());
            case VOUCHER_EXCURSION_OPTION:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_EXCURSION_OPTION");
                return ((ExcursionVoucher)obj1).getExcursionOption().name().compareTo(((ExcursionVoucher)obj2).getExcursionOption().name());
            case VOUCHER_EXCURSION_INSURANCE:
                logger.log(Level.INFO, "ImplExcursionVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_EXCURSION_INSURANCE");
                return ((ExcursionVoucher)obj1).getExcursionInsuranceOption().name().compareTo(((ExcursionVoucher)obj2).getExcursionInsuranceOption().name());
            default:
                logger.log(Level.ERROR, "ImplExcursionVoucherComparator.compare-> field to compare voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by "+sortExcursionField.name()+"as it is not defined in ImplVoucherComparator.compare");
                throw new EnumConstantNotPresentException(ExcursionVoucherField.class,sortExcursionField.name());

        }
    }

}
