package com.co.criptomoneda.criptomoneda.controller;

import com.co.criptomoneda.criptomoneda.model.Criptomoneda;
import com.co.criptomoneda.criptomoneda.services.ICriptomonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriptomonedaController {

    @Autowired
    private ICriptomonedaService iCriptomonedaService;

    @GetMapping("/criptomonedas")
    public List<Criptomoneda> getCriptomoneda(){return iCriptomonedaService.getCriptomoneda();}

    @PostMapping("/criptomoneda")
    public Boolean addCriptomoneda(@RequestBody Criptomoneda criptomoneda){
        return iCriptomonedaService.addCriptomoneda(criptomoneda);
    }

    @DeleteMapping("/criptomoneda/{idmoneda}/{simbolo}")
    public Boolean deleteCriptomoneda(@PathVariable int idmoneda,@PathVariable String simbolo){
        return iCriptomonedaService.deleteCriptomoneda(idmoneda,simbolo);
    }

    @GetMapping("/criptomoneda/high")
    public Criptomoneda getCriptomonedaHigh(){return iCriptomonedaService.higherValue();}

    @GetMapping("/criptomoneda/moreFrequent")
    public String getFrequenCurrency(){return iCriptomonedaService.moreUseCurrency();}
}
