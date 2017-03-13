package com.epam.natasha_mishuk.test_util.voucher_comparator;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplShoppingVoucherCalc;
import com.epam.natasha_mishuk.voucher_comparator.ImplRelaxVoucherComparator;
import com.epam.natasha_mishuk.voucher_comparator.ImplShoppingVoucherComparator;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.RelaxVoucherField;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.ShoppingVoucherField;
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

public class ImplShoppingVoucherComparatorTest {

    private ImplShoppingVoucherComparator shoppingVoucherComparator;
    private HashMap<VoucherType, String> initialProposalParams;
    private List<Voucher> actualShoppingVoucherList;
    private List<Voucher> expectedShoppingVoucherList;
    private ProposalCreator proposalCreator;
    private Voucher voucher;
    private ImplShoppingVoucherCalc shoppingVoucherCalc;

    @Before
    public void initTestVariables() {
        expectedShoppingVoucherList = new ArrayList<>();
        actualShoppingVoucherList = new ArrayList<>();
        proposalCreator = new ProposalCreator();
        shoppingVoucherCalc = new ImplShoppingVoucherCalc();
        initialProposalParams = new HashMap<>();

    }

    @After
    public void clearTestVariables() {
        expectedShoppingVoucherList = null;
        initialProposalParams = null;
        actualShoppingVoucherList = null;
        proposalCreator = null;
        voucher = null;
        shoppingVoucherCalc = null;

    }


    @Test
    public void compare_ByShopping_sortASCE_Test() throws ProposalCreationException, ProposalByTypeCreationException {


        voucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedShoppingVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ShoppingOption.SALE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedShoppingVoucherList.add(voucher);

        voucher = new ShoppingVoucher( VoucherType.SHOPPING,CountriesOption.BELARUS,TransportOption.BUS,10,AccommodationOption.SUITE_ROOM,ShoppingOption.SELF_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedShoppingVoucherList.add(voucher);


        shoppingVoucherComparator = new ImplShoppingVoucherComparator(ShoppingVoucherField.VOUCHER_SHOPPING_OPTION, true);
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_SHOPPING_CREATE_COMPARATOR_TEST");
        actualShoppingVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualShoppingVoucherList, shoppingVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedShoppingVoucherList.size(); i++) {
            if (!expectedShoppingVoucherList.get(i).equals(actualShoppingVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }


   @Test
    public void compare_ByShopping_sortDESC_Test() throws ProposalCreationException, ProposalByTypeCreationException {


       voucher = new ShoppingVoucher( VoucherType.SHOPPING,CountriesOption.BELARUS,TransportOption.BUS,10,AccommodationOption.SUITE_ROOM,ShoppingOption.SELF_SHOPPING);
       shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
       expectedShoppingVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.EGYPT,TransportOption.AIRCRAFT,15,AccommodationOption.SUITE_ROOM,ShoppingOption.SALE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedShoppingVoucherList.add(voucher);

       voucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.ITALY,TransportOption.TRAIN,12,AccommodationOption.SUITE_ROOM,ShoppingOption.EXCLUSIVE_SHOPPING);
       shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
       expectedShoppingVoucherList.add(voucher);


       shoppingVoucherComparator = new ImplShoppingVoucherComparator(ShoppingVoucherField.VOUCHER_SHOPPING_OPTION, false);
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_SHOPPING_CREATE_COMPARATOR_TEST");
        actualShoppingVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualShoppingVoucherList, shoppingVoucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedShoppingVoucherList.size(); i++) {
            if (!expectedShoppingVoucherList.get(i).equals(actualShoppingVoucherList.get(i))) {
                result = false;
            }
        }
        Assert.assertTrue(result);

    }
}
