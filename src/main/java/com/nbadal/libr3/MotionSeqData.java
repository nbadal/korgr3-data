package com.nbadal.libr3;

import com.nbadal.libr3.params.KeySync;

public class MotionSeqData extends ByteChunk {
    public MotionSeqData(byte[] data) {
        super(data);
    }

    public static final Param<Boolean> SEQ_ON = Param.make(Boolean.class, 0, 7, 7);
    public static final Param<SequenceType> SEQ_TYPE = Param.make(SequenceType.class, 0, 4, 5);
    public static final Param<Byte> LAST_STEP = Param.make(Byte.class, 0, 0, 3);
    public static final Param<KeySync> KEYSYNC = Param.make(KeySync.class, 1, 4, 5);
    public static final Param<Resolution> RESOLUTION = Param.make(Resolution.class, 1, 0, 3);
    public static final Param<SequenceParameterData> SEQUENCE = Param.make(SequenceParameterData.class, 2, 19);


    public enum SequenceType {
        FORWARD, REVERSE, ALT1, ALT2, ONE_SHOT
    }

    public enum Resolution {
        FOURTYEIGHTH, THIRTYSECOND, TWENTYFOURTH, SIXTEENTH, TWELFTH, THREE_THIRTYSECONDS, EIGHTH, SIXTH,
        THREE_SIXTEENTHS, QUARTER, THIRD, THREE_EIGHTHS, HALF, TWO_THIRDS, THREE_QUARTER, WHOLE
    }
}
