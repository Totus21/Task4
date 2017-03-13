package com.epam.natasha_mishuk.test_util.voucher_factory;

import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplExcursionVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplShoppingVoucherCalc;
import com.epam.natasha_mishuk.voucher_exception.ProposalByTypeCreationException;
import com.epam.natasha_mishuk.voucher_exception.ProposalCreationException;
import com.epam.natasha_mishuk.voucher_factory.ProposalCreator;
import org.junit.*;

import java.util.*;

public class ProposalCreatorTest {
    private ProposalCreator proposalCreator;
    private List<Voucher> expectedRelaxProposal;
    private List<Voucher> actualRelaxProposal;
    private ImplRelaxVoucherCalc objRelaxVoucherCalc;
    private RelaxVoucher objExpectedRelaxVoucher = null;
    private List<Voucher> expectedExcursionProposal;
    private List<Voucher> actualExcursionProposal;
    private ImplExcursionVoucherCalc objExcursionVoucherCalc;
    private ExcursionVoucher objExcursionVoucher;
    private List<Voucher> expectedShoppingProposal;
    private List<Voucher> actualShoppingProposal;
    private ImplShoppingVoucherCalc objShoppingVoucherCalc;
    private ShoppingVoucher objShoppingVoucher;
    private List<Voucher> expectedFinalProposal;
    private List<Voucher> actualFinalProposal;
    private HashMap<VoucherType, String> initialProposalParams;

    @Before
    public void initTestVariable() {
        proposalCreator = new ProposalCreator();

    }

    @After
    public void clearTestVariable() {
        proposalCreator = null;
        expectedRelaxProposal = null;
        objRelaxVoucherCalc =null;
        objExpectedRelaxVoucher = null;
        expectedExcursionProposal=null;
        actualExcursionProposal=null;
        objExcursionVoucherCalc=null;
        objExcursionVoucher=null;
        expectedShoppingProposal=null;
        actualShoppingProposal=null;
        objShoppingVoucherCalc=null;
        objShoppingVoucher=null;
        actualFinalProposal=null;
        initialProposalParams=null;
        expectedFinalProposal=null;
    }

    @Test
    public void generateProposalByType_RelaxTest() throws ProposalByTypeCreationException {

        expectedRelaxProposal = new ArrayList<>();
        objRelaxVoucherCalc = new ImplRelaxVoucherCalc();
        objExpectedRelaxVoucher = null;

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, FoodOption.BED_AND_BREAKFAST);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, FoodOption.ALL_INCLUSIVE);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        actualRelaxProposal = proposalCreator.generateProposalByType(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");

        Assert.assertTrue(expectedRelaxProposal.size() == actualRelaxProposal.size() && expectedRelaxProposal.containsAll(actualRelaxProposal));

    }


    @Test
    public void generateProposalByType_ExcursionTest() throws ProposalByTypeCreationException {
        expectedExcursionProposal = new ArrayList<>();
        objExcursionVoucherCalc = new ImplExcursionVoucherCalc();
        objExcursionVoucher = null;

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, ExcursionOption.NIGHT_LIFE_TOUR, InsuranceOption.EXTENDED);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.SUITE_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        actualExcursionProposal = proposalCreator.generateProposalByType(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");

        Assert.assertTrue(expectedExcursionProposal.size() == actualExcursionProposal.size() && expectedExcursionProposal.containsAll(actualExcursionProposal));

    }

    @Test
    public void generateProposalByType_ShoppingTest() throws ProposalByTypeCreationException {
       expectedShoppingProposal = new ArrayList<>();
       objShoppingVoucherCalc = new ImplShoppingVoucherCalc();
       objShoppingVoucher = null;

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, ShoppingOption.SELF_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, ShoppingOption.SELF_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        actualShoppingProposal = proposalCreator.generateProposalByType(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");

        Assert.assertTrue(expectedShoppingProposal.size() == actualShoppingProposal.size() && expectedShoppingProposal.containsAll(actualShoppingProposal));

    }

    @Test(expected = ProposalByTypeCreationException.class)
    public void generateProposalRelax_ProposalByTypeCreationExceptionTest() throws ProposalByTypeCreationException {


        proposalCreator.generateProposalByType(VoucherType.RELAX, "RELAX_EMPTY");


    }

    @Test(expected = ProposalByTypeCreationException.class)
    public void generateProposalExcursion_ProposalByTypeCreationExceptionTest() throws ProposalByTypeCreationException {


        proposalCreator.generateProposalByType(VoucherType.EXCURSION, "EXCURSION_EMPTY");


    }

    @Test(expected = ProposalByTypeCreationException.class)
    public void generateProposalShopping_ProposalByTypeCreationExceptionTest() throws ProposalByTypeCreationException {


        proposalCreator.generateProposalByType(VoucherType.SHOPPING, "SHOPPING_EMPTY");


    }

    @Test(expected = ProposalCreationException.class)
    public void generateProposalAllTypes_ProposalCreationExceptionTest() throws ProposalCreationException {

        initialProposalParams = new HashMap<>();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_EMPTY");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_EMPTY");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_EMPTY");
        proposalCreator.generateProposalAllTypes(initialProposalParams);

    }

    @Test
    public void generateProposalAllTypesTest() throws ProposalByTypeCreationException, ProposalCreationException {
        //create Relax proposals
        expectedRelaxProposal = new ArrayList<>();
        objRelaxVoucherCalc = new ImplRelaxVoucherCalc();
        objExpectedRelaxVoucher = null;

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, FoodOption.BED_AND_BREAKFAST);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, FoodOption.HALF_BOARD);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        objExpectedRelaxVoucher = new RelaxVoucher(VoucherType.RELAX, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, FoodOption.ALL_INCLUSIVE);
        objRelaxVoucherCalc.calcVoucherCost(objExpectedRelaxVoucher);
        expectedRelaxProposal.add(objExpectedRelaxVoucher);

        //create Excursion proposals
        expectedExcursionProposal = new ArrayList<>();
        objExcursionVoucherCalc = new ImplExcursionVoucherCalc();
        objExcursionVoucher = null;

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.HOTEL_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, ExcursionOption.NIGHT_LIFE_TOUR, InsuranceOption.EXTENDED);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.SUITE_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        objExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        objExcursionVoucherCalc.calcVoucherCost(objExcursionVoucher);
        expectedExcursionProposal.add(objExcursionVoucher);

        //create Shopping proposals
        expectedShoppingProposal = new ArrayList<>();
        objShoppingVoucherCalc = new ImplShoppingVoucherCalc();
        objShoppingVoucher = null;

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.BELARUS, TransportOption.BUS, 10, AccommodationOption.SUITE_ROOM, ShoppingOption.SELF_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.ITALY, TransportOption.TRAIN, 12, AccommodationOption.SUITE_ROOM, ShoppingOption.EXCLUSIVE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.EGYPT, TransportOption.AIRCRAFT, 15, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.TURKEY, TransportOption.AIRCRAFT, 10, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);

        objShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.RUSSIA, TransportOption.TRAIN, 4, AccommodationOption.HOSTEL_ROOM, ShoppingOption.SELF_SHOPPING);
        objShoppingVoucherCalc.calcVoucherCost(objShoppingVoucher);
        expectedShoppingProposal.add(objShoppingVoucher);
        //create expectedFinalProposal
        expectedFinalProposal=new ArrayList<>();
        expectedFinalProposal.addAll(expectedRelaxProposal);
        expectedFinalProposal.addAll(expectedShoppingProposal);
        expectedFinalProposal.addAll(expectedExcursionProposal);

        //create actualFinalProposal
        initialProposalParams = new HashMap<>();
        actualFinalProposal=new ArrayList<>();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualFinalProposal=proposalCreator.generateProposalAllTypes(initialProposalParams);

        Assert.assertTrue(expectedFinalProposal.size() == actualFinalProposal.size() && expectedFinalProposal.containsAll(actualFinalProposal));






    }


}
