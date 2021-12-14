package com.example.jakubwiraszka.lab8;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import static org.junit.Assert.*;

public class UrlParserTestJavaReflections {

    UrlParser tester = new UrlParser();

    private Object invokeMethod(Class targetClass, Object targetObject, String methodName, Class argClass, Object argObject) {
        Object result = null;
        try {
            Method method = targetClass.getDeclaredMethod(methodName,
                    argClass);
            method.setAccessible(true);
            result = method.invoke(targetObject, argObject);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        }
        return result;
    }

    private void setField(Class targetClass, Object targetObject, String fieldName, Object newFieldObject) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(targetObject, newFieldObject);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testParseSchemeWithHTTP() {
        setField(tester.getClass(), tester, "urlToParse", "http://mydomain.com");
        assertEquals("http://", invokeMethod(tester.getClass(), tester, "parseScheme", String.class, "http://mydomain.com"));
    }

    @Test
    public void testParseSchemeWithHTTPS() {
        setField(tester.getClass(), tester, "urlToParse", "https://mydomain.com");
        assertEquals("https://", invokeMethod(tester.getClass(), tester, "parseScheme", String.class, "https://mydomain.com"));
    }

    @Test
    public void testParseSchemeWithFTP() {
        setField(tester.getClass(), tester, "urlToParse", "ftp://mydomain.com");
        assertEquals("ftp://", invokeMethod(tester.getClass(), tester, "parseScheme", String.class, "ftp://mydomain.com"));
    }

    @Test
    public void testParseSchemeThrowsException() {  // SPRAWDZANIE Exception, PONIEWAŻ parseScheme MA PRZYPISANY TYLKO JEDEN RODZAJ WYJĄTKU
        setField(tester.getClass(), tester, "urlToParse", "mydomain.com");
        assertThrows(Exception.class, (ThrowingRunnable) invokeMethod(tester.getClass(), tester, "parseScheme", String.class, "mydomain.com"));
    }

    @Test
    public void testParseEmptyFullAddress() {
        setField(tester.getClass(), tester, "urlToParse", "");
        assertEquals("", invokeMethod(tester.getClass(), tester, "parseFullAddress", String.class, ""));
    }

    @Test
    public void testParseFullAddress() {
        setField(tester.getClass(), tester, "urlToParse", "mydomain.com/page?argument={hard}");
        assertEquals("mydomain.com", invokeMethod(tester.getClass(), tester, "parseFullAddress", String.class, "mydomain.com/page?argument={hard}"));
    }

    @Test
    public void testParseEmptyFullPath() {
        setField(tester.getClass(), tester, "urlToParse", "");
        assertEquals("", invokeMethod(tester.getClass(), tester, "parseFullPath", String.class, ""));
    }

    @Test
    public void testParseFullPath() {
        setField(tester.getClass(), tester, "urlToParse", "/page?argument={hard}");
        assertEquals("/page", invokeMethod(tester.getClass(), tester, "parseFullPath", String.class, "/page?argument={hard}"));
    }

    @Test
    public void testParseEmptyParameters() {
        setField(tester.getClass(), tester, "urlToParse", "");
        Object o = invokeMethod(tester.getClass(), tester, "parseParameters", String.class, "");
        assertEquals(new HashMap<>(), o);
    }

    @Test
    public void testParseParameters() {
        setField(tester.getClass(), tester, "urlToParse", "argument1={hard}&argument2={easy}");
        HashMap<String, String> hashMap = (HashMap<String, String>) invokeMethod(tester.getClass(), tester, "parseParameters", String.class, "argument1={hard}&argument2={easy}");
        HashMap<String, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put("argument1", "{hard}");
        expectedHashMap.put("argument2", "{easy}");
        assertEquals(expectedHashMap, hashMap);
    }
}
