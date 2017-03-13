package com.epam.natasha_mishuk.available_option;

/**
 * Created by Natasha_Mishuk on 2/26/2017.
 */
public enum ExcursionOption {
    HISTORICAL_TOUR, EXTREMAL_TOUR,NIGHT_LIFE_TOUR,NO_TOUR;

    public double getExcursionOptionCostPerDay (CountriesOption countryOption)
    {
        switch (this){
            case HISTORICAL_TOUR:
            {
                switch(countryOption){
                    case BELARUS:
                        return 5;
                    case ITALY:
                        return 8;
                    case EGYPT:
                        return 4;
                    case TURKEY:
                        return 7;
                    case RUSSIA:
                        return 9;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case EXTREMAL_TOUR:
            {
                switch(countryOption){
                    case BELARUS:
                        return 7;
                    case ITALY:
                        return 12;
                    case EGYPT:
                        return 8;
                    case TURKEY:
                        return 9;
                    case RUSSIA:
                        return 6;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case NIGHT_LIFE_TOUR:
            {
                switch(countryOption){
                    case BELARUS:
                        return 6;
                    case ITALY:
                        return 7;
                    case EGYPT:
                        return 5;
                    case TURKEY:
                        return 4;
                    case RUSSIA:
                        return 7;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case NO_TOUR:
            {
                return 0;
            }
            //rework with exceptions
            default:
                return 0;
        }

    }


}
