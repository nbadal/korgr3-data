package com.nbadal.libr3;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ByteChunkTest extends TestCase {

    private static final byte[] ENCODED_SET = {
            0b01001110,
            0b00101101,
            0b01110011,
            0b01001000,
            0b00110000,
            0b01011111,
            0b01110101,
            0b01010110
    };
    private static final byte[] DECODED_SET = {
            0b00101101,
            (byte) 0b11110011,
            (byte) 0b11001000,
            (byte) 0b10110000,
            0b01011111,
            0b01110101,
            (byte) 0b11010110
    };
    private static final byte[] ENCODED_CHUNK;
    private static final byte[] DECODED_CHUNK;
    static {
        ENCODED_CHUNK = new byte[ENCODED_SET.length*2];
        DECODED_CHUNK = new byte[DECODED_SET.length*2];
        System.arraycopy(ENCODED_SET, 0, ENCODED_CHUNK, 0, ENCODED_SET.length);
        System.arraycopy(ENCODED_SET, 0, ENCODED_CHUNK, ENCODED_SET.length, ENCODED_SET.length);
        System.arraycopy(DECODED_SET, 0, DECODED_CHUNK, 0, DECODED_SET.length);
        System.arraycopy(DECODED_SET, 0, DECODED_CHUNK, DECODED_SET.length, DECODED_SET.length);
    }

    @Test
    public void testBitsFrom() {
        assertEquals(0b1101010, ByteChunk.bitsFrom((byte)0b1101010, 0, 7));
        assertEquals(0b1010, ByteChunk.bitsFrom((byte)0b1101010, 2, 5));
        assertEquals(0b0101, ByteChunk.bitsFrom((byte)0b1101010, 1, 4));
        assertEquals(0b1010, ByteChunk.bitsFrom((byte) 0b1101010, 0, 3));
        assertEquals(0b1, ByteChunk.bitsFrom((byte)0b1101010, 1, 1));
    }

    @Test
    public void testDecodeDumpSet() {
        Assert.assertArrayEquals(DECODED_SET, ByteChunk.decodeDumpSet(ENCODED_SET));
    }

    @Test
    public void testEncodeDumpSet() {
        Assert.assertArrayEquals(ENCODED_SET, ByteChunk.encodeDumpSet(DECODED_SET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecode_rejectsLargeArray() {
        ByteChunk.decodeDumpSet(new byte[9]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecode_rejectsSmallArray() {
        ByteChunk.decodeDumpSet(new byte[7]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEncode_rejectsLargeArray() {
        ByteChunk.encodeDumpSet(new byte[8]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEncode_rejectsSmallArray() {
        ByteChunk.encodeDumpSet(new byte[6]);
    }

    @Test
    public void testDecodeChunk() {
        Assert.assertArrayEquals(DECODED_CHUNK, ByteChunk.decodeDump(ENCODED_CHUNK));
    }

    @Test
    public void testEncodeChunk() {
        Assert.assertArrayEquals(ENCODED_CHUNK, ByteChunk.encodeDump(DECODED_CHUNK));
    }
}