package com.epam.natasha_mishuk.test_util.voucher_comparator;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplExcursionVoucherCalc;
import com.epam.natasha_mishuk.voucher_comparator.ImplExcursionVoucherComparator;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.ExcursionVoucherField;
import com.epam.natasha_mishuk.voucher_exception.ProposalByTypeCreationException;
import com.epam.natasha_mishuk.voucher_exception.ProposalCreationException;
import com.epam.natasha_mishuk.voucher_factory.ProposalCreator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ImplExcursionVoucherComparatorTest {


    private ImplExcursionVoucherComparator excursionVoucherComparator;
    private HashMap<VoucherType, String> initialProposalParams;
    private List<Voucher> actualExcursionVoucherList;
    private List<Voucher> expectedExcursionVoucherList;
    private ProposalCreator proposalCreator;
    private Voucher voucher;
    private ImplExcursionVoucherCalc excursionVoucherCalc;

    @Before
    public void initTestVariables() {
        expectedExcursionVoucherList = new ArrayList<>();
        actualExcursionVoucherList = new ArrayList<>();
        proposalCreator = new ProposalCreator();
        excursionVoucherCalc = new ImplExcursionVoucherCalc();
        initialProposalParams = new HashMap<>();

    }

    @After
    public void clearTestVariables() {
        excursionVoucherComparator = null;
        initialProposalParams = null;
        expectedExcursionVoucherList=null;
        actualExcursionVoucherList = null;
        proposalCreator = null;
        voucher = null;
        excursionVoucherCalc = null;

    }


    @Test
    public void compare_ByExcursion_sortASCE_Test() throws ProposalCreationException, ProposalByTypeCreationException {

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ExcursionOption.EXTREMAL_TOUR,InsuranceOption.EXTREME_SPECIAL);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS,TransportOption.BUS,5,AccommodationOption.HOTEL_ROOM,ExcursionOption.HISTORICAL_TOUR,InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ExcursionOption.NIGHT_LIFE_TOUR,InsuranceOption.EXTENDED);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        excursionVoucherComparator = new ImplExcursionVoucherComparator(ExcursionVoucherField.VOUCHER_EXCURSION_OPTION, true);
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_EXCURSION_CREATE_COMPARATOR_TEST");
        actualExcursionVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualExcursionVoucherList, excursionVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedExcursionVoucherList.size(); i++) {
            if (!expectedExcursionVoucherList.get(i).equals(actualExcursionVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByExcursion_sortDESC_Test() throws ProposalCreationException, ProposalByTypeCreationException {

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ExcursionOption.NIGHT_LIFE_TOUR,InsuranceOption.EXTENDED);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS,TransportOption.BUS,5,AccommodationOption.HOTEL_ROOM,ExcursionOption.HISTORICAL_TOUR,InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ExcursionOption.EXTREMAL_TOUR,InsuranceOption.EXTREME_SPECIAL);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);


        excursionVoucherComparator = new ImplExcursionVoucherComparator(ExcursionVoucherField.VOUCHER_EXCURSION_OPTION, false);
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_EXCURSION_CREATE_COMPARATOR_TEST");
        actualExcursionVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualExcursionVoucherList, excursionVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedExcursionVoucherList.size(); i++) {
            if (!expectedExcursionVoucherList.get(i).equals(actualExcursionVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }



    @Test
    public void compare_ByInsurance_sortASCE_Test() throws ProposalCreationException, ProposalByTypeCreationException {


        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS,TransportOption.BUS,5,AccommodationOption.HOTEL_ROOM,ExcursionOption.HISTORICAL_TOUR,InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ExcursionOption.NIGHT_LIFE_TOUR,InsuranceOption.EXTENDED);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ExcursionOption.EXTREMAL_TOUR,InsuranceOption.EXTREME_SPECIAL);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        excursionVoucherComparator = new ImplExcursionVoucherComparator(ExcursionVoucherField.VOUCHER_EXCURSION_INSURANCE, true);
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_INSURANCE_CREATE_COMPARATOR_TEST");
        actualExcursionVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualExcursionVoucherList, excursionVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedExcursionVoucherList.size(); i++) {
            if (!expectedExcursionVoucherList.get(i).equals(actualExcursionVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByInsurance_sortDESC_Test() throws ProposalCreationException, ProposalByTypeCreationException {

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ExcursionOption.EXTREMAL_TOUR,InsuranceOption.EXTREME_SPECIAL);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ExcursionOption.NIGHT_LIFE_TOUR,InsuranceOption.EXTENDED);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS,TransportOption.BUS,5,AccommodationOption.HOTEL_ROOM,ExcursionOption.HISTORICAL_TOUR,InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedExcursionVoucherList.add(voucher);


        excursionVoucherComparator = new ImplExcursionVoucherComparator(ExcursionVoucherField.VOUCHER_EXCURSION_INSURANCE, false);
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_INSURANCE_CREATE_COMPARATOR_TEST");
        actualExcursionVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualExcursionVoucherList, excursionVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedExcursionVoucherList.size(); i++) {
            if (!expectedExcursionVoucherList.get(i).equals(actualExcursionVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }

}
