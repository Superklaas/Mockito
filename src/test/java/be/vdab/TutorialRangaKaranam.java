package be.vdab;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.mockito.Mockito.*;

public class TutorialRangaKaranam {

    List list = mock(List.class);

    @Test
    void multipleReturnValues() {
        when(list.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,list.size());
        assertEquals(10,list.size());
    }

    @Test
    void specificArgumentMatcher() {
        when(list.get(0)).thenReturn("vdab");
        assertEquals("vdab",list.get(0));
        assertEquals(null,list.get(1));
    }

    @Test
    void genericArgumentMatcher() {
        when(list.get(anyInt())).thenReturn("vdab");
        assertEquals("vdab",list.get(0));
        assertEquals("vdab",list.get(1));
    }

}
