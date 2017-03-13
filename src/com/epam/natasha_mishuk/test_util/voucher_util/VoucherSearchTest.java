package com.epam.natasha_mishuk.test_util.voucher_util;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_exception.*;
import com.epam.natasha_mishuk.voucher_factory.ProposalCreator;
import com.epam.natasha_mishuk.voucher_util.VoucherSearch;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VoucherSearchTest {
    private enum failedTestSearchParams {TEST1, TEST2}

    ;
    private VoucherSearch voucherSearch;
    private String expectedSearchParam;
    private String actualSearchParam;
    private List<Voucher> expectedSearchResult;
    private List<Voucher> emptyInitialsearchList;
    private List<Voucher> actualSearchResult;
    private ProposalCreator proposalCreator;
    private HashMap<VoucherType, String> initialProposalParams;

    @Before
    public void initTestVariables() {
        voucherSearch = new VoucherSearch();
        proposalCreator = new ProposalCreator();
        expectedSearchResult = new ArrayList<>();
        actualSearchResult = new ArrayList<>();
        initialProposalParams = new HashMap<>();
        emptyInitialsearchList = new ArrayList<>();

    }

    @After
    public void clearTestVariables() {
        voucherSearch = null;
        expectedSearchParam = null;
        actualSearchParam = null;
        proposalCreator = null;
        initialProposalParams = null;
        emptyInitialsearchList = null;
    }

    @Test(expected = VoucherUnknownEnumSearchParamException.class)
    public void defineEnumSearchParam_VoucherUnknownEnumSearchParamExceptionTest() throws VoucherUnknownEnumSearchParamException {
        voucherSearch.defineEnumSearchParam(failedTestSearchParams.TEST1);
    }

    @Test
    public void defineEnumSearchParam_VoucherTypeTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherType";
        actualSearchParam = voucherSearch.defineEnumSearchParam(VoucherType.RELAX);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }

    @Test
    public void defineEnumSearchParam_VoucherCountryTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherCountry";
        actualSearchParam = voucherSearch.defineEnumSearchParam(CountriesOption.ITALY);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void defineEnumSearchParam_VoucherAccommodationTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherAccommodation";
        actualSearchParam = voucherSearch.defineEnumSearchParam(AccommodationOption.HOSTEL_ROOM);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void defineEnumSearchParam_VoucherTransportTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherTransport";
        actualSearchParam = voucherSearch.defineEnumSearchParam(TransportOption.AIRCRAFT);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }

    @Test
    public void defineEnumSearchParam_VoucherFoodTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherFood";
        actualSearchParam = voucherSearch.defineEnumSearchParam(FoodOption.ALL_INCLUSIVE);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void defineEnumSearchParam_VoucherShoppingOptionTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherShoppingOption";
        actualSearchParam = voucherSearch.defineEnumSearchParam(ShoppingOption.EXCLUSIVE_SHOPPING);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void defineEnumSearchParam_VoucherExcursionOptionTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherExcursionOption";
        actualSearchParam = voucherSearch.defineEnumSearchParam(ExcursionOption.EXTREMAL_TOUR);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void defineEnumSearchParam_VoucherInsuranceOptionTest() throws VoucherUnknownEnumSearchParamException {
        expectedSearchParam = "VoucherInsuranceOption";
        actualSearchParam = voucherSearch.defineEnumSearchParam(InsuranceOption.EXTENDED);

        Assert.assertEquals("Test fails  as expectedSearchParam is" + expectedSearchParam + "but actualSearchParam is" + actualSearchParam, expectedSearchParam, actualSearchParam);

    }


    @Test
    public void searchByOneEnumField_ByVoucherType_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "SEARCH_RESULT_BY_TYPE");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(VoucherType.RELAX, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test
    public void searchByOneEnumField_ByCountry_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_RESULT_BY_COUNTRY");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_RESULT_BY_COUNTRY");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_RESULT_BY_COUNTRY");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(CountriesOption.ITALY, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test
    public void searchByOneEnumField_ByAccommodation_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_RESULT_BY_ACCOMMODATION");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_RESULT_BY_ACCOMMODATION");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_RESULT_BY_ACCOMMODATION");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(AccommodationOption.SUITE_ROOM, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test
    public void searchByOneEnumField_ByTransport_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_RESULT_BY_TRANSPORT");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_RESULT_BY_TRANSPORT");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_RESULT_BY_TRANSPORT");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(TransportOption.TRAIN, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }

    @Test
    public void searchByOneEnumField_ByExcursion_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_RESULT_BY_EXCURSION");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(ExcursionOption.HISTORICAL_TOUR, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }

    @Test
    public void searchByOneEnumField_ByShopping_PositiveTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_RESULT_BY_SHOPPING");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchByOneEnumField(ShoppingOption.SALE_SHOPPING, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test(expected = VoucherListNullException.class)
    public void searchByOneEnumField_VoucherListNullExceptionTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        expectedSearchResult = new ArrayList<>();
        voucherSearch.searchByOneEnumField(ShoppingOption.SALE_SHOPPING, expectedSearchResult);

    }


    @Test(expected = VoucherUnknownEnumSearchParamException.class)
    public void searchByOneEnumField_VoucherUnknownEnumSearchParamExceptionTest() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchByOneEnumField(failedTestSearchParams.TEST1, proposalCreator.generateProposalAllTypes(initialProposalParams));


    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByCost_VoucherWrongSearchParamException_0_0_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByCost(0, 0, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByCost_VoucherWrongSearchParamException_negative_positive_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByCost(-1, 10, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByCost_VoucherWrongSearchParamException_negative_negative_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByCost(-1, -2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }


    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByCost_VoucherWrongSearchParamException_positive_negative_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByCost(1, -2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByCost_VoucherWrongSearchParamException_min_more_max_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByCost(10, 2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherListNullException.class)
    public void searchVoucherByCost_VoucherListNullException_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        voucherSearch.searchVoucherByCost(1, 12, emptyInitialsearchList);

    }


    @Test
    public void searchVoucherByCost_CostRange_Test() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException, VoucherWrongSearchParamException {
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_BY_COST_RANGE_RESULT");
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_BY_COST_RANGE_RESULT");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_BY_COST_RANGE_RESULT");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchVoucherByCost(150, 250, proposalCreator.generateProposalAllTypes(initialProposalParams)));
        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }

     @Test
    public void searchVoucherByCost_ExactNumber_Test() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException, VoucherWrongSearchParamException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_BY_COST_EXACT_RESULT");
         initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_BY_COST_EXACT_RESULT");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchVoucherByCost(210, 210, proposalCreator.generateProposalAllTypes(initialProposalParams)));
         for (Voucher obj:expectedSearchResult
                 ) {
             System.out.println(obj.toString());

         }
         for (Voucher obj:actualSearchResult
              ) {
             System.out.println(obj.toString());

         }
        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByDays_VoucherWrongSearchParamException_0_0_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByDays(0, 0, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByDays_VoucherWrongSearchParamException_negative_positive_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByDays(-1, 10, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByDays_VoucherWrongSearchParamException_negative_negative_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByDays(-1, -2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }


    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByDays_VoucherWrongSearchParamException_positive_negative_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByDays(1, -2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherWrongSearchParamException.class)
    public void searchVoucherByDays_VoucherWrongSearchParamException_min_more_max_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        voucherSearch.searchVoucherByDays(10, 2, proposalCreator.generateProposalAllTypes(initialProposalParams));

    }

    @Test(expected = VoucherListNullException.class)
    public void searchVoucherByDays_VoucherListNullException_Test() throws VoucherWrongSearchParamException, ProposalCreationException, VoucherListNullException {

        voucherSearch.searchVoucherByDays(1, 12, emptyInitialsearchList);

    }


    @Test
    public void searchVoucherByDays_DaysRange_Test() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException, VoucherWrongSearchParamException {
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_BY_DAYS_RANGE_RESULT");
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_BY_DAYS_RANGE_RESULT");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_BY_DAYS_RANGE_RESULT");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchVoucherByDays(6, 15, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }


    @Test
    public void searchVoucherByDays_ExactNumber_Test() throws ProposalCreationException, VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException, VoucherWrongSearchParamException {
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_SEARCH_BY_DAYS_EXACT_RESULT");
        initialProposalParams.put(VoucherType.RELAX, "RELAX_SEARCH_BY_DAYS_EXACT_RESULT");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_SEARCH_BY_DAYS_EXACT_RESULT");
        expectedSearchResult = new ArrayList<>(proposalCreator.generateProposalAllTypes(initialProposalParams));
        initialProposalParams.clear();
        initialProposalParams.put(VoucherType.RELAX, "RELAX_VOUCHER_CREAT_TEST");
        initialProposalParams.put(VoucherType.SHOPPING, "SHOPPING_VOUCHER_CREATE_TEST");
        initialProposalParams.put(VoucherType.EXCURSION, "EXCURSION_VOUCHER_CREATE_TEST");
        actualSearchResult = new ArrayList<>(voucherSearch.searchVoucherByDays(15, 15, proposalCreator.generateProposalAllTypes(initialProposalParams)));

        Assert.assertTrue(expectedSearchResult.size() == actualSearchResult.size() && expectedSearchResult.containsAll(actualSearchResult));
    }

}

