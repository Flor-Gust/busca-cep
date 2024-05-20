package com.flor.primeirotesteapicep.enums;

public enum Estado {
    MG(Regioes.SUDESTE),
    SP(Regioes.SUDESTE),
    ES(Regioes.SUDESTE),
    RJ(Regioes.SUDESTE),
    AM(Regioes.NORTE),
    PA(Regioes.NORTE),
    RO(Regioes.NORTE),
    AC(Regioes.NORTE),
    AP(Regioes.NORTE),
    TO(Regioes.NORTE),
    RR(Regioes.NORTE),
    MA(Regioes.NORDESTE),
    PI(Regioes.NORDESTE),
    CE(Regioes.NORDESTE),
    RN(Regioes.NORDESTE),
    PB(Regioes.NORDESTE),
    PE(Regioes.NORDESTE),
    AL(Regioes.NORDESTE),
    SE(Regioes.NORDESTE),
    BA(Regioes.NORDESTE),
    MT(Regioes.CENTROOESTE),
    MS(Regioes.CENTROOESTE),
    GO(Regioes.CENTROOESTE),
    DF(Regioes.CENTROOESTE),
    PR(Regioes.SUL),
    SC(Regioes.SUL),
    RS(Regioes.SUL);

    private Regioes value;

    private Estado (Regioes value) {
        this.value = value;
    }

    public Regioes getValue() {
        return value;
    }

}
