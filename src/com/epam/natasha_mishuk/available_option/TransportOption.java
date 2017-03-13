package com.epam.natasha_mishuk.available_option;


public enum TransportOption {
    AIRCRAFT,TRAIN,BUS,LINER;

    public double getTransportOptionCostPerCountry(CountriesOption countryOption)
    {
        switch(this){
            case AIRCRAFT:
            {
                switch(countryOption){
                    case BELARUS:
                        return 5;
                    case ITALY:
                        return 10;
                    case EGYPT:
                        return 4;
                    case TURKEY:
                        return 4;
                    case RUSSIA:
                        return 11;
                    //rework with  exception
                    default:
                        return 0;
                }
            }
            case TRAIN:
            {
                switch(countryOption){
                    case BELARUS:
                        return 4;
                    case ITALY:
                        return 9;
                    case EGYPT:
                        return 0;
                    case TURKEY:
                        return 0;
                    case RUSSIA:
                        return 11;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case BUS:
            {
                switch(countryOption){
                    case BELARUS:
                        return 3;
                    case ITALY:
                        return 8;
                    case EGYPT:
                        return 0;
                    case TURKEY:
                        return 0;
                    case RUSSIA:
                        return 9;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            case LINER:
            {
                switch(countryOption){
                    case BELARUS:
                        return 0;
                    case ITALY:
                        return 8;
                    case EGYPT:
                        return 10;
                    case TURKEY:
                        return 9;
                    case RUSSIA:
                        return 0;
                    //rework with  exception
                    default:
                        return 0;
                }

            }
            //rework with exception
            default:
                return 0;
        }
    }

}
