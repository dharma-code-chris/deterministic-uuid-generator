package com.dharmacode.duc;

import com.google.common.primitives.Longs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DeterministicUUIDConverter {

    private final byte[] seedHash;

    public DeterministicUUIDConverter() {
        seedHash = null;
    }

    public DeterministicUUIDConverter(String seed) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsae) {
            throw new InternalError("MD5 not supported", nsae);
        }
        seedHash = md.digest(seed.getBytes());
    }

    public UUID convert(Long id) {

        byte[] idBytes = Longs.toByteArray(id);

        if (seedHash != null) {
            // XOR each byte with the seed hash
            for (int i = 0; i < 8; i++) {
                idBytes[i] ^= seedHash[i];
            }
            for (int i = 8; i < 16; i++) {
                idBytes[i - 8] ^= seedHash[i];
            }
        }

        return UUID.nameUUIDFromBytes(idBytes);
    }

}
