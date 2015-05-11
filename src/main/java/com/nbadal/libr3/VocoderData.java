package com.nbadal.libr3;

// TODO: Improve param/class names.
//     Used names directly from MIDI docs table, there's probably clearer names we could use.
public class VocoderData extends ByteChunk {
    public VocoderData(byte[] data) {
        super(data);
    }

    public static final Param<Boolean> ENABLED = Param.make(Boolean.class, 0, 7, 7);
    public static final Param<Source> SOURCE = Param.make(Source.class, 0, 6, 6);
    public static final Param<Boolean> HPF_ENABLED = Param.make(Boolean.class, 0, 5, 5);
    public static final Param<FormantDataPlay> FORMANT_DATA_PLAY = Param.make(FormantDataPlay.class, 0, 4, 4);
    public static final Param<Select> SELECT = Param.make(Select.class, 0, 0, 1);
    public static final Param<Byte> GATE_SENS = Param.make(Byte.class, 1);
    public static final Param<Byte> THRESHOLD = Param.make(Byte.class, 2);
    public static final Param<Byte> HPF_LEVEL = Param.make(Byte.class, 3);
    public static final Param<Byte> DIRECT_LEVEL = Param.make(Byte.class, 4);
    public static final Param<Byte> TIMBRE1_LEVEL = Param.make(Byte.class, 5);
    public static final Param<Byte> INPUT1_LEVEL = Param.make(Byte.class, 6);
    public static final Param<Byte> VOCODER_LEVEL = Param.make(Byte.class, 7);
    public static final Param<Byte> BAND1_PANPOT = Param.make(Byte.class, 8);
    public static final Param<Byte> BAND1_LEVEL = Param.make(Byte.class, 9);
    public static final Param<Byte> BAND2_PANPOT = Param.make(Byte.class, 10);
    public static final Param<Byte> BAND2_LEVEL = Param.make(Byte.class, 11);
    public static final Param<Byte> BAND3_PANPOT = Param.make(Byte.class, 12);
    public static final Param<Byte> BAND3_LEVEL = Param.make(Byte.class, 13);
    public static final Param<Byte> BAND4_PANPOT = Param.make(Byte.class, 14);
    public static final Param<Byte> BAND4_LEVEL = Param.make(Byte.class, 15);
    public static final Param<Byte> BAND5_PANPOT = Param.make(Byte.class, 16);
    public static final Param<Byte> BAND5_LEVEL = Param.make(Byte.class, 17);
    public static final Param<Byte> BAND6_PANPOT = Param.make(Byte.class, 18);
    public static final Param<Byte> BAND6_LEVEL = Param.make(Byte.class, 19);
    public static final Param<Byte> BAND7_PANPOT = Param.make(Byte.class, 20);
    public static final Param<Byte> BAND7_LEVEL = Param.make(Byte.class, 21);
    public static final Param<Byte> BAND8_PANPOT = Param.make(Byte.class, 22);
    public static final Param<Byte> BAND8_LEVEL = Param.make(Byte.class, 23);
    public static final Param<Byte> BAND9_PANPOT = Param.make(Byte.class, 24);
    public static final Param<Byte> BAND9_LEVEL = Param.make(Byte.class, 25);
    public static final Param<Byte> BAND10_PANPOT = Param.make(Byte.class, 26);
    public static final Param<Byte> BAND10_LEVEL = Param.make(Byte.class, 27);
    public static final Param<Byte> BAND11_PANPOT = Param.make(Byte.class, 28);
    public static final Param<Byte> BAND11_LEVEL = Param.make(Byte.class, 29);
    public static final Param<Byte> BAND12_PANPOT = Param.make(Byte.class, 30);
    public static final Param<Byte> BAND12_LEVEL = Param.make(Byte.class, 31);
    public static final Param<Byte> BAND13_PANPOT = Param.make(Byte.class, 32);
    public static final Param<Byte> BAND13_LEVEL = Param.make(Byte.class, 33);
    public static final Param<Byte> BAND14_PANPOT = Param.make(Byte.class, 34);
    public static final Param<Byte> BAND14_LEVEL = Param.make(Byte.class, 35);
    public static final Param<Byte> BAND15_PANPOT = Param.make(Byte.class, 36);
    public static final Param<Byte> BAND15_LEVEL = Param.make(Byte.class, 37);
    public static final Param<Byte> BAND16_PANPOT = Param.make(Byte.class, 38);
    public static final Param<Byte> BAND16_LEVEL = Param.make(Byte.class, 39);
    public static final Param<Byte> FILTER_SHIFT = Param.make(Byte.class, 40, 4, 6, new ParamConverter.OffsetConverter(-2));
    public static final Param<FcModSource> FC_MOD_SOURCE = Param.make(FcModSource.class, 40, 0, 3);
    public static final Param<Byte> FM_SELECT = Param.make(Byte.class, 41);
    public static final Param<Byte> CUTOFF_OFFSET = Param.make(Byte.class, 42, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> RESONANCE = Param.make(Byte.class, 43);
    public static final Param<Byte> FC_MOD_INTENSITY = Param.make(Byte.class, 44, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> EF_SENS = Param.make(Byte.class, 45);
    public static final Param<Integer> FORMANT_BAND1 = Param.make(Integer.class, 46, 47);
    public static final Param<Integer> FORMANT_BAND2 = Param.make(Integer.class, 48, 49);
    public static final Param<Integer> FORMANT_BAND3 = Param.make(Integer.class, 50, 51);
    public static final Param<Integer> FORMANT_BAND4 = Param.make(Integer.class, 52, 53);
    public static final Param<Integer> FORMANT_BAND5 = Param.make(Integer.class, 54, 55);
    public static final Param<Integer> FORMANT_BAND6 = Param.make(Integer.class, 56, 57);
    public static final Param<Integer> FORMANT_BAND7 = Param.make(Integer.class, 58, 59);
    public static final Param<Integer> FORMANT_BAND8 = Param.make(Integer.class, 60, 61);
    public static final Param<Integer> FORMANT_BAND9 = Param.make(Integer.class, 62, 63);
    public static final Param<Integer> FORMANT_BAND10 = Param.make(Integer.class, 64, 65);
    public static final Param<Integer> FORMANT_BAND11 = Param.make(Integer.class, 66, 67);
    public static final Param<Integer> FORMANT_BAND12 = Param.make(Integer.class, 68, 69);
    public static final Param<Integer> FORMANT_BAND13 = Param.make(Integer.class, 70, 71);
    public static final Param<Integer> FORMANT_BAND14 = Param.make(Integer.class, 72, 73);
    public static final Param<Integer> FORMANT_BAND15 = Param.make(Integer.class, 74, 75);
    public static final Param<Integer> FORMANT_BAND16 = Param.make(Integer.class, 76, 77);

    public enum Source {
        AUDIO_IN_SRC, FORMANT_REC_DATA
    }

    public enum FormantDataPlay {
        FREE_RUN, TRIG_RESET
    }

    public enum Select {
        INPUT1, TIMB2
    }

    public enum FcModSource {
        EG1, EG2, EG3, LFO1, LFO2, VELOCITY, PITCH_BEND, MOD_WHEEL, KEY_TRACK, MIDI1, MIDI2, MIDI3
    }
}
