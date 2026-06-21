package Week_1.Mockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.executeWithArg("test-argument");
        verify(mockApi).doSomethingWithArg(anyString());
    }

    @Test
    public void testHandlingVoidMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).doSomething();
        MyService service = new MyService(mockApi);
        service.execute();
        verify(mockApi).doSomething();
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");
        MyService service = new MyService(mockApi);
        assertEquals("First Mock Data", service.fetchData());
        assertEquals("Second Mock Data", service.fetchData());
    }

    @Test
    public void testVerifyingInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.execute();
        service.fetchData();
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).doSomething();
        inOrder.verify(mockApi).getData();
    }

    @Test
    public void testVoidMethodsWithExceptions() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("API Failure")).when(mockApi).doSomething();
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> service.execute());
    }
}
