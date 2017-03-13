package com.epam.natasha_mishuk.test_util.voucher_comparator;

import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_comparator.ImplRelaxVoucherComparator;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.RelaxVoucherField;
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

public class ImplRelaxVoucherComparatorTest {
    private ImplRelaxVoucherComparator relaxVoucherComparator;
    private HashMap<VoucherType, String> initialProposalParams;
    private List<Voucher> actualRelaxVoucherList;
    private List<Voucher> expectedRelaxVoucherList;
    private ProposalCreator proposalCreator;
    private Voucher voucher;
    private ImplRelaxVoucherCalc relaxVoucherCalc;

    @Before
    public void initTestVariables() {
        expectedRelaxVoucherList = new ArrayList<>();
        actualRelaxVoucherList = new ArrayList<>();
        proposalCreator = new ProposalCreator();
        relaxVoucherCalc = new ImplRelaxVoucherCalc();
        initialProposalParams = new HashMap<>();

    }

    @After
    public void clearTestVariables() {
        relaxVoucherComparator = null;
        initialProposalParams = null;
        actualRelaxVoucherList = null;
        proposalCreator = null;
        voucher = null;
        relaxVoucherCalc = null;

    }


    @Test
    public void compare_ByFood_sortASCE_Test() throws ProposalCreationException, ProposalByTypeCreationException {

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, FoodOption.ALL_INCLUSIVE);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, FoodOption.BED_AND_BREAKFAST);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        relaxVoucherComparator = new ImplRelaxVoucherComparator(RelaxVoucherField.VOUCHER_FOOD_OPTION, true);
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_FOOD_CREATE_COMPARATOR_TEST");
        actualRelaxVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualRelaxVoucherList, relaxVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedRelaxVoucherList.size(); i++) {
            if (!expectedRelaxVoucherList.get(i).equals(actualRelaxVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByFood_sortDESC_Test() throws ProposalCreationException, ProposalByTypeCreationException {

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, FoodOption.BED_AND_BREAKFAST);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, FoodOption.ALL_INCLUSIVE);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedRelaxVoucherList.add(voucher);

        relaxVoucherComparator = new ImplRelaxVoucherComparator(RelaxVoucherField.VOUCHER_FOOD_OPTION, false);
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_FOOD_CREATE_COMPARATOR_TEST");
        actualRelaxVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualRelaxVoucherList, relaxVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedRelaxVoucherList.size(); i++) {
            if (!expectedRelaxVoucherList.get(i).equals(actualRelaxVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }
}

