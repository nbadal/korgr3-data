package com.nbadal.libr3;

public class InsertFxData extends ByteChunk {
    public InsertFxData(byte[] data) {
        super(data);
    }

    // the MIDI impl doc has some odd typos, looks like one column of chars shifted over to the next one
    // this *should* be accurate to the hardware
    public static final Short[] LOW_FREQS = {
            20, 22, 25, 28, 32, 36, 40, 45, 50, 56,
            63, 71, 80, 90, 100, 112, 125, 140, 160, 180,
            200, 224, 250, 280, 315, 400, 450, 500, 560, 630,
            710, 800, 900, 1000
    };

    public static final Short[] HI_FREQS = {
            1000, 1120, 1250, 1400, 1600, 1800, 2000, 2240, 2500, 2800,
            3150, 4000, 4500, 5000, 5600, 6300, 7100, 8000, 9000, 10000,
            11200, 12500, 14000, 16000, 18000, 20000
    };

    // FX 1
    public static final Param<Effect> FX1EFFECT = Param.make(Effect.class, 0);
    public static final Param<Byte> FX1KNOBASSGN = Param.make(Byte.class, 2, 0, 4);
    public static final Param<Byte> FX1PARAM1 = Param.make(Byte.class, 4);
    public static final Param<Byte> FX1PARAM2 = Param.make(Byte.class, 5);
    public static final Param<Byte> FX1PARAM3 = Param.make(Byte.class, 6);
    public static final Param<Byte> FX1PARAM4 = Param.make(Byte.class, 7);
    public static final Param<Byte> FX1PARAM5 = Param.make(Byte.class, 8);
    public static final Param<Byte> FX1PARAM6 = Param.make(Byte.class, 9);
    public static final Param<Byte> FX1PARAM7 = Param.make(Byte.class, 10);
    public static final Param<Byte> FX1PARAM8 = Param.make(Byte.class, 11);
    public static final Param<Byte> FX1PARAM9 = Param.make(Byte.class, 12);
    public static final Param<Byte> FX1PARAM10 = Param.make(Byte.class, 13);
    public static final Param<Byte> FX1PARAM11 = Param.make(Byte.class, 14);
    public static final Param<Byte> FX1PARAM12 = Param.make(Byte.class, 15);
    public static final Param<Byte> FX1PARAM13 = Param.make(Byte.class, 16);
    public static final Param<Byte> FX1PARAM14 = Param.make(Byte.class, 17);
    public static final Param<Byte> FX1PARAM15 = Param.make(Byte.class, 18);
    public static final Param<Byte> FX1PARAM16 = Param.make(Byte.class, 19);
    public static final Param<Byte> FX1PARAM17 = Param.make(Byte.class, 20);
    public static final Param<Byte> FX1PARAM18 = Param.make(Byte.class, 21);
    public static final Param<Byte> FX1PARAM19 = Param.make(Byte.class, 22);
    public static final Param<Byte> FX1PARAM20 = Param.make(Byte.class, 23);
    // FX 2
    public static final Param<Effect> FX2EFFECT = Param.make(Effect.class, 24);
    public static final Param<Byte> FX2KNOBASSGN = Param.make(Byte.class, 26, 0, 4);
    public static final Param<Byte> FX2PARAM1 = Param.make(Byte.class, 28);
    public static final Param<Byte> FX2PARAM2 = Param.make(Byte.class, 29);
    public static final Param<Byte> FX2PARAM3 = Param.make(Byte.class, 30);
    public static final Param<Byte> FX2PARAM4 = Param.make(Byte.class, 31);
    public static final Param<Byte> FX2PARAM5 = Param.make(Byte.class, 32);
    public static final Param<Byte> FX2PARAM6 = Param.make(Byte.class, 33);
    public static final Param<Byte> FX2PARAM7 = Param.make(Byte.class, 34);
    public static final Param<Byte> FX2PARAM8 = Param.make(Byte.class, 35);
    public static final Param<Byte> FX2PARAM9 = Param.make(Byte.class, 36);
    public static final Param<Byte> FX2PARAM10 = Param.make(Byte.class, 37);
    public static final Param<Byte> FX2PARAM11 = Param.make(Byte.class, 38);
    public static final Param<Byte> FX2PARAM12 = Param.make(Byte.class, 39);
    public static final Param<Byte> FX2PARAM13 = Param.make(Byte.class, 40);
    public static final Param<Byte> FX2PARAM14 = Param.make(Byte.class, 41);
    public static final Param<Byte> FX2PARAM15 = Param.make(Byte.class, 42);
    public static final Param<Byte> FX2PARAM16 = Param.make(Byte.class, 43);
    public static final Param<Byte> FX2PARAM17 = Param.make(Byte.class, 44);
    public static final Param<Byte> FX2PARAM18 = Param.make(Byte.class, 45);
    public static final Param<Byte> FX2PARAM19 = Param.make(Byte.class, 46);
    public static final Param<Byte> FX2PARAM20 = Param.make(Byte.class, 47);
    // EQ
    public static final Param<Short> EQ_LOWFREQ = Param.make(Short.class, 48, new ParamConverter.ArrayConverter<>(LOW_FREQS));
    public static final Param<Byte> EQ_LOWGAIN = Param.make(Byte.class, 49, new ParamConverter.OffsetConverter(-64));
    public static final Param<Short> EQ_HIFREQ = Param.make(Short.class, 50, new ParamConverter.ArrayConverter<>(HI_FREQS));
    public static final Param<Byte> EQ_HIGAIN = Param.make(Byte.class, 51, new ParamConverter.OffsetConverter(-64));


    public enum Effect {
        NONE, ST_COMPRESSOR, ST_LIMITER, ST_GATE, ST_FILTER, ST_WAH, ST_BANDEQ, DISTORTION, CABINET_SIMLTR,
        TUBE_PREAMP_SIM, ST_DECIMATOR, REVERB, EARLY_REFLECT, LCR_DELAY, ST_DELAY, AUTO_PAN_DELAY, ST_AUTO_PAN_DELAY,
        MOD_DELAY, ST_MOD_DELAY, TAPE_ECHO, ST_CHORUS, ENSEMBLE, ST_FLANGER, ST_PHASER, ST_TREMOLO, ST_RING_MOD,
        PITCH_SHIFT, GRAIN_SHIFT, ST_VIBRATO, ROTARY_SPEAKER, TALKING_MOD
    }


}
