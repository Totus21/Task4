package com.epam.natasha_mishuk.available_option;


public enum AccommodationOption {
    HOTEL_ROOM,SUITE_ROOM,HOSTEL_ROOM,NO_ACCOMMODATION;

    public double getAccommodationOptionCostPerDay (CountriesOption countryOption)
    {
        switch (this){
            case HOTEL_ROOM:
            {
                switch(countryOption){
                    case BELARUS:
                        return 5;
                    case ITALY:
                        return 10;
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
            case SUITE_ROOM:
            {
                switch(countryOption){
                    case BELARUS:
                        return 8;
                    case ITALY:
                        return 16;
                    case EGYPT:
                        return 6;
                    case TURKEY:
                        return 6;
                    case RUSSIA:
                        return 9;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case HOSTEL_ROOM:
            {
                switch(countryOption){
                    case BELARUS:
                        return 6;
                    case ITALY:
                        return 10;
                    case EGYPT:
                        return 8;
                    case TURKEY:
                        return 9;
                    case RUSSIA:
                        return 9;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case NO_ACCOMMODATION:
            {
                return 0;
            }
            //rework with exceptions
            default:
                return 0;
        }

    }

}
