package reflection;

import java.lang.reflect.Field;

public class ReflectionHelper {
    public static Object createInstance (String className){
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object object, String fieldName, String value){
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Types types = Types.getType(field.getType());
            setFieldType(object, value, field, types);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void setFieldType(Object object, String value, Field field, Types types) throws IllegalAccessException {
        switch (types){
            case BYTE:
                field.set(object, Byte.valueOf(value));
                break;
            case BOOLEAN:
                field.set(object, Boolean.valueOf(value));
                break;
            case SHORT:
                field.set(object, Short.valueOf(value));
                break;
            case CHAR:
                field.set(object, value.charAt(0));
                break;
            case INT:
                field.set(object, Integer.decode(value));
                break;
            case FLOAT:
                field.set(object, Float.valueOf(value));
                break;
            case LONG:
                field.set(object, Long.valueOf(value));
                break;
            case DOUBLE:
                field.set(object, Double.valueOf(value));
                break;
            case STRING:
                field.set(object, value);
        }
    }
}
