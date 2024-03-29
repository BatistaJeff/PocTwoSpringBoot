package com.demo.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {

    private static final String SENHA = "123456";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Test
    public void testSenhaNula() throws Exception {
        assertNull(PasswordUtils.geradorBCrypt(null));
    }

    @Test
    public void testGerarHashSenha() throws Exception {
        String hash = PasswordUtils.geradorBCrypt(SENHA);

        assertTrue(bCryptEncoder.matches(SENHA, hash));
    }

}