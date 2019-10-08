package com.co.criptomoneda.criptomoneda.dao;

import com.co.criptomoneda.criptomoneda.model.Criptomoneda;

import java.util.List;

public interface ICriptomonedaDao {
    Boolean addCriptomoneda(Criptomoneda criptomoneda);
    Boolean deleteCriptomoneda(int idMoneda,String simbolo);
    List<Criptomoneda> getCriptomoneda();
}
