package org.appstudio.serviceprovider.service;

import java.security.SecureRandom;
import java.util.Random;

public class NameGenerator {

    private static final Random RANDOM = new SecureRandom();

    private static final char[] CHARS = new char[36];

    static {
        int i = 0;
        // [0..9]
        for (int c = 48; c <= 57; c++) {
            CHARS[i++] = (char) c;
        }
        // [a-z]
        for (int c = 97; c <= 122; c++) {
            CHARS[i++] = (char) c;
        }
    }

    public static String generate(String prefix, int length) {
        return generate(prefix, null, length);
    }

    public static String generate(String prefix, String suffix, int length) {
        int bufLength = length;
        if (prefix != null) {
            bufLength += prefix.length();
        }
        if (suffix != null) {
            bufLength += suffix.length();
        }
        final StringBuilder buf = new StringBuilder(bufLength);
        if (prefix != null && !prefix.isEmpty()) {
            buf.append(prefix);
        }
        for (int i = 0; i < length; i++) {
            buf.append(CHARS[RANDOM.nextInt(CHARS.length)]);
        }
        if (suffix != null && !suffix.isEmpty()) {
            buf.append(suffix);
        }
        return buf.toString();
    }

    private NameGenerator() {}
}
