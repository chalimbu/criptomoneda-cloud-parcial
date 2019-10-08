package com.co.criptomoneda.criptomoneda.services.imp;

import com.co.criptomoneda.criptomoneda.dao.ICriptomonedaDao;
import com.co.criptomoneda.criptomoneda.model.Criptomoneda;
import com.co.criptomoneda.criptomoneda.services.ICriptomonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CriptomonedaService implements ICriptomonedaService {

    @Autowired
    private ICriptomonedaDao iCriptomonedaDao;

    @Override
    public Boolean addCriptomoneda(Criptomoneda criptomoneda) {
        if(criptomoneda.getValor()>=1&&criptomoneda.getValor()<=10_000
            &&(criptomoneda.getSimbolo().equals("USD")||criptomoneda.getSimbolo().equals("EUR")
                ||criptomoneda.getSimbolo().equals("LIB"))){
            if (!getCriptomoneda().contains(criptomoneda)) {//logica viene del equals
                iCriptomonedaDao.addCriptomoneda(criptomoneda);
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public Boolean deleteCriptomoneda(int idMoneda, String simbolo) {
        if(getCriptomoneda().contains(new Criptomoneda(idMoneda,simbolo))){
            return iCriptomonedaDao.deleteCriptomoneda(idMoneda,simbolo);
        }else{
            return false;
        }
    }

    @Override
    public List<Criptomoneda> getCriptomoneda() {
        return iCriptomonedaDao.getCriptomoneda();
    }

    @Override
    public Criptomoneda higherValue() {
        int inicialValue=1;//having in to account that the values are betwen 1 and 10_000
        Iterator iterator=iCriptomonedaDao.getCriptomoneda().iterator();
        while(iterator.hasNext()){
            Criptomoneda cript= (Criptomoneda) iterator.next();
            if(cript.getValor()>inicialValue){
                inicialValue=cript.getValor();
            }
        }
        Criptomoneda returningCrypto=null;
        Iterator iterator2=iCriptomonedaDao.getCriptomoneda().iterator();
        while(iterator2.hasNext()){
            Criptomoneda cript= (Criptomoneda) iterator2.next();
            if(cript.getValor()==inicialValue){
                returningCrypto=cript;
            }
        }
        return returningCrypto;
    }

    //only works with the three currencyes EUR,USD,LIB
    @Override
    public String moreUseCurrency() {
        int counterEur=0;
        int counterUsd=0;
        int counterLib=0;
        Iterator iterator=iCriptomonedaDao.getCriptomoneda().iterator();
        while(iterator.hasNext()){
            Criptomoneda cript= (Criptomoneda) iterator.next();
            switch (cript.getSimbolo()){
                case "EUR": counterEur++; break;
                case "USD": counterUsd++; break;
                case "LIB": counterLib++; break;
            }
        }
        if(counterEur>counterUsd) {
            if (counterEur > counterLib) return "EUR";
            else return "LIB";
        }else {
            if (counterUsd > counterLib) return "USD";
            else return "LIB";
        }
    }


}
