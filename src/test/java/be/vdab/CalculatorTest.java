package be.vdab;

import be.vdab.oreilly.Calculator;
import be.vdab.oreilly.Database;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock Database database;
    @InjectMocks Calculator calculator = new Calculator();

    @Test
    void calculateSum() {
        int[] data = {1,2,3};
        assertEquals(6, calculator.calculateSum(data));
    }

    @Test
    void calculateSumUsingDatabase() {
        when(database.getData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, calculator.calculateSumUsingDataService());
    }

}
