package com.example.demo.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/imagekit")
@CrossOrigin(origins = "*")
public class ImageKitController {

	private static final String IMAGEKIT_PRIVATE_KEY = "private_yuU2YJJ0LSlHGUnMrnHFXF3mwHQ=";

    @GetMapping("/auth")
    public Map<String, Object> getAuth() {

        try {
            String token = UUID.randomUUID().toString();
            long expire = System.currentTimeMillis() / 1000 + 2400;

            String signature = generateSignature(token, expire);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("expire", expire);
            response.put("signature", signature);

            return response;

        } catch (Exception e) {
            throw new RuntimeException("ImageKit auth failed", e);
        }
    }

    private String generateSignature(String token, long expire) throws Exception {
        String data = token + expire;
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(
            IMAGEKIT_PRIVATE_KEY.getBytes(StandardCharsets.UTF_8),
            "HmacSHA1"));
        return Base64.getEncoder().encodeToString(mac.doFinal(data.getBytes()));
    }
}
