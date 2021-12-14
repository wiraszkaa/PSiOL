package com.example.jakubwiraszka.lab8;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class UrlParserTest {

    private UrlObject urlObjectMock = Mockito.mock(UrlObject.class);
    private UrlParser tester = new UrlParser();
    private String testUrl = "http://mydomain.com/page?argument1={hard}&argument2={easy}";

    @Test
    public void testParseSchemeWithHTTP() {
        Mockito.when(urlObjectMock.getScheme()).thenReturn("http://");
        assertEquals(urlObjectMock.getScheme(), tester.parseUrl(testUrl).getScheme());
    }

    @Test
    public void testParseSchemeWithHTTPS() {
        Mockito.when(urlObjectMock.getScheme()).thenReturn("https://");
        assertEquals(urlObjectMock.getScheme(), tester.parseUrl("https://mydomain.com").getScheme());
    }

    @Test
    public void testParseSchemeWithFTP() {
        Mockito.when(urlObjectMock.getScheme()).thenReturn("ftp://");
        assertEquals(urlObjectMock.getScheme(), tester.parseUrl("ftp://mydomain.com").getScheme());
    }

    @Test(expected = RuntimeException.class)
    public void testParseSchemeThrowsException() {
        tester.parseUrl("mydomain.com");
    }

    @Test
    public void testParseEmptyFullAddress() {
        Mockito.when(urlObjectMock.getFullAddress()).thenReturn("");
        assertEquals(urlObjectMock.getFullAddress(), tester.parseUrl("http://").getFullAddress());
    }

    @Test
    public void testParseFullAddress() {
        Mockito.when(urlObjectMock.getFullAddress()).thenReturn("mydomain.com");
        assertEquals(urlObjectMock.getFullAddress(), tester.parseUrl(testUrl).getFullAddress());
    }

    @Test
    public void testParseEmptyFullPath() {
        Mockito.when(urlObjectMock.getPath()).thenReturn("");
        assertEquals(urlObjectMock.getPath(), tester.parseUrl("http://mydomain.com").getPath());
    }

    @Test
    public void testParseFullPath() {
        Mockito.when(urlObjectMock.getPath()).thenReturn("/page");
        assertEquals(urlObjectMock.getPath(), tester.parseUrl(testUrl).getPath());
    }

    @Test
    public void testParseEmptyParameters() {
        HashMap<String, String> parameters = new HashMap<>();
        Mockito.when(urlObjectMock.getParameters()).thenReturn(parameters);
        assertEquals(urlObjectMock.getParameters(), tester.parseUrl("http://mydomain.com/page").getParameters());
    }

    @Test
    public void testParseParameters() {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("argument1", "{hard}");
        parameters.put("argument2", "{easy}");
        Mockito.when(urlObjectMock.getParameters()).thenReturn(parameters);
        assertEquals(urlObjectMock.getParameters(), tester.parseUrl(testUrl).getParameters());

    }
}
