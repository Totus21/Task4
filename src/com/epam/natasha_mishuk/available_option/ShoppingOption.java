package com.epam.natasha_mishuk.available_option;

public enum ShoppingOption {
    SALE_SHOPPING, EXCLUSIVE_SHOPPING,SELF_SHOPPING;

    public double getShoppingOptionCostPerDay (CountriesOption countryOption)
    {
        switch (this){
            case SALE_SHOPPING:
            {
                switch(countryOption){
                    case BELARUS:
                        return 5;
                    case ITALY:
                        return 6;
                    case EGYPT:
                        return 4;
                    case TURKEY:
                        return 4;
                    case RUSSIA:
                        return 6;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case EXCLUSIVE_SHOPPING:
            {
                switch(countryOption){
                    case BELARUS:
                        return 12;
                    case ITALY:
                        return 22;
                    case EGYPT:
                        return 8;
                    case TURKEY:
                        return 8;
                    case RUSSIA:
                        return 16;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case SELF_SHOPPING:
            {
                switch(countryOption){
                    case BELARUS:
                        return 2;
                    case ITALY:
                        return 4;
                    case EGYPT:
                        return 3;
                    case TURKEY:
                        return 3;
                    case RUSSIA:
                        return 5;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            //rework with exceptions
            default:
                return 0;
        }

    }

}
