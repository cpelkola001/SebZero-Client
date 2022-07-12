package com.arlania;


// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

@SuppressWarnings("all")
final class TextInput {

    public static String decodeToString(int length, Stream stream) {
        int pointer = 0;
        for (int l = 0; l < length; l++) {
            int encodedLetter = stream.readUnsignedByte();
            decodedString[pointer++] = validChars[encodedLetter];
        }

        boolean capitalizeNext = true;
        for (int k1 = 0; k1 < pointer; k1++) {
            char c = decodedString[k1];
            //System.out.println("C: " + c + " at index " + k1);
            if (capitalizeNext && c >= 'a' && c <= 'z') {
                decodedString[k1] += '\uFFE0';
                capitalizeNext = false;
            }
            if (c == '.' || c == '!' || c == '?' || c == '|')
                capitalizeNext = true;
        }
        String str = new String(decodedString, 0, pointer);

        return str;
    }

    public static void appendToStream(String s, Stream stream) {
        if (s.length() > 80)
            s = s.substring(0, 80);
        s = s.toLowerCase();
        int next = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int charIndex = 0;
            for (int l = 0; l < validChars.length; l++) {
                if (c != validChars[l])
                    continue;
                charIndex = l;
                break;
            }

            stream.writeByte(charIndex);
        }
        ;
    }

    public static String processText(String s) {
        stream.currentOffset = 0;
        appendToStream(s, stream);
        int j = stream.currentOffset;
        stream.currentOffset = 0;
        String s1 = decodeToString(j, stream);
        return s1;
    }

    private static final char[] decodedString = new char[100];
    private static final Stream stream = new Stream(new byte[100]);
    private static final char[] validChars = {' ', 'e', 't', 'o', 'a', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!', '^', '|', '<', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '/', '@', '#', '+', '=', '\243', '$', '%', '"', '[', ']'};

}