package com.sunny.currency.conversion.rest;

import com.sunny.currency.conversion.rest.domain.CurrencyConversionResponse;
import com.sunny.currency.conversion.rest.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @RequestMapping(value = "/convert",method = RequestMethod.GET)
    public CurrencyConversionResponse convertCurrency(@RequestParam("baseCurrency") String baseCurrency,
                                                      @RequestParam("targetCurrency") String targetCurrency,
                                                      @RequestHeader("apiKey") String apiKey){
        System.out.println(apiKey);
        return currencyConversionService.convert(baseCurrency,targetCurrency,apiKey);
    }

}
