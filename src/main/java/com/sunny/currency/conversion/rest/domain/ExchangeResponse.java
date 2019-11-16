package com.sunny.currency.conversion.rest.domain;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class ExchangeResponse {

    private boolean success;

    private long timestamp;

    private String base;

    private Date date;

    @Override
    public String toString() {
        return "ExchangeResponse{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeResponse that = (ExchangeResponse) o;
        return success == that.success &&
                timestamp == that.timestamp &&
                Objects.equals(base, that.base) &&
                Objects.equals(date, that.date) &&
                Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, timestamp, base, date, rates);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    private Map<String,String> rates;

}
