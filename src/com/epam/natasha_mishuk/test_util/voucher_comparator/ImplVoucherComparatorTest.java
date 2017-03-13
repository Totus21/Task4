package com.epam.natasha_mishuk.test_util.voucher_comparator;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplExcursionVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplShoppingVoucherCalc;
import com.epam.natasha_mishuk.voucher_comparator.ImplVoucherComparator;
import com.epam.natasha_mishuk.voucher_comparator.comparator_option.VoucherField;
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

public class ImplVoucherComparatorTest {
    private ImplVoucherComparator voucherComparator;
    private HashMap<VoucherType, String> initialProposalParams;
    private List<Voucher> actualVoucherList;
    private List<Voucher> expectedVoucherList;
    private ProposalCreator proposalCreator;
    private Voucher voucher;
    private ImplExcursionVoucherCalc excursionVoucherCalc;
    private ImplRelaxVoucherCalc relaxVoucherCalc;
    private ImplShoppingVoucherCalc shoppingVoucherCalc;

    @Before
    public void initTestVariables() {
        expectedVoucherList = new ArrayList<>();
        actualVoucherList = new ArrayList<>();
        proposalCreator = new ProposalCreator();
        excursionVoucherCalc = new ImplExcursionVoucherCalc();
        relaxVoucherCalc = new ImplRelaxVoucherCalc();
        shoppingVoucherCalc = new ImplShoppingVoucherCalc();
        initialProposalParams=new HashMap<>();

    }

    @After
    public void clearTestVariables() {
        voucherComparator = null;
        initialProposalParams = null;
        actualVoucherList = null;
        proposalCreator = null;
        voucher = null;
        excursionVoucherCalc = null;
        relaxVoucherCalc = null;
        shoppingVoucherCalc = null;
    }

    @Test
    public void compare_ByVoucherType_sortASCE_Test() throws ProposalCreationException {


        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);


        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_TYPE, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }



    @Test
    public void compare_ByVoucherType_sortDESC_Test() throws ProposalCreationException {

        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);


        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_TYPE, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }
    @Test
    public void compare_ByCountry_sortDESC_Test() throws ProposalCreationException {


        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);


        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);



        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_COUNTRY, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByCountry_sortASCE_Test() throws ProposalCreationException {

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);



        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);





        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_COUNTRY, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }



    @Test
    public void compare_ByTransport_sortASCE_Test() throws ProposalCreationException {


        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);


        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);





        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_TRANSPORT, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }

    @Test
    public void compare_ByTransport_sortDESC_Test() throws ProposalCreationException {




        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_TRANSPORT, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }


       @Test
    public void compare_ByAccommodation_sortDESC_Test() throws ProposalCreationException {




        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);





        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_ACCOMMODATION, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }

        Assert.assertTrue(result);

    }



    @Test
    public void compare_ByAccommodation_sortASCE_Test() throws ProposalCreationException {


        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_ACCOMMODATION, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }


        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByCost_sortASCE_Test() throws ProposalCreationException {


        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);




        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_COST, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }


        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByCost_sortDESC_Test() throws ProposalCreationException {


        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_COST, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;


        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }


        Assert.assertTrue(result);

    }

    @Test
    public void compare_ByDays_sortDESC_Test() throws ProposalCreationException {

       voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);
        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_DAYS, false);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (Voucher obj:expectedVoucherList
             ) {
            System.out.println(obj.toString());

        }

        for (Voucher obj:actualVoucherList
                ) {
            System.out.println(obj.toString());

        }
        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }


        Assert.assertTrue(result);

    }


    @Test
    public void compare_ByDays_sortASCE_Test() throws ProposalCreationException {



        voucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        excursionVoucherCalc.calcVoucherCost((ExcursionVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        relaxVoucherCalc.calcVoucherCost((RelaxVoucher) voucher);
        expectedVoucherList.add(voucher);

        voucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.HOSTEL_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        shoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) voucher);
        expectedVoucherList.add(voucher);
        voucherComparator = new ImplVoucherComparator(VoucherField.VOUCHER_DAYS, true);

        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_COMPARATOR_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_COMPARATOR_TEST");
        actualVoucherList = proposalCreator.generateProposalAllTypes(initialProposalParams);
        Collections.sort(actualVoucherList, voucherComparator);
        boolean result = true;

        for (Voucher obj:expectedVoucherList
                ) {
            System.out.println(obj.toString());

        }

        for (Voucher obj:actualVoucherList
                ) {
            System.out.println(obj.toString());

        }
        for (int i = 0; i < expectedVoucherList.size(); i++) {
            if (!expectedVoucherList.get(i).equals(actualVoucherList.get(i))) {
                result = false;
            }
        }


        Assert.assertTrue(result);

    }

}
