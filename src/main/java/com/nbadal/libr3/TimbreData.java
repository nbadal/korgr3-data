package com.nbadal.libr3;

public class TimbreData extends ByteChunk {
    public TimbreData(byte[] data) {
        super(data);
    }

    public static final Param<TimbreProgramData> PROGRAMDATA = Param.make(TimbreProgramData.class, 0, 91);
    public static final Param<InsertFxData> INSERTFXDATA = Param.make(InsertFxData.class, 92, 143);
    public static final Param<MotionSeqData> MOTIONSEQDATA = Param.make(MotionSeqData.class, 144, 163);

}
