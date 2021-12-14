package com.example.jakubwiraszka.lab8;

import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.ws.http.HTTPException;
import java.security.InvalidParameterException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class WeatherDownloaderTest {

    private WeatherDownloadWorker weatherDownloadWorkerMock = Mockito.mock(WeatherDownloadWorker.class);
    private UrlObject urlObjectMock = Mockito.mock(UrlObject.class);
    private WeatherDownloader tester = new WeatherDownloader(weatherDownloadWorkerMock);

    @Test(expected = InvalidParameterException.class)
    public void testGetByCityNameInvalidParameterException() {
        Mockito.when(urlObjectMock.getParameters()).thenReturn(new HashMap<>());
        tester.getByCityName(urlObjectMock);
    }

    @Test(expected = HTTPException.class)
    public void testGetByCityNameHTTPException() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("city", "parameter");
        Mockito.when(urlObjectMock.getParameters()).thenReturn(hashMap);
        Mockito.when(weatherDownloadWorkerMock.downloadData()).thenReturn(false);
        tester.getByCityName(urlObjectMock);
    }

    @Test
    public void testGetByCityName() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("city", "parameter");
        Mockito.when(urlObjectMock.getParameters()).thenReturn(hashMap);
        Mockito.when(weatherDownloadWorkerMock.downloadData()).thenReturn(true);
//        assertNotNull(tester.getByCityName(urlObjectMock));  // NOTNULL WEDŁUG MNIE LEPSZYM JEST LEPSZYM ROZWIĄZANIEM, ALE MAMY SPRAWDZIĆ CZY TYP JEST POPRAWNY
        assertTrue(tester.getByCityName(urlObjectMock) instanceof WeatherObject);
    }

    @Test(expected = InvalidParameterException.class)
    public void testGetByCoordinatesInvalidParameterException() {
        Mockito.when(urlObjectMock.getParameters()).thenReturn(new HashMap<>());
        tester.getByCoordinates(urlObjectMock);
    }

    @Test(expected = HTTPException.class)
    public void testGetByCoordinatesHTTPException() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("lon", "parameter");
        hashMap.put("lat", "parameter");
        Mockito.when(urlObjectMock.getParameters()).thenReturn(hashMap);
        Mockito.when(weatherDownloadWorkerMock.downloadData()).thenReturn(false);
        tester.getByCoordinates(urlObjectMock);
    }

    @Test
    public void testGetByCoordinates() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("lon", "parameter");
        hashMap.put("lat", "parameter");
        Mockito.when(urlObjectMock.getParameters()).thenReturn(hashMap);
        Mockito.when(weatherDownloadWorkerMock.downloadData()).thenReturn(true);
//        assertNotNull(tester.getByCoordinates(urlObjectMock));
        assertTrue(tester.getByCoordinates(urlObjectMock) instanceof WeatherObject);
    }
}
