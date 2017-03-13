package com.epam.natasha_mishuk.test_util.voucher_test;

import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.available_option.*;

public class ShoppingVoucherTest {

    private Voucher testShoppingVoucher;
    private Voucher equalTestShoppingVoucher;
    private Voucher notequalTestShoppingVoucher;

    @Before

    public void initShoppingVoucher() {
        testShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        equalTestShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.BELARUS, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        notequalTestShoppingVoucher = new ShoppingVoucher(VoucherType.SHOPPING,CountriesOption.EGYPT, TransportOption.BUS, 5, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);


    }

    @After
    public void clearShoppingVoucher() {
        testShoppingVoucher = null;
        equalTestShoppingVoucher = null;
        notequalTestShoppingVoucher = null;

    }

    @Test
    public void equalsPositiveTest() {
        Assert.assertTrue("Fails as testShoppingVoucher is not equal to equalTestShoppingVoucher: testVoucher-> " + testShoppingVoucher.toString() + " equalTestShoppingVoucher-> " + equalTestShoppingVoucher.toString(), testShoppingVoucher.equals(equalTestShoppingVoucher));

    }
}
