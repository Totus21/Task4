package com.epam.natasha_mishuk.test_util.voucher_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.available_option.*;


public class VoucherTest {
    private Voucher testVoucher;
    private Voucher equalTestVoucher;
    private Voucher equalSecondTestVoucher;
    private Voucher notequalCountryTestVoucher;
    private Voucher notequalTransportTestVoucher;
    private Voucher notequalDaystTestVoucher;
    private Voucher notequalAccomodationTestVoucher;




    @Before
    public void initVoucher() {
        testVoucher = new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM);
        equalTestVoucher = new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM);
        equalSecondTestVoucher = new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM);
        notequalCountryTestVoucher = new Voucher(VoucherType.BASIC,CountriesOption.EGYPT, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM);
        notequalTransportTestVoucher = new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.AIRCRAFT, 5, AccommodationOption.SUITE_ROOM);
        notequalDaystTestVoucher= new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.BUS, 6, AccommodationOption.SUITE_ROOM);
        notequalAccomodationTestVoucher=new Voucher(VoucherType.BASIC,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.HOSTEL_ROOM);


    }

    @After
    public void clearVoucher() {
        testVoucher = null;
        equalTestVoucher = null;
        equalSecondTestVoucher=null;
        notequalCountryTestVoucher = null;
        notequalTransportTestVoucher= null;
        notequalDaystTestVoucher=null;
        notequalAccomodationTestVoucher=null;

    }


    @Test

    public void equalPositiveTest_test_equals_test() {
        Assert.assertTrue("Fails as testVoucher is not equal to testVoucher: testVoucher-> " + testVoucher.toString() + " equalTestVoucher-> " + testVoucher.toString(), testVoucher.equals(testVoucher));

    }

    @Test
    public void equalPositiveTest_test_equals_equalTest() {
        Assert.assertTrue("Fails as testVoucher is not equal to equalTestVoucher: testVoucher-> " + testVoucher.toString() + " equalTestVoucher-> " + equalTestVoucher.toString(), testVoucher.equals(equalTestVoucher));

    }

    @Test
    public void equalPositiveTest_equalTest_equals_test() {
        Assert.assertTrue("Fails as equalTestVoucher is not equal to testVoucher: equalTestVoucher-> " + equalTestVoucher.toString() + " testVoucher-> " + testVoucher.toString(), equalTestVoucher.equals(testVoucher));

    }

    @Test
    public void equalPositiveTest_test_equals_equalTest_equals_equalSecondTest() {

        Assert.assertTrue("Fails as testVoucher!=equalTestVoucher or equalTestVoucher!=equalSecondTestVoucher or testVoucher!=equalSecondTestVoucher but should be equals", testVoucher.equals(equalTestVoucher)==equalTestVoucher.equals(equalSecondTestVoucher)==testVoucher.equals(equalTestVoucher));

    }

    @Test
    public void equalPositiveTest_test_not_equals_null() {

        Assert.assertFalse("Fails as testVoucher equals null but should not be", testVoucher.equals(null));

    }

    @Test
    public void equalsCountryNegativeTest() {
        Assert.assertFalse("Fails as testVoucher is equal to notequalCountryTestVoucher: testVoucher->" + testVoucher.toString() + " notequalCountryTestVoucher-> " + notequalCountryTestVoucher.toString(), testVoucher.equals(notequalCountryTestVoucher));

    }


    @Test
    public void equalsTransportNegativeTest() {
        Assert.assertFalse("Fails as testVoucher is equal to notequalTransportTestVoucher: testVoucher->" + testVoucher.toString() + " notequalTransportTestVoucher-> " + notequalCountryTestVoucher.toString(), testVoucher.equals(notequalTransportTestVoucher));

    }

    @Test
    public void equalsDaysNegativeTest() {
        Assert.assertFalse("Fails as testVoucher is equal to notequalDaystTestVoucher: testVoucher->" + testVoucher.toString() + " notequalDaystTestVoucher-> " + notequalDaystTestVoucher.toString(), testVoucher.equals(notequalDaystTestVoucher));

    }

    @Test
    public void equalsAccomodationNegativeTest() {
        Assert.assertFalse("Fails as testVoucher is equal to notequalAccomodationTestVoucher: testVoucher->" + testVoucher.toString() + " notequalAccomodationTestVoucher-> " + notequalAccomodationTestVoucher.toString(), testVoucher.equals(notequalAccomodationTestVoucher));

    }

}
