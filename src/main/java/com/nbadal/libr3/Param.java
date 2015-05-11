package com.nbadal.libr3;

public class Param<T> {
    Class<T> type;
    int startByte;
    int endByte;
    int startBit;
    int endBit;
    ParamConverter<T> converter;

    public static <T> Param<T> make(Class<T> type, int startByte) {
        return make(type, startByte, startByte);
    }

    public static <T> Param<T> make(Class<T> type, int startByte, int startBit, int endBit) {
        return make(type, startByte, startByte, startBit, endBit);
    }
    public static <T> Param<T> make(Class<T> type, int startByte, int startBit, int endBit, ParamConverter<T> converter) {
        return make(type, startByte, startByte, startBit, endBit, converter);
    }

    public static <T> Param<T> make(Class<T> type, int startByte, int endByte) {
        return make(type, startByte, endByte, 0, 7);
    }

    public static <T> Param<T> make(Class<T> type, int startByte, ParamConverter<T> converter) {
        return make(type, startByte, startByte, converter);
    }


    public static <T> Param<T> make(Class<T> type, int startByte, int endByte, ParamConverter<T> converter) {
        return make(type, startByte, endByte, 0, 7, converter);
    }

    public static <T> Param<T> make(Class<T> type, int startByte, int endByte, int startBit, int endBit) {
        final ParamConverter<T> converter = ParamConverter.getDefault();
        return make(type, startByte, endByte, startBit, endBit, converter);
    }

    public static <T> Param<T> make(Class<T> type, int startByte, int endByte, int startBit, int endBit, ParamConverter<T> converter) {
        return new Param<>(type, startByte, endByte, startBit, endBit, converter);
    }

    private Param(Class<T> type, int startByte, int endByte, int startBit, int endBit, ParamConverter<T> converter) {
        this.type = type;
        this.startByte = startByte;
        this.endByte = endByte;
        this.startBit = startBit;
        this.endBit = endBit;
        this.converter = converter;
    }
}
