package list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void simpleTest() {
       List listMock = mock(List.class);
       when(listMock.size()).thenReturn(3);
       assertEquals(3, listMock.size());
    }

    @Test
    public void multipleReturnTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(1).thenReturn(2);
        assertEquals(3, listMock.size());
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size()); // multiple returns last value
        assertEquals(2, listMock.size());
    }

    @Test
    public void specificParameters() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("someString");
        assertEquals("someString", listMock.get(0));
        assertNull(listMock.get(1)); // will return null as it is string
    }

    @Test
    public void anyParameters() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("someOtherString");
        assertEquals("someOtherString", listMock.get(0));
        assertEquals("someOtherString", listMock.get(1));
        assertEquals("someOtherString", listMock.get(10));
        assertEquals("someOtherString", listMock.get(56));
    }
}
