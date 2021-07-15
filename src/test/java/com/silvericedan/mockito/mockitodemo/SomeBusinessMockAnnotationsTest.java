package com.silvericedan.mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//This is the way of doing it in Junit 5, in junit 4 is with @RunWith(MockitoJunitRunner.class)
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockAnnotationsTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestFromAllData(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,15,3});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFinTheGreatestFromAllData_ForOneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFinTheGreatestFromAllData_NoValues(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}
