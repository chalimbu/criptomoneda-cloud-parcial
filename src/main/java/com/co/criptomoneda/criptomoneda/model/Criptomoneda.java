package com.co.criptomoneda.criptomoneda.model;

import java.util.Objects;

public class Criptomoneda {
    private int idMoneda;
    private int valor;
    private String simbolo;

    public Criptomoneda() {
    }

    public Criptomoneda(int idMoneda, String simbolo) {
        this.idMoneda = idMoneda;
        this.simbolo = simbolo;
    }

    public Criptomoneda(int idMoneda, int valor, String simbolo) {
        this.idMoneda = idMoneda;
        this.valor = valor;
        this.simbolo = simbolo;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criptomoneda that = (Criptomoneda) o;
        return idMoneda == that.idMoneda &&
                Objects.equals(simbolo, that.simbolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMoneda, simbolo);
    }
}
