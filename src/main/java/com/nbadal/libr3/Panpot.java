package com.nbadal.libr3;

public class Panpot {
    public static String fromValue(int pan) {
        pan = Math.min(63, Math.max(-63, pan));
        if(pan < 0) {
            return "L"+Math.abs(pan);
        } else if(pan == 0) {
            return "CNT";
        } else {
            return "R"+pan;
        }
    }

    public static class ParamConverter extends com.nbadal.libr3.ParamConverter<String> {
        @Override
        public String decode(Param<String> param, byte[] raw) {
            return Panpot.fromValue(raw[0]-64);
        }

        @Override
        public byte[] encode(Param<String> param, String value) {
            byte pan = 0;
            switch(value.charAt(0)) {
                case 'L':
                    pan = (byte) -Byte.parseByte(value.substring(1));
                    break;
                case 'C':
                    pan = 0;
                    break;
                case 'R':
                    pan = Byte.parseByte(value.substring(1));
                    break;
            }
            pan += 64;
            return new byte[] {pan};
        }
    }
}
