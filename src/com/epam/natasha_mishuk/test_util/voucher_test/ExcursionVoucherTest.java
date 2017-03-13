package com.epam.natasha_mishuk.test_util.voucher_test;

import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class ExcursionVoucherTest {
    private ExcursionVoucher testExcursionVoucher;
    private ExcursionVoucher equalTestExursionVoucher;
    private ExcursionVoucher notequalTestExcursionVoucher;

    @Before
    public void initExcursionVoucher() {
        testExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        equalTestExursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
        notequalTestExcursionVoucher = new ExcursionVoucher(VoucherType.EXCURSION,CountriesOption.EGYPT, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ExcursionOption.EXTREMAL_TOUR, InsuranceOption.EXTREME_SPECIAL);
    }

    @After
    public void clearExcursionVoucher() {
        testExcursionVoucher = null;
        equalTestExursionVoucher = null;
        notequalTestExcursionVoucher = null;

    }

    @Test
    public void equalsPositiveTest() {
        Assert.assertTrue("Fails as testExcursionVoucher is not equal to equalTestExcursionVoucher: testVoucher-> " + testExcursionVoucher.toString() + " equalTestExcursionVoucher-> " + equalTestExursionVoucher.toString(), testExcursionVoucher.equals(equalTestExursionVoucher));

    }

    @Test
    public void equalsNegativeTest() {
        Assert.assertFalse("Fails as testExcursionVoucher is equal to notequalTestExcursionVoucher: testVoucher->" + testExcursionVoucher.toString() + " notequalTestExcursionVoucher-> " + notequalTestExcursionVoucher.toString(), testExcursionVoucher.equals(notequalTestExcursionVoucher));

    }
}
