package com.co.criptomoneda.criptomoneda.dao.imp;

import com.co.criptomoneda.criptomoneda.dao.ICriptomonedaDao;
import com.co.criptomoneda.criptomoneda.data.CriptomonedaData;
import com.co.criptomoneda.criptomoneda.model.Criptomoneda;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriptomonedaList implements ICriptomonedaDao {

    @Override
    public Boolean addCriptomoneda(Criptomoneda criptomoneda) {
        return CriptomonedaData.getListado().add(criptomoneda);
    }

    @Override
    public Boolean deleteCriptomoneda(int idMoneda, String simbolo) {
        CriptomonedaData.getListado().remove(new Criptomoneda(idMoneda,simbolo));
        return true;
    }

    @Override
    public List<Criptomoneda> getCriptomoneda() {
        return CriptomonedaData.getListado();
    }
}
