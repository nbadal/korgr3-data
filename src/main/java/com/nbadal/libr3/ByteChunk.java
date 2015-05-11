package com.nbadal.libr3;

import java.util.Arrays;

public abstract class ByteChunk {

    /** A midi-decoded byte array */
    protected byte[] data;

    public ByteChunk(byte[] data) {
        this.data = data;
    }


    public byte[] getRaw(Param param) {
        byte[] bytes = Arrays.copyOfRange(data, param.startByte, param.endByte+1);
        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = bitsFrom(bytes[i], param.startBit, param.endBit);
        }
        return bytes;
    }

    public <T> T get(Param<T> param) {
        return param.converter.decode(param, getRaw(param));
    }


    /**
     * @return value from bits in value specified by start and end (inclusive)
     */
    public static byte bitsFrom(byte value, int startBit, int endBit) {
        return (byte)((value >> startBit) % (1 << (endBit-startBit+1)));
    }

    public static byte[] decodeDump(final byte[] encoded) {
        if(encoded.length % 8 != 0) {
            throw new IllegalArgumentException("Encoded array must contain a multiple of 8 bytes");
        }
        final int setCount = encoded.length / 8;
        byte[] decoded = new byte[setCount * 7];
        for(int i = 0; i < setCount; i++) {
            byte[] set = Arrays.copyOfRange(encoded, i * 8, i * 8 + 8);
            System.arraycopy(decodeDumpSet(set), 0, decoded, i * 7, 7);
        }
        return decoded;
    }

    public static byte[] encodeDump(final byte[] decoded) {
        if(decoded.length % 7 != 0) {
            throw new IllegalArgumentException("Decoded array must contain a multiple of 7 bytes");
        }
        final int setCount = decoded.length / 7;
        byte[] encoded = new byte[setCount * 8];
        for(int i = 0; i < setCount; i++) {
            byte[] set = Arrays.copyOfRange(decoded, i * 7, i * 7 + 7);
            System.arraycopy(encodeDumpSet(set), 0, encoded, i * 8, 8);
        }
        return encoded;
    }

    /**
     * Decodes a 8-byte x 7-bit set into a 7-byte x 8-bit set
     */
    public static byte[] decodeDumpSet(final byte[] encoded) {
        if(encoded.length != 8) {
            throw new IllegalArgumentException("Decoded array must contain 8 bytes");
        }
        byte[] decoded = new byte[7];
        System.arraycopy(encoded, 1, decoded, 0, 7);
        for(int i = 0; i < 7; i++) {
            if((encoded[0] & (1 << i)) != 0) {
                decoded[i] |= 1 << 7;
            }
        }
        return decoded;
    }

    /**
     * Encodes a 7-byte x 8-bit set into a 8-byte x 7-bit set
     */
    public static byte[] encodeDumpSet(final byte[] decoded) {
        if(decoded.length != 7) {
            throw new IllegalArgumentException("Encoded array must contain 7 bytes");
        }
        byte[] encoded = new byte[8];
        System.arraycopy(decoded, 0, encoded, 1, 7);
        for(int i = 0; i < 7; i++) {
            if((decoded[i] & (1 << 7)) != 0) {
                encoded[0] |= 1 << i;
            }
            encoded[i+1] &= ~(1 << 7);
        }
        return encoded;
    }
}
