/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.enumerators;

/**
 * Measurement Units
 * @author PC
 */
public enum MeasurementUnit {
    
    GRAM("g"),
    KILOGRAM("Kg"),
    LITER("L"),
    MILILITER("mL"),
    PICE("pza(s)");
    
    private final String symbol;
    
    MeasurementUnit(String symbol) {
        this.symbol = symbol;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
}
