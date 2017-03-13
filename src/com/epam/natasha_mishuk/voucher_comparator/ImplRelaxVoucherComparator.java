package com.epam.natasha_mishuk.voucher_comparator;


import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.RelaxVoucherField;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.VoucherField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class ImplRelaxVoucherComparator implements Comparator <Voucher> {
    Logger logger = LogManager.getLogger("ImplRelaxVoucherComparator");

    private RelaxVoucherField sortRelaxField;
    private boolean sortASCE;

    public ImplRelaxVoucherComparator() {
        sortRelaxField = RelaxVoucherField.VOUCHER_COUNTRY;
        sortASCE = true;

    }

    public ImplRelaxVoucherComparator( RelaxVoucherField sortRelaxField, boolean sortASCE){
        this.sortRelaxField=sortRelaxField;
        this.sortASCE=sortASCE;
    }


    public boolean isSortASCE() {
        return sortASCE;
    }

    public RelaxVoucherField getSortRelaxField() {

        return sortRelaxField;
    }

    public void setSortASCE(boolean sortASCE) {

        this.sortASCE = sortASCE;
    }

    public void setSortRelaxField(RelaxVoucherField sortRelaxField) {

        this.sortRelaxField = sortRelaxField;
    }

    public int compare(Voucher obj1,Voucher obj2)
    {
        logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> called to compare voucher[" + obj1.toString() + "] with voucher [" + obj2.toString() + "]");

        if(!sortASCE){
            RelaxVoucher tempVoucher=(RelaxVoucher) obj1;
            obj1 = (RelaxVoucher)obj2;
            obj2=tempVoucher;
        }
        switch (sortRelaxField) {
            case VOUCHER_TYPE:
               logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TYPE");
               return (obj1).getVoucherType().name().compareTo((obj2).getVoucherType().name());
            case VOUCHER_COUNTRY:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COUNTRY");
                return (obj1).getVoucherCountry().name().compareTo((obj2).getVoucherCountry().name());
            case VOUCHER_ACCOMMODATION:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_ACCOMMODATION");
                return   (obj1).getVoucherAccOption().name().compareTo(obj2.getVoucherAccOption().name());
            case VOUCHER_TRANSPORT:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_TRANSPORT");
                return obj1.getVoucherTransport().name().compareTo(obj2.getVoucherTransport().name());
            case VOUCHER_DAYS:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_DAYS");
                return obj1.getVoucherNumberOfDays()-obj2.getVoucherNumberOfDays();
            case VOUCHER_COST:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_COST");
                return (int)(obj1.getVoucherCost()-obj2.getVoucherCost());
            case VOUCHER_FOOD_OPTION:
                logger.log(Level.INFO, "ImplRelaxVoucherComparator.compare-> voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by VOUCHER_FOOD_OPTION");
                return ((RelaxVoucher)obj1).getRelaxFoodOption().name().compareTo(((RelaxVoucher)obj2).getRelaxFoodOption().name());
            default:
                logger.log(Level.ERROR, "ImplRelaxVoucherComparator.compare-> field to compare voucher[" + obj1.toString() + "] is comparing with voucher [" + obj2.toString() + "] using DESC order by "+sortRelaxField.name()+"as it is not defined in ImplVoucherComparator.compare");
                throw new EnumConstantNotPresentException(RelaxVoucherField.class,sortRelaxField.name());


        }
    }
}
