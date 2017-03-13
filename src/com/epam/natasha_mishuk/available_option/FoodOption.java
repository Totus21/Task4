package com.epam.natasha_mishuk.available_option;


public enum FoodOption {

    ALL_INCLUSIVE,HALF_BOARD,BED_AND_BREAKFAST,NO_FOOD;


    public double getFoodOptionCostPerDay (CountriesOption countryOption)
    {
        switch (this){
            case ALL_INCLUSIVE:
            {
                switch(countryOption){
                    case BELARUS:
                        return 10;
                    case ITALY:
                        return 20;
                    case EGYPT:
                        return 7;
                    case TURKEY:
                        return 7;
                    case RUSSIA:
                        return 15;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case HALF_BOARD:
            {
                switch(countryOption){
                    case BELARUS:
                        return 7;
                    case ITALY:
                        return 17;
                    case EGYPT:
                        return 4;
                    case TURKEY:
                        return 4;
                    case RUSSIA:
                        return 12;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case BED_AND_BREAKFAST:
            {
                switch(countryOption){
                    case BELARUS:
                        return 6;
                    case ITALY:
                        return 16;
                    case EGYPT:
                        return 2;
                    case TURKEY:
                        return 2;
                    case RUSSIA:
                        return 11;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case NO_FOOD:
            {
                return 0;
            }
            //rework with exceptions
            default:
                return 0;
        }

    }


}
