package com.epam.natasha_mishuk.test_util.voucher_validator;


import com.epam.natasha_mishuk.available_option.VoucherType;
import com.epam.natasha_mishuk.voucher_exception.NoSuchVoucherTypeException;
import com.epam.natasha_mishuk.voucher_validator.SearchValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VoucherValidatorTest {
    private SearchValidator searchValidator;


    @Before
    public void initTestVariables()
    {
        searchValidator=new SearchValidator();
    }


    @After
    public void clearTestVariables()
    {
        searchValidator=null;
    }


    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherType_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherType", VoucherType.BASIC));
    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherCountry_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherCountry", VoucherType.BASIC));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherAccommodation_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherAccommodation", VoucherType.BASIC));



    }


    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherTransport_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherTransport", VoucherType.BASIC));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherFood_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherFood", VoucherType.BASIC));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherExcursionOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherExcursionOption", VoucherType.BASIC));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherInsuranceOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherInsuranceOption", VoucherType.BASIC));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_BASIC_VoucherShoppingOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherShoppingOption", VoucherType.BASIC));



    }


    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherType_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherType", VoucherType.RELAX));
    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherCountry_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherCountry", VoucherType.RELAX));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherAccommodation_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherAccommodation", VoucherType.RELAX));



    }
    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherTransport_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherTransport", VoucherType.RELAX));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherFood_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherFood", VoucherType.RELAX));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherExcursionOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherExcursionOption", VoucherType.RELAX));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherInsuranceOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherInsuranceOption", VoucherType.RELAX));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_RELAX_VoucherShoppingOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherShoppingOption", VoucherType.RELAX));



    }


@Test
public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherType_PositiveTest() throws NoSuchVoucherTypeException {

    Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherType", VoucherType.EXCURSION));
}

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherCountry_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherCountry", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherAccommodation_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherAccommodation", VoucherType.EXCURSION));



    }


    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherTransport_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherTransport", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherFood_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherFood", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherExcursionOption_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherExcursionOption", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherInsuranceOption_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherInsuranceOption", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_EXCURSION_VoucherShoppingOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherShoppingOption", VoucherType.EXCURSION));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherType_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherType", VoucherType.SHOPPING));
    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherCountry_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherCountry", VoucherType.SHOPPING));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherAccommodation_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherAccommodation", VoucherType.SHOPPING));



    }


    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherTransport_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherTransport", VoucherType.SHOPPING));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherFood_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherFood", VoucherType.SHOPPING));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherExcursionOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherExcursionOption", VoucherType.SHOPPING));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherInsuranceOption_NegativeTest() throws NoSuchVoucherTypeException {

        Assert.assertFalse(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherInsuranceOption", VoucherType.SHOPPING));



    }

    @Test
    public void validateIfSearchParameterAllowedForVoucherType_SHOPPING_VoucherShoppingOption_PositiveTest() throws NoSuchVoucherTypeException {

        Assert.assertTrue(searchValidator.validateIfSearchParameterAllowedForVoucherType("VoucherShoppingOption", VoucherType.SHOPPING));



    }




}
