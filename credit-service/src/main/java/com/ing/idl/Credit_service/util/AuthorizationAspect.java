package com.ing.idl.Credit_service.util;

import lombok.Data;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class AuthorizationAspect {

    @Before("@annotation(checkAuthorization)")
    public void AuthorizationCheck(CheckAuthorization checkAuthorization) {
        String myIp = getMyIp();
        if (Arrays.asList(checkAuthorization.blacklistedIps()).contains(myIp)) {
            throw new RuntimeException("Access denied: IP is blacklisted");
        }

        String country = getCountryByIp(myIp);
        if (checkAuthorization.allowedCountries().length > 0 && !Arrays.asList(checkAuthorization.allowedCountries()).contains(country)) {
            throw new RuntimeException("Access denied: Country not authorized");
        }

    }

    private String getMyIp(){
        return "197.30.128.195";
    }

    private String getCountryByIp(String ip){
        String apiUrl = "http://ip-api.com/json/" + ip;
        RestTemplate restTemplate = new RestTemplate();
        IpApiResponse response = restTemplate.getForObject(apiUrl, IpApiResponse.class);
        if (response != null && Objects.equals(response.getStatus(), "success")) {
            return response.getCountryCode();
        }
        throw new RuntimeException("Could not determine the country for IP: " + ip);
    }

    @Data
    private static class IpApiResponse{
        private String status;
        private String countryCode;
    }
}
