package com.nbadal.libr3;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramDataTest {
    ProgramData pd;

    @Before
    public void setup() {
        pd = new ProgramData(ByteChunk.decodeDump(ExampleChunks.CURR_PROG_DATA));
    }

    @Test
    public void testParams() {
        Assert.assertEquals("MonoSynt", pd.get(ProgramData.NAME));
        Assert.assertEquals(ProgramData.VoiceMode.SINGLE, pd.get(ProgramData.VOICEMODE));
        Assert.assertEquals(ProgramData.TimbreSelect.TIMB1, pd.get(ProgramData.ARPTIMBRE));
    }

    @Test
    public void testDataParams() {
        Assert.assertNotNull(pd.get(ProgramData.TIMBRE1DATA));
    }
}