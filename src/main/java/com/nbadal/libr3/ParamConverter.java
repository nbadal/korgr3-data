package com.nbadal.libr3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class ParamConverter<T> {
    public abstract T decode(Param<T> param, byte[] raw);
    public abstract byte[] encode(Param<T> param, T value);

    public static <T> ParamConverter<T> getDefault() {
        return new ParamConverter<T>() {
            @Override
            public T decode(Param<T> param, byte[] raw) {
                if(ByteChunk.class.isAssignableFrom(param.type)) {
                    try {
                        Constructor ctor = param.type.getConstructor(byte[].class);
                        return (T) ctor.newInstance(raw);
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
                if(Boolean.class.isAssignableFrom(param.type)) {
                    return param.type.cast(raw[0] != 0);
                }
                if(String.class.isAssignableFrom(param.type)) {
                    return param.type.cast(new String(raw));
                }
                if(Integer.class.isAssignableFrom(param.type)) {
                    return param.type.cast(((raw[1] & 0xff) << 8) | (raw[0] & 0xff));
                }
                if(param.type.isEnum()) {
                    return param.type.getEnumConstants()[raw[0]];
                }
                try {
                    return param.type.cast(raw);
                } catch (ClassCastException e) {
                    return param.type.cast(raw[0]);
                }
            }

            @Override
            public byte[] encode(Param<T> param, T value) {
                // TODO: figure out default for encoding
                throw new UnsupportedOperationException("Stub");
            }
        };
    }

    public static class OffsetConverter extends ParamConverter<Byte> {
        int offset;

        public OffsetConverter(int offset) {
            this.offset = offset;
        }

        @Override
        public Byte decode(Param<Byte> param, byte[] raw) {
            return (byte) (raw[0] + offset);
        }

        @Override
        public byte[] encode(Param<Byte> param, Byte value) {
            return new byte[]{(byte)(value - offset)};
        }
    }

    public static class ArrayConverter<T> extends ParamConverter<T> {
        T[] array;

        public ArrayConverter(T[] array) {
            this.array = array;
        }

        @Override
        public T decode(Param<T> param, byte[] raw) {
            return null;
        }

        @Override
        public byte[] encode(Param<T> param, T value) {
            return new byte[0];
        }
    }
}
