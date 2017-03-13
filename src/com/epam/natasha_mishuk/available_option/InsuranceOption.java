package com.epam.natasha_mishuk.available_option;


public enum InsuranceOption {
    BASIC,EXTENDED,EXTREME_SPECIAL,NO_INSURANCE;

    public double getInsuranceOptionCostPerDay (CountriesOption countryOption)
    {
        switch (this){
            case BASIC:
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
            case EXTENDED:
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
            case EXTREME_SPECIAL:
            {
                switch(countryOption){
                    case BELARUS:
                        return 15;
                    case ITALY:
                        return 30;
                    case EGYPT:
                        return 16;
                    case TURKEY:
                        return 16;
                    case RUSSIA:
                        return 20;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case NO_INSURANCE:
            {
                return 0;
            }
            //rework with exceptions
            default:
                return 0;
        }

    }


}
