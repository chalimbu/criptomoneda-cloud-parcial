package com.co.criptomoneda.criptomoneda.services;

import com.co.criptomoneda.criptomoneda.model.Criptomoneda;

import java.util.List;

public interface ICriptomonedaService {
    Boolean addCriptomoneda(Criptomoneda criptomoneda);
    Boolean deleteCriptomoneda(int idMoneda,String simbolo);
    List<Criptomoneda> getCriptomoneda();
    Criptomoneda higherValue();
    String moreUseCurrency();
}
