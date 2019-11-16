package com.sunny.currency.conversion.rest.external;

import com.sunny.currency.conversion.rest.domain.CurrencyConversionResponse;
import com.sunny.currency.conversion.rest.domain.ExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Component
public class FixerServiceClient {

    private static final String ACCESS_KEY_HEADER_KEY = "access_key";

    private static final String FIXER_BASE_URL = "http://data.fixer.io/api/latest";

    @Autowired
    RestTemplate restTemplate;

    public ExchangeResponse convert(String baseCurrency, String targetCurrency, String apiKey){
        return invokeExternalAPI(baseCurrency,targetCurrency,apiKey);
    }

    private ExchangeResponse invokeExternalAPI(String baseCurrency,
                                              String targetCurrency,
                                              String apiKey){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ExchangeResponse> entity = new HttpEntity<ExchangeResponse>(httpHeaders);
        ResponseEntity<ExchangeResponse> responseResponseEntity = restTemplate.exchange(createUrlWithQueryString(baseCurrency,targetCurrency,apiKey)
        , HttpMethod.GET,
                entity,ExchangeResponse.class);
        return responseResponseEntity.getBody();
    }

    private String createUrlWithQueryString(String baseCurrency,String targetCurrency,String apiKey){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FIXER_BASE_URL).
                queryParam("symbols",targetCurrency)
                .queryParam("access_key",apiKey);
        return builder.toUriString();
    }

}
