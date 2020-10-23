package be.vdab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.mockito.Mockito.*;

public class MockingSpying {

    @Test
    void mocking() {

        ArrayList arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        System.out.println("------");

        arrayListMock.add("test1");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        System.out.println("------");

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

    }

    @Test
    void spying() {

        ArrayList arrayListSpy = spy(ArrayList.class);

        //System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        System.out.println("------");

        arrayListSpy.add("test1");
        arrayListSpy.add("test2");
        System.out.println(arrayListSpy.get(0));
        System.out.println(arrayListSpy.size());
        System.out.println("------");

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
        System.out.println("------");

        arrayListSpy.add("test1");
        System.out.println(arrayListSpy.size());

    }

}
