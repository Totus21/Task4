package com.epam.natasha_mishuk.voucher_util;


import com.epam.natasha_mishuk.available_option.*;
import com.epam.natasha_mishuk.voucher.ExcursionVoucher;
import com.epam.natasha_mishuk.voucher.RelaxVoucher;
import com.epam.natasha_mishuk.voucher.ShoppingVoucher;
import com.epam.natasha_mishuk.voucher.Voucher;

import java.util.ArrayList;
import java.util.List;

import com.epam.natasha_mishuk.voucher_exception.*;
import com.epam.natasha_mishuk.voucher_validator.ProposalValidator;
import com.epam.natasha_mishuk.voucher_validator.SearchValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoucherSearch {
    Logger logger = LogManager.getLogger("VoucherSearch");

    public String defineEnumSearchParam(Enum searchParam) throws VoucherUnknownEnumSearchParamException {
        logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> called to define search param [" + searchParam + "]");

        if (searchParam.getClass().getName().equals(VoucherType.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherType");
            return "VoucherType";
        }
        if (searchParam.getClass().getName().equals(CountriesOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherCountry");
            return "VoucherCountry";
        }
        if (searchParam.getClass().getName().equals(AccommodationOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherAccommodation");
            return "VoucherAccommodation";
        }

        if (searchParam.getClass().getName().equals(TransportOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherTransport");
            return "VoucherTransport";
        }

        if (searchParam.getClass().getName().equals(FoodOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherFood");
            return "VoucherFood";
        }

        if (searchParam.getClass().getName().equals(ShoppingOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherShoppingOption");
            return "VoucherShoppingOption";
        }

        if (searchParam.getClass().getName().equals(ExcursionOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherExcursionOption");
            return "VoucherExcursionOption";
        }
        if (searchParam.getClass().getName().equals(InsuranceOption.class.getName())) {
            logger.log(Level.INFO, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is value of VoucherInsuranceOption");
            return "VoucherInsuranceOption";
        }

        if (true) {
            logger.log(Level.WARN, "VoucherSearch.defineEnumSearchParam-> search param [" + searchParam + "] is  not value of [VoucherType|VoucherCountry|VoucherAccommodation|VoucherTransport|VoucherFood|VoucherShoppingOption|VoucherExcursionOption|VoucherInsuranceOption]");
            throw new VoucherUnknownEnumSearchParamException("Received search enum param[" + searchParam.name() + " is not supported search param for voucher search");
        }

        return searchParam.name();
    }





    public List<Voucher> searchByOneEnumField(Enum searchParam, List<Voucher> initialVoucherList) throws VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField-> called to  search by param [" + searchParam.name() + "]");

        List<Voucher> searchResultVoucherList = new ArrayList<>();
        SearchValidator searchValidator = new SearchValidator();
        ProposalValidator proposalValidator = new ProposalValidator();

        logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField-> all local variables are successfully declared and initialized [searchResultVoucherList|searchValidator|proposalValidator]");


        String localSearchParam = defineEnumSearchParam(searchParam);
        logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField-> searchParam[" + searchParam.name() + "is successfully identified to[" + localSearchParam + "]");

        if (proposalValidator.validateIfVoucherProposalEmpty(initialVoucherList)) {
            logger.log(Level.ERROR, "VoucherSearch.searchByOneEnumField->throws  VoucherListNullException as initialVoucherList is empty and can not be used for search ");
            throw new VoucherListNullException("initialVoucherList is empty. Search operation on null can not be applied");
        }
        for (Voucher voucher : initialVoucherList) {
            logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->checks if voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());

            try {

                if (searchValidator.validateIfSearchParameterAllowedForVoucherType(localSearchParam, voucher.getVoucherType())) {

                    switch (localSearchParam) {
                        case "VoucherType":

                            if (voucher.getVoucherType().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");
                            }

                            break;

                        case "VoucherCountry":

                            if (voucher.getVoucherCountry().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }

                            break;

                        case "VoucherAccommodation":

                            if (voucher.getVoucherAccOption().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }
                            break;


                        case "VoucherTransport":

                            if (voucher.getVoucherTransport().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }


                            break;

                        case "VoucherFood":

                            if (((RelaxVoucher) voucher).getRelaxFoodOption().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }


                            break;

                        case "VoucherShoppingOption":

                            if (((ShoppingVoucher) voucher).getShoppingOption().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }


                            break;

                        case "VoucherExcursionOption":

                            if (((ExcursionVoucher) voucher).getExcursionOption().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }

                            break;

                        case "VoucherInsuranceOption":

                            if (((ExcursionVoucher) voucher).getExcursionInsuranceOption().name().equals(searchParam.name())) {
                                searchResultVoucherList.add(voucher);
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] meets searchParam" + searchParam.name());
                                logger.log(Level.INFO, "VoucherSearch.searchByOneEnumField->voucher[" + voucher.toString() + "] successfully added to searchResultVoucherList ");

                            }

                            break;


                        default: {
                            logger.log(Level.ERROR, "VoucherSearch.searchByOneEnumField->throws VoucherUnknownSearchParamException exception as doesn't support search  for mentioned searchParam " + searchParam.name());
                            throw new VoucherUnknownSearchParamException("Unknown searchParam exception ");
                        }
                    }
                } else {
                    logger.log(Level.ERROR, "VoucherSearch.searchByOneEnumField->  search by param [" + searchParam.name() + "] can not be applied to voucher[" + voucher.getVoucherType() + "]");
                }
            } catch (NoSuchVoucherTypeException e) {
                logger.log(Level.ERROR, "VoucherSearch.searchByOneEnumField-> NoSuchVoucherTypeException. Unknown voucher [" + voucher.getVoucherType().name() + "] is excluded from the search result");
            }
        }

        return searchResultVoucherList;
    }


    public List<Voucher> searchVoucherByDays(int minValue, int maxValue, List<Voucher> initialVoucherList) throws VoucherListNullException, VoucherWrongSearchParamException {
        logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->called to search through initialVoucherList by days in range [" + minValue + "-" + maxValue + "]");

        ProposalValidator proposalValidator = new ProposalValidator();
        if ((minValue == maxValue && maxValue == 0) || minValue < 0 || maxValue <= 0 || maxValue < minValue) {

            logger.log(Level.ERROR, "VoucherSearch.searchVoucherByDays->throws VoucherWrongSearchParamException for searchParams:minValue[" + minValue + "] maxValue[" + maxValue + "]");
            throw new VoucherWrongSearchParamException("VoucherWrongSearchParamException-> minValue<=0 or maxValue<=0 or maxValue<minValue:minValue[" + minValue + "] maxValue[" + maxValue + "]");
        }

        if (proposalValidator.validateIfVoucherProposalEmpty(initialVoucherList)) {
            logger.log(Level.ERROR, "VoucherSearch.searchVoucherByDays->throws VoucherListNullException as initialSearch list is  empty and can not be used for search");
            throw new VoucherListNullException("initialVoucherList is empty. Search operation on null can not be applied");
        }
        List<Voucher> searchResultVoucherList = new ArrayList<>();

        for (Voucher obj : initialVoucherList) {
            logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->checks if voucher[" + obj.toString() + "meets minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");

            if (obj.getVoucherNumberOfDays() <= maxValue && obj.getVoucherNumberOfDays() >= minValue) {
                searchResultVoucherList.add(obj);
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->voucher[" + obj.toString() + "meets minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->voucher[" + obj.toString() + "successfully added to searchResultVoucherList");


            } else {
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->voucher[" + obj.toString() + "DOESN'T meet minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->voucher[" + obj.toString() + "is not added to searchResultVoucherList");

            }


        }
        logger.log(Level.INFO, "VoucherSearch.searchVoucherByDays->returns searchResultVoucherList");
        return searchResultVoucherList;
    }

    public List<Voucher> searchVoucherByCost(int minValue, int maxValue, List<Voucher> initialVoucherList) throws VoucherWrongSearchParamException, VoucherListNullException {
        List<Voucher> searchResultVoucherList = new ArrayList<>();
        logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->called to search through initialVoucherList by cost in range [" + minValue + "-" + maxValue + "]");

        ProposalValidator proposalValidator = new ProposalValidator();
        if ((minValue == maxValue && maxValue == 0) || minValue < 0 || maxValue <= 0 || maxValue < minValue) {

            logger.log(Level.ERROR, "VoucherSearch.searchVoucherByCost->throws VoucherWrongSearchParamException for searchParams:minValue[" + minValue + "] maxValue[" + maxValue + "]");
            throw new VoucherWrongSearchParamException("VoucherWrongSearchParamException-> minValue<=0 or maxValue<=0 or maxValue<minValue:minValue[" + minValue + "] maxValue[" + maxValue + "]");
        }

        if (proposalValidator.validateIfVoucherProposalEmpty(initialVoucherList)) {
            logger.log(Level.ERROR, "VoucherSearch.searchVoucherByCost->throws VoucherListNullException as initialSearch list is  empty and can not be used for search");
            throw new VoucherListNullException("initialVoucherList is empty. Search operation on null can not be applied");
        }

        for (Voucher obj : initialVoucherList) {
            logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->checks if voucher[" + obj.toString() + "meets minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");

            if (obj.getVoucherCost() <= maxValue && obj.getVoucherCost() >= minValue) {
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->voucher[" + obj.toString() + "meets minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");
                searchResultVoucherList.add(obj);
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->voucher[" + obj.toString() + "successfully added to searchResultVoucherList");


            } else {
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->voucher[" + obj.toString() + "DOESN'T meet minValue[" + minValue + "] and maxValue[" + maxValue + "] search parameters");
                logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->voucher[" + obj.toString() + "is not added to searchResultVoucherList");

            }


        }
        logger.log(Level.INFO, "VoucherSearch.searchVoucherByCost->returns searchResultVoucherList");
        return searchResultVoucherList;

    }


    //optional search functions are not covered with tests and log4j
    public List<Voucher> searchForSetEnumFields(List<Enum> searchParams, List<Voucher> initialVoucherList) throws VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        List<Voucher> searchResultVoucherList = new ArrayList<>();
        for (Enum obj : searchParams) {
            searchResultVoucherList.addAll(searchByOneEnumField(obj, initialVoucherList));
        }
        return searchResultVoucherList;
    }

    public List<Voucher> searchBySetEnumFields(List<Enum> searchParams, List<Voucher> initialVoucherList) throws VoucherUnknownSearchParamException, VoucherUnknownEnumSearchParamException, VoucherListNullException {
        List<Voucher> searchResultVoucherList = new ArrayList<>();
        List<Voucher> searchTempResultVoucherList = new ArrayList<>();
        searchResultVoucherList.addAll(initialVoucherList);
        for (Enum obj : searchParams) {
            searchTempResultVoucherList.addAll(searchByOneEnumField(obj, searchResultVoucherList));
            searchResultVoucherList.clear();
            searchResultVoucherList.addAll(searchTempResultVoucherList);
        }
        return searchResultVoucherList;
    }
}
