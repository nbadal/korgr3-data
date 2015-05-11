package com.nbadal.libr3;

import com.nbadal.libr3.params.KeySync;

public class TimbreProgramData extends ByteChunk {

    public TimbreProgramData(byte[] data) {
        super(data);
    }

    // COMMON
    public static final Param<KnobAssign> KNOB1 = Param.make(KnobAssign.class, 0);
    public static final Param<KnobAssign> KNOB2 = Param.make(KnobAssign.class, 1);
    public static final Param<KnobAssign> KNOB3 = Param.make(KnobAssign.class, 2);
    public static final Param<KnobAssign> KNOB4 = Param.make(KnobAssign.class, 3);
    // VOICE
    public static final Param<UnisonVoice> UNISONVOICE = Param.make(UnisonVoice.class, 4, 0, 3);
    public static final Param<Byte> UNISONDETUNE = Param.make(Byte.class, 5);
    public static final Param<Byte> UNISONSPREAD = Param.make(Byte.class, 6);
    public static final Param<VoiceAssign> VOICEASSIGN = Param.make(VoiceAssign.class, 7, 6, 7);
    // PITCH
    public static final Param<Byte> ANALOGTUNING = Param.make(Byte.class, 9);
    public static final Param<Byte> TRANSPOSE = Param.make(Byte.class, 10, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> DETUNE = Param.make(Byte.class, 11, new ParamConverter.OffsetConverter(-64));
//    public static final Param<Short> VIBRATOINT = Param.make(Short.class, 12, new ParamConverter.ArrayConverter<Short>(VIBRATO_INTS));
    public static final Param<Byte> BENDRANGE = Param.make(Byte.class, 13, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> PORTAMENTOTIME = Param.make(Byte.class, 14);
    // OSC 1
    public static final Param<Osc1Mod> OSC1MOD = Param.make(Osc1Mod.class, 16, 4, 5);
    public static final Param<Osc1Wave> OSC1WAVE = Param.make(Osc1Wave.class, 16, 0, 3);
    public static final Param<Byte> OSC1WAVECTRL1 = Param.make(Byte.class, 17);
    public static final Param<Byte> OSC1WAVECTRL2 = Param.make(Byte.class, 18);
    public static final Param<DwgsWave> OSC1DWGS = Param.make(DwgsWave.class, 19);
    // OSC 2
    public static final Param<Osc2Mod> OSC2MOD = Param.make(Osc2Mod.class, 21, 4, 5);
    public static final Param<Osc2Wave> OSC2WAVE = Param.make(Osc2Wave.class, 21, 0, 1);
    public static final Param<Byte> OSC2SEMITONE = Param.make(Byte.class, 22);
    public static final Param<Byte> OSC2TUNE = Param.make(Byte.class, 23);
    // MIXER
    public static final Param<Byte> OSC1LVL = Param.make(Byte.class, 24);
    public static final Param<Byte> OSC2LVL = Param.make(Byte.class, 25);
    public static final Param<Byte> NOISELVL = Param.make(Byte.class, 26);
    // FILTER
    public static final Param<Filter2Type> FILTER2TYPE = Param.make(Filter2Type.class, 28, 4, 5);
    public static final Param<FilterRouting> FILTERROUTING = Param.make(FilterRouting.class, 28, 0, 1);
    public static final Param<Byte> FILTER1BAL = Param.make(Byte.class, 29);
    public static final Param<Byte> FILTER1CUTOFF = Param.make(Byte.class, 30);
    public static final Param<Byte> FILTER1RESO = Param.make(Byte.class, 31);
    public static final Param<Byte> FILTER1EG1INT = Param.make(Byte.class, 32, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> FILTER1KEYTRK = Param.make(Byte.class, 33, new ParamConverter.OffsetConverter(-64)); // TODO: return +/-2.00
    public static final Param<Byte> FILTER1VELOSENS = Param.make(Byte.class, 34, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> FILTER2CUTOFF = Param.make(Byte.class, 35);
    public static final Param<Byte> FILTER2RESO = Param.make(Byte.class, 36);
    public static final Param<Byte> FILTER2EG1INT = Param.make(Byte.class, 37, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> FILTER2KEYTRK = Param.make(Byte.class, 38, new ParamConverter.OffsetConverter(-64)); // TODO: return +/-2.00
    public static final Param<Byte> FILTER2VELOSENS = Param.make(Byte.class, 39, new ParamConverter.OffsetConverter(-64));
    // AMP
    public static final Param<Byte> AMPLVL = Param.make(Byte.class, 40);
    public static final Param<DrivePosition> DRIVEWSPOSITION = Param.make(DrivePosition.class, 41, 4, 5);
    public static final Param<WaveShape> WAVESHAPE = Param.make(WaveShape.class, 42, 0, 3);
    public static final Param<Byte> WSDEPTH = Param.make(Byte.class, 43);
    public static final Param<String> AMPPANPOT = Param.make(String.class, 44, new Panpot.ParamConverter());
    public static final Param<Byte> AMPKEYTRK = Param.make(Byte.class, 45, new ParamConverter.OffsetConverter(-64));
    public static final Param<Byte> PUNCHLVL = Param.make(Byte.class, 46);
    // EG1
    public static final Param<Byte> EG1ATTACK = Param.make(Byte.class, 48);
    public static final Param<Byte> EG1DECAY = Param.make(Byte.class, 49);
    public static final Param<Byte> EG1SUSTAIN = Param.make(Byte.class, 50);
    public static final Param<Byte> EG1RELEASE = Param.make(Byte.class, 51);
    public static final Param<Byte> EG1LVLVELSENS = Param.make(Byte.class, 52, new ParamConverter.OffsetConverter(-64));
    // EG2
    public static final Param<Byte> EG2ATTACK = Param.make(Byte.class, 54);
    public static final Param<Byte> EG2DECAY = Param.make(Byte.class, 55);
    public static final Param<Byte> EG2SUSTAIN = Param.make(Byte.class, 56);
    public static final Param<Byte> EG2RELEASE = Param.make(Byte.class, 57);
    public static final Param<Byte> EG2LVLVELSENS = Param.make(Byte.class, 58, new ParamConverter.OffsetConverter(-64));
    // EG3
    public static final Param<Byte> EG3ATTACK = Param.make(Byte.class, 60);
    public static final Param<Byte> EG3DECAY = Param.make(Byte.class, 61);
    public static final Param<Byte> EG3SUSTAIN = Param.make(Byte.class, 62);
    public static final Param<Byte> EG3RELEASE = Param.make(Byte.class, 63);
    public static final Param<Byte> EG3LVLVELSENS = Param.make(Byte.class, 64, new ParamConverter.OffsetConverter(-64));
    // LFO1
    public static final Param<LfoWave> LFO1WAVE = Param.make(LfoWave.class, 66, 0, 3);
    public static final Param<Byte> LFO1FREQ = Param.make(Byte.class, 67);
    public static final Param<Boolean> LFO1BPMSYNC = Param.make(Boolean.class, 68, 7, 7);
    public static final Param<KeySync> LFO1KEYSYNC = Param.make(KeySync.class, 68, 5, 6);
    public static final Param<LfoSyncNote> LFO1SYNCNOTE = Param.make(LfoSyncNote.class, 69, 0, 4);
    // LFO2
    public static final Param<LfoWave> LFO2WAVE = Param.make(LfoWave.class, 70, 0, 3);
    public static final Param<Byte> LFO2FREQ = Param.make(Byte.class, 71);
    public static final Param<Boolean> LFO2BPMSYNC = Param.make(Boolean.class, 72, 7, 7);
    public static final Param<KeySync> LFO2KEYSYNC = Param.make(KeySync.class, 72, 5, 6);
    public static final Param<LfoSyncNote> LFO2SYNCNOTE = Param.make(LfoSyncNote.class, 73, 0, 4);
    // PATCH
    public static final Param<PatchSrc> PATCH1SRC = Param.make(PatchSrc.class, 74);
    public static final Param<PatchDst> PATCH1DST = Param.make(PatchDst.class, 75);
    public static final Param<Byte> PATCH1INT = Param.make(Byte.class, 76, new ParamConverter.OffsetConverter(-64));
    public static final Param<PatchSrc> PATCH2SRC = Param.make(PatchSrc.class, 77);
    public static final Param<PatchDst> PATCH2DST = Param.make(PatchDst.class, 78);
    public static final Param<Byte> PATCH2INT = Param.make(Byte.class, 79, new ParamConverter.OffsetConverter(-64));
    public static final Param<PatchSrc> PATCH3SRC = Param.make(PatchSrc.class, 80);
    public static final Param<PatchDst> PATCH3DST = Param.make(PatchDst.class, 81);
    public static final Param<Byte> PATCH3INT = Param.make(Byte.class, 82, new ParamConverter.OffsetConverter(-64));
    public static final Param<PatchSrc> PATCH4SRC = Param.make(PatchSrc.class, 83);
    public static final Param<PatchDst> PATCH4DST = Param.make(PatchDst.class, 84);
    public static final Param<Byte> PATCH4INT = Param.make(Byte.class, 85, new ParamConverter.OffsetConverter(-64));
    public static final Param<PatchSrc> PATCH5SRC = Param.make(PatchSrc.class, 86);
    public static final Param<PatchDst> PATCH5DST = Param.make(PatchDst.class, 87);
    public static final Param<Byte> PATCH5INT = Param.make(Byte.class, 88, new ParamConverter.OffsetConverter(-64));
    public static final Param<PatchSrc> PATCH6SRC = Param.make(PatchSrc.class, 89);
    public static final Param<PatchDst> PATCH6DST = Param.make(PatchDst.class, 90);
    public static final Param<Byte> PATCH6INT = Param.make(Byte.class, 91, new ParamConverter.OffsetConverter(-64));

    public enum UnisonVoice {
        OFF, TWO_VOICE, THREE_VOICE, FOUR_VOICE
    }

    public enum VoiceAssign {
        MONO1, MONO2, POLY
    }

    public enum Osc1Mod {
        WAVEFORM, CROSS, UNISON, VPM
    }

    public enum Osc2Mod {
        OFF, RING, SYNC, RINGSYNC
    }

    public enum Osc1Wave {
        SAW, PULSE, TRI, SIN_CROSS, NOISE, FORMANT, DWGS, PCM, AUDIO_IN
    }

    public enum DwgsWave {
        SYNSINE1, SYNSINE2, SYNSINE3, SYNSINE4, SYNSINE5, SYNSINE6, SYNSINE7, SYNWAVE1, SYNWAVE2, SYNWAVE3, SYNWAVE4,
        SYNWAVE5, SYNWAVE6, SYNWAVE7, SYNWIRE1, SYNWIRE2, SYNWIRE3, SYNWIRE4, FIFTH_SAW, FIFTH_SQU, DIGI1, DIGI2, DIGI3,
        DIGI4, DIGI5, DIGI6, DIGI7, DIGI8, DIGI9, EPIANO1, EPIANO2, EPIANO3, ORGAN1, ORGAN2, ORGAN3, ORGAN4, ORGAN5,
        CLAV1, CLAV2, GUITAR1, GUITAR2, EBASS1, EBASS2, EBASS3, BELL1, BELL2, BELL3, ENDLESS, SYNVOX1, SYNVOX2, VOXPAD1,
        VOXPAD2, VOXPAD3, FLUTEPAD, EPPAD1, EPPAD2, NOISE1, NOISE2, NOISE3, NOISE4, NOISE5, NOISE6, NOISE7, NOISE8
    }

    public enum Osc2Wave {
        SAW, SQU, TRI, SIN
    }

    public enum Filter2Type {
        LPF, HPF, BPF, COMB
    }

    public enum FilterRouting {
        SINGLE, SERIAL, PARALLEL, INDIVIDUAL
    }

    public enum DrivePosition {
        PRE_FILTER1, PRE_AMP
    }

    public enum WaveShape {
        DRIVE, DECIMATOR, HARDCLIP, OCTSAW, MULTITRI, MULTISIN, SUBOSCSAW, SUBOSCSQU, SUBOSCTRI, SUBOSCSIN, PICKUP,
        LEVELBOOST
    }

    public enum LfoWave {
        SAW, SQUARE, SIN, SH, RANDOM
    }

    public enum LfoSyncNote {
        EIGHT_WHOLE, FOUR_WHOLE, TWO_WHOLE, WHOLE, THREE_QUARTERS, HALF, THREE_EIGHTHS, THIRD, QUARTER, THREE_SIXTEENTHS,
        SIXTH, EIGHTH, TWELFTH, SIXTEENTH, TWENTYFOURTH, THIRTYSECOND, SIXTYFOURTH
    }

    public enum PatchSrc {
        EG1, EG2, EG3, LFO1, LFO2, VELOCITY, PITCH_BEND, MOD_WHEEL, KEY_TRACK, MIDI1, MIDI2, MIDI3
    }

    public enum PatchDst {
        PITCH, OSC2_PITCH, OSC1_CNTL1, OSC1_LEVEL, OSC2_LEVEL, NOISE_LEVEL, FLT1_TYPE, FLT1_CUTOFF, FLT1_RESO,
        FLT2_CUTOFF, DRIVEWS_DEPTH, AMP, PAN, LFO1_FREQ, LFO2_FREQ
    }
}