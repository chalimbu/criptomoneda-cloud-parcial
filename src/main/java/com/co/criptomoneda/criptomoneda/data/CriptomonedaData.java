package com.co.criptomoneda.criptomoneda.data;

import com.co.criptomoneda.criptomoneda.model.Criptomoneda;

import java.util.ArrayList;
import java.util.List;

public class CriptomonedaData {
    private static List<Criptomoneda> listado;
    static{
        listado=new ArrayList<Criptomoneda>(){{
            add(new Criptomoneda(10,1000,"USD"));
            add(new Criptomoneda(20,1000,"USD"));
            add(new Criptomoneda(30,1000,"EUR"));
        }};
        System.out.println(listado);
    }

    public static List<Criptomoneda> getListado() {
        return listado;
    }

    public static void setListado(List<Criptomoneda> listado) {
        CriptomonedaData.listado = listado;
    }
}
