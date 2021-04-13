package com.carlos.artgallery.models.security;

import java.security.Key;

import io.jsonwebtoken.impl.crypto.MacProvider;

public class SecurityConstants {
	public static final Key SECRET_KEY = MacProvider.generateKey();
}
