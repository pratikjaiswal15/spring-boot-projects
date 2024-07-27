package business;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllData_Basic_Scenario_Mock() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,4,6});
        int result = someBusiness.findTheGreatestFromAllData();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }

    @Test
    void findTheGreatestFromAllData_One_Value() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {20});
        int result = someBusiness.findTheGreatestFromAllData();
        int expectedResult = 20;
        assertEquals(expectedResult, result);
    }

    @Test
    void findTheGreatestFromAllData_Empty_Array() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int result = someBusiness.findTheGreatestFromAllData();
        int expectedResult = Integer.MIN_VALUE;
        assertEquals(expectedResult, result);
    }
}



