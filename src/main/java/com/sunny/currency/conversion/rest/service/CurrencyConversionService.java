package com.sunny.currency.conversion.rest.service;

import com.sunny.currency.conversion.rest.domain.CurrencyConversionResponse;
import com.sunny.currency.conversion.rest.domain.ExchangeResponse;
import com.sunny.currency.conversion.rest.domain.Request;
import com.sunny.currency.conversion.rest.domain.Result;
import com.sunny.currency.conversion.rest.external.FixerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class CurrencyConversionService {

    @Autowired
    FixerServiceClient fixerServiceClient;

    public CurrencyConversionResponse convert(String baseCurrency,String targetCurrency,String apiKey){
        CurrencyConversionResponse currencyConversionResponse = null;
        if(baseCurrency != null
                && targetCurrency != null
                && apiKey != null){
            ExchangeResponse exchangeResponse = fixerServiceClient.convert(baseCurrency,targetCurrency,apiKey);
            if(exchangeResponse != null && exchangeResponse.isSuccess()){
                System.out.println(exchangeResponse);
                currencyConversionResponse = new CurrencyConversionResponse();
                currencyConversionResponse.setBaseCurrency(baseCurrency);
                currencyConversionResponse.setTargetCurrency(targetCurrency);
                SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String date = isoFormat.format(new Date(exchangeResponse.getTimestamp()*1000L));
                currencyConversionResponse.setTimeStamp(date);
                Map<String,String> rates = exchangeResponse.getRates();
                if(rates != null
                        && !rates.isEmpty() && rates.containsKey(targetCurrency)){
                    BigDecimal exchangeRate = new BigDecimal(rates.get(targetCurrency));
                    exchangeRate = exchangeRate.setScale(5,BigDecimal.ROUND_DOWN);
                    currencyConversionResponse.setExchangeRate(exchangeRate);
                }
            }
        }
        return  currencyConversionResponse;
    }


}
