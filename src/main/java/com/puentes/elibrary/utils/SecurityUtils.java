package com.puentes.elibrary.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/**
 * Created by Matthew on 3/27/2018.
 *
 * @author Matthew
 */
public abstract class SecurityUtils {

    private SecurityUtils() {
        throw new AssertionError("Non Instantiable");
    }

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom("SALT".getBytes()));
    }
}
