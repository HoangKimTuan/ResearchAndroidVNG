/*
 *  Copyright 2016 Fabio Collini.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.cosenonjaviste.daggermock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import dagger.Subcomponent;

class ReflectUtils {

    private ReflectUtils() {
    }

    public static String toCamelCase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static List<Field> extractAnnotatedFields(Object target, Class<? extends Annotation> annotationClass) {
        List<Field> ret = new ArrayList<>();
        Class<?> targetClass = target.getClass();
        while (!targetClass.equals(Object.class)) {
            Field[] fields = targetClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(annotationClass)) {
                    ret.add(field);
                }
            }
            targetClass = targetClass.getSuperclass();
        }
        return ret;
    }

    public static Method getMethodReturning(Class<?> declaringClass, Class<?> returnClass) {
        Method[] methods = declaringClass.getMethods();
        for (Method method : methods) {
            if (method.getReturnType().equals(returnClass)) {
                return method;
            }
        }
        return null;
    }

    public static List<Method> getAllMethodsReturning(Class<?> declaringClass, Class<?> returnClass) {
        List<Method> ret = new ArrayList<>();
        Method[] methods = declaringClass.getMethods();
        for (Method method : methods) {
            if (method.getReturnType().equals(returnClass)) {
                ret.add(method);
            }
        }
        return ret;
    }

    public static Method getMethodWithParameter(Class<?> declaringClass, Class<?> parameterClass) {
        Method[] methods = declaringClass.getMethods();
        for (Method method : methods) {
            Class<?>[] parameters = method.getParameterTypes();
            if (parameters.length == 1 && parameters[0].equals(parameterClass)) {
                return method;
            }
        }
        return null;
    }

    public static Object invokeMethod(Object component, Method m, Object... args) {
        try {
            return m.invoke(component, args);
        } catch (Exception e) {
            throw new RuntimeException("Error invoking method " + m, e);
        }
    }

    public static void setFieldValue(Object target, Field field, Object obj) {
        try {
            field.set(target, obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error setting field " + field, e);
        }
    }

    public static boolean isSubComponentBuilder(Class<?> returnType) {
        // Subcomponent.Builder hasn't retention RUNTIME, check if it's an interface defined in a SubComponent annotated class
        return returnType.isInterface() && returnType.isMemberClass() && returnType.getDeclaringClass() != null && isSubComponent(returnType.getDeclaringClass());
    }

    public static boolean isSubComponent(Class<?> returnType) {
        return returnType.getAnnotation(Subcomponent.class) != null;
    }
}
