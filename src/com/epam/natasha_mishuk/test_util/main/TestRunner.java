package com.epam.natasha_mishuk.test_util.main;

import com.epam.natasha_mishuk.test_util.voucher_comparator.ImplExcursionVoucherComparatorTest;
import com.epam.natasha_mishuk.test_util.voucher_comparator.ImplRelaxVoucherComparatorTest;
import com.epam.natasha_mishuk.test_util.voucher_comparator.ImplShoppingVoucherComparatorTest;
import com.epam.natasha_mishuk.test_util.voucher_comparator.ImplVoucherComparatorTest;
import com.epam.natasha_mishuk.test_util.voucher_factory.ProposalCreatorTest;
import com.epam.natasha_mishuk.test_util.voucher_factory.VoucherCreatorTest;
import com.epam.natasha_mishuk.test_util.voucher_util.VoucherSearchTest;
import com.epam.natasha_mishuk.test_util.voucher_validator.VoucherValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.epam.natasha_mishuk.test_util.voucher_test.VoucherTest;
import com.epam.natasha_mishuk.test_util.voucher_test.RelaxVoucherTest;
import com.epam.natasha_mishuk.test_util.voucher_test.ShoppingVoucherTest;
import com.epam.natasha_mishuk.test_util.voucher_test.ExcursionVoucherTest;

@Suite.SuiteClasses({ImplRelaxVoucherComparatorTest.class,VoucherValidatorTest.class,ProposalCreatorTest.class,VoucherTest.class, RelaxVoucherTest.class, ShoppingVoucherTest.class, ExcursionVoucherTest.class, VoucherCreatorTest.class,ImplShoppingVoucherComparatorTest.class,ImplVoucherComparatorTest.class,ImplExcursionVoucherComparatorTest.class,VoucherSearchTest.class})
@RunWith(Suite.class)
public class TestRunner {
}
