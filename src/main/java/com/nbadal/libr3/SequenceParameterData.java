package com.nbadal.libr3;

public class SequenceParameterData extends ByteChunk {
    public SequenceParameterData(byte[] data) {
        super(data);
    }

    public static final Param<SequenceDest> KNOB = Param.make(SequenceDest.class, 0);
    public static final Param<MotionType> MOTION_TYPE = Param.make(MotionType.class, 1, 7, 7);
    public static final Param<Byte[]> STEPS = Param.make(Byte[].class, 2, 17, new ParamConverter<Byte[]>() {
        @Override
        public Byte[] decode(Param<Byte[]> param, byte[] raw) {
            Byte[] vals = new Byte[raw.length];
            System.arraycopy(raw, 0, vals, 0, raw.length);
            for(int i = 0; i < raw.length; i++) {
                vals[i] = (byte)(vals[i] - 64);
            }
            return vals;
        }

        @Override
        public byte[] encode(Param<Byte[]> param, Byte[] value) {
            return new byte[0];
        }
    });

    public enum SequenceDest {
        NONE, PITCH, PORTAMENTO, OSC1CTRL1, OSC1CTRL2, OSC2SEMI, OSC2TUNE, OSC1LEVEL, OSC2LEVEL, NOISELEVEL,
        FILT1CUTOFF, FILT1RESONANCE, FILT1TYPE, FILT1EG1INT, FILT1KBDTRACK, FILT2CUTOFF, FILT2RESONANCE, FILT2EG1INT, FILT2KBDTRACK, AMPLEVEL1,
        PANPOT, DRIVE, EG1ATTACK, EG1SUSTAIN, EG1RELEASE, EG2ATTACK, EG2DECAY, EG2SUSTAIN, EG2RELEASE,
        EG3ATTACK, EG3DECAY, EG3RELEASE, LFO1FREQ, LFO2FREQ, PATCH1INT, PATCH2INT, PATCH3INT, PATCH4INT,
        PATCH5INT, PATCH6INT
    }

    public enum MotionType {
        SMOOTH, STEP
    }
}
