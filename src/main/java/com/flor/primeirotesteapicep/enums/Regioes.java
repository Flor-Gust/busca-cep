package com.flor.primeirotesteapicep.enums;

public enum Regioes {
    SUDESTE(7.85),
    NORTE(20.83),
    NORDESTE(15.98),
    CENTROOESTE(12.50),
    SUL(17.30);

    private Double value;

    private Regioes (Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

}
