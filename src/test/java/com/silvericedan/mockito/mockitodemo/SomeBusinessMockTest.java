package com.silvericedan.mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    @Test
    public void testFindTheGreatestFromAllData(){
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock.retrieveAllData() => new int[] {24,15,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,15,3});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    public void testFinTheGreatestFromAllData_ForOneValue(){
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock.retrieveAllData() => new int[] {15}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(15, result);
    }
}
