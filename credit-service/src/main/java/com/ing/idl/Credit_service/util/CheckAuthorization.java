package com.ing.idl.Credit_service.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // This annotation can be applied to methods
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface CheckAuthorization {
    String[] allowedCountries() default {}; // List of allowed country codes
    String[] blacklistedIps() default {}; // List of blacklisted IP addresses
}
