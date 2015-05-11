package com.nbadal.libr3;

public class ProgramData extends ByteChunk {

    public ProgramData(byte[] data) {
        super(data);
    }

    public static final Param<String> NAME = Param.make(String.class, 0, 7);
    public static final Param<VoiceMode> VOICEMODE = Param.make(VoiceMode.class, 8);
    public static final Param<TimbreSelect> ARPTIMBRE = Param.make(TimbreSelect.class, 8);
    public static final Param<KnobAssign> KNOB1 = Param.make(KnobAssign.class, 9);
    public static final Param<KnobAssign> KNOB2 = Param.make(KnobAssign.class, 10);
    public static final Param<KnobAssign> KNOB3 = Param.make(KnobAssign.class, 11);
    public static final Param<KnobAssign> KNOB4 = Param.make(KnobAssign.class, 12);
    public static final Param<Byte> TIMBRE2MIDICH = Param.make(Byte.class, 13);
    public static final Param<Byte> CENTERKEY = Param.make(Byte.class, 14);
    public static final Param<Byte> OCTAVESW = Param.make(Byte.class, 15);
    public static final Param<Byte> CATEGORYNUM = Param.make(Byte.class, 15);
    public static final Param<TimbreData> TIMBRE1DATA = Param.make(TimbreData.class, 16, 179);
    public static final Param<TimbreData> TIMBRE2DATA = Param.make(TimbreData.class, 180, 343);
    public static final Param<VocoderData> VOCODERDATA = Param.make(VocoderData.class, 344, 421);
//    public static final Parameter<MasterFxData> MASTERFX = Param.make(MasterFxData.class, 422, 443);
    public static final Param<Integer> TEMPO = Param.make(Integer.class, 444, 445);
    public static final Param<Boolean> ARPON = Param.make(Boolean.class, 446);
    public static final Param<Boolean> KEYSYNC = Param.make(Boolean.class, 446);
//    public static final Parameter<ArpeggioData> ARPDATA = Param.make(ArpeggioData.class, 448, 455);


    public enum VoiceMode {
        SINGLE, LAYER, SPLIT, MULTI
    }

    public enum TimbreSelect {
        TIMB1, TIMB2, TIMB1_2
    }

}
