package com.epam.natasha_mishuk.test_util.voucher_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.available_option.*;

public class RelaxVoucherTest {
    private RelaxVoucher testRelaxVoucher;
    private RelaxVoucher equalRelaxTestVoucher;
    private RelaxVoucher notequalRelaxTestVoucher;
    @Before

    public void initRelaxVoucher()
    {
        testRelaxVoucher=new RelaxVoucher(VoucherType.RELAX,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM,FoodOption.ALL_INCLUSIVE);
        equalRelaxTestVoucher=new RelaxVoucher(VoucherType.RELAX,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM,FoodOption.ALL_INCLUSIVE);
        notequalRelaxTestVoucher=new RelaxVoucher(VoucherType.RELAX,CountriesOption.EGYPT, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM,FoodOption.ALL_INCLUSIVE);


    }
    @After
    public void clearVoucher()
    {
        testRelaxVoucher=null;
        equalRelaxTestVoucher=null;
        notequalRelaxTestVoucher=null;

    }

    @Test
    public void equalsPositiveTest()
    {
        Assert.assertTrue("Fails as testRelaxVoucher is not equal to equalRelaxTestVoucher: testRelaxVoucher-> " + testRelaxVoucher.toString()+ " equalTestVoucher-> "+equalRelaxTestVoucher.toString(),testRelaxVoucher.equals(equalRelaxTestVoucher));

    }
    @Test
    public void equalsNegativeTest()
    {
        Assert.assertFalse("Fails as testRelaxVoucher is equal to notequalRelaxTestVoucher: testRelaxVoucher->" + testRelaxVoucher.toString()+ " notequalRelaxTestVoucher-> "+notequalRelaxTestVoucher.toString(),testRelaxVoucher.equals(notequalRelaxTestVoucher));

    }


}
