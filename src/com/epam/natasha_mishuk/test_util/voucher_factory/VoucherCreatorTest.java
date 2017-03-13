package com.epam.natasha_mishuk.test_util.voucher_factory;

import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;
import com.epam.natasha_mishuk.voucher_calc_util.ImplExcursionVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplRelaxVoucherCalc;
import com.epam.natasha_mishuk.voucher_calc_util.ImplShoppingVoucherCalc;
import com.epam.natasha_mishuk.voucher_exception.VoucherCreationException;
import com.epam.natasha_mishuk.voucher_factory.VoucherCreator;
import org.junit.*;

public class VoucherCreatorTest {
    private VoucherCreator voucherCreator;

    private Voucher expectedRelaxVoucher;
    private Voucher actualRelaxVoucher;
    private ImplRelaxVoucherCalc implRelaxVoucherCalc;
    private ImplExcursionVoucherCalc implExcursionVoucherCalc;
    private ImplShoppingVoucherCalc implShoppingVoucherCalc;
    private Voucher expectedExcursionVoucher;
    private Voucher actualExcursionVoucher;
    private Voucher expectedShoppingVoucher;
    private Voucher actualShoppingVoucher;

    @Before
    public void initVoucher(){
        voucherCreator=new VoucherCreator();
        implRelaxVoucherCalc=new ImplRelaxVoucherCalc();
        implExcursionVoucherCalc=new ImplExcursionVoucherCalc();
        implShoppingVoucherCalc=new ImplShoppingVoucherCalc();
           }
   @After
        public void clearVoucher(){
        voucherCreator=null;
        implRelaxVoucherCalc=null;
        expectedRelaxVoucher=null;
        actualRelaxVoucher=null;
        expectedExcursionVoucher=null;
        actualExcursionVoucher=null;
        expectedShoppingVoucher=null;
        actualShoppingVoucher=null;
       implExcursionVoucherCalc=null;
       implShoppingVoucherCalc=null;
    }

   @Test
   public void generateVoucher_RelaxVoucherTest() throws VoucherCreationException{

       expectedRelaxVoucher=new RelaxVoucher(VoucherType.RELAX, CountriesOption.ITALY, TransportOption.TRAIN,12, AccommodationOption.SUITE_ROOM, FoodOption.BED_AND_BREAKFAST);
       implRelaxVoucherCalc.calcVoucherCost((RelaxVoucher) expectedRelaxVoucher);
       actualRelaxVoucher = voucherCreator.generateVoucher(VoucherType.RELAX, "RELAX,ITALY,TRAIN,12,SUITE_ROOM,BED_AND_BREAKFAST");
       Assert.assertEquals("expectedRelaxVoucher ["+ expectedRelaxVoucher.toString()+"] is not equal to actualRelaxVoucher[ "+actualRelaxVoucher.toString()+"]", expectedRelaxVoucher,actualRelaxVoucher );

    }
    @Test
    public void generateVoucher_ExcursionVoucherTest() throws VoucherCreationException{

        expectedExcursionVoucher=new ExcursionVoucher(VoucherType.EXCURSION, CountriesOption.BELARUS, TransportOption.BUS,5, AccommodationOption.SUITE_ROOM, ExcursionOption.HISTORICAL_TOUR, InsuranceOption.BASIC);
        implExcursionVoucherCalc.calcVoucherCost((ExcursionVoucher)expectedExcursionVoucher);
        actualExcursionVoucher = voucherCreator.generateVoucher(VoucherType.EXCURSION, "EXCURSION,BELARUS,BUS,5,SUITE_ROOM,HISTORICAL_TOUR,BASIC");
        Assert.assertEquals("expectedExcursionVoucher ["+ expectedExcursionVoucher.toString()+"] is not equal to actualExcursionVoucher[ "+actualExcursionVoucher.toString()+"]", expectedExcursionVoucher,actualExcursionVoucher );

    }
    @Test
    public void generateVoucher_ShoppingVoucherTest() throws VoucherCreationException{

        expectedShoppingVoucher=new ShoppingVoucher(VoucherType.SHOPPING, CountriesOption.TURKEY, TransportOption.AIRCRAFT,10, AccommodationOption.SUITE_ROOM, ShoppingOption.SALE_SHOPPING);
        implShoppingVoucherCalc.calcVoucherCost((ShoppingVoucher) expectedShoppingVoucher);
        actualShoppingVoucher = voucherCreator.generateVoucher(VoucherType.SHOPPING, "SHOPPING,TURKEY,AIRCRAFT,10,SUITE_ROOM,SALE_SHOPPING");
        Assert.assertEquals("expectedShoppingVoucher ["+ expectedShoppingVoucher.toString()+"] is not equal to actualRelaxVoucher[ "+actualShoppingVoucher+"]", expectedShoppingVoucher,actualShoppingVoucher );

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_EmptyParameters_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_NoType_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"ITALY,TRAIN,12,SUITE_ROOM,BED_AND_BREAKFAST");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongType_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"WRONG,ITALY,TRAIN,12,SUITE_ROOM,BED_AND_BREAKFAST");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongCountry_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"RELAX,WRONG,TRAIN,12,SUITE_ROOM,BED_AND_BREAKFAST");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongTransport_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"RELAX,ITALY,WRONG,12,SUITE_ROOM,BED_AND_BREAKFAST");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongDays_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"RELAX,ITALY,TRAIN,WRONG,SUITE_ROOM,BED_AND_BREAKFAST");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongAccommodation_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"RELAX,ITALY,TRAIN,12,WRONG,BED_AND_BREAKFAST");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_RelaxVoucher_WrongFood_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.RELAX,"RELAX,ITALY,TRAIN,12,SUITE_ROOM,WRONG");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ExcursionVoucher_EmptyParameters_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.EXCURSION,"");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ExcursionVoucher_WrongExcursion_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.EXCURSION,"EXCURSION,BELARUS,BUS,5,SUITE_ROOM,WRONG,BASIC");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ExcursionVoucher_WrongInsurance_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.EXCURSION,"EXCURSION,BELARUS,BUS,5,SUITE_ROOM,HISTORICAL_TOUR,WRONG");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ExcursionVoucher_NoCountry_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.EXCURSION,"EXCURSION,BUS,5,SUITE_ROOM,HISTORICAL_TOUR,BASIC");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ShoppingVoucher_EmptyParameters_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.SHOPPING,"");

    }
    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ShoppingVoucher_WRONG_SHOPPING_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.SHOPPING,"SHOPPING,TURKEY,AIRCRAFT,10,SUITE_ROOM,WRONG");

    }

    @Test(expected = VoucherCreationException.class)
    public void generateVoucher_ShoppingVoucher_NoAccommodation_VoucherCreationExceptionTest()throws VoucherCreationException{

        voucherCreator.generateVoucher(VoucherType.SHOPPING,"SHOPPING,TURKEY,AIRCRAFT,10,SALE_SHOPPING");

    }

}
