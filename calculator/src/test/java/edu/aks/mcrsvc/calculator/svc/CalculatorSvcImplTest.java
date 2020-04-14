package edu.aks.mcrsvc.calculator.svc;

import edu.aks.mcrsvc.calculator.exception.CalculatorException;
import edu.aks.mcrsvc.calculator.operate.CalcOperation;
import edu.aks.mcrsvc.calculator.util.CommonUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorSvcImplTest {

    @Mock
    CommonUtils commonUtilsMock;

    @Mock
    CalcOperation calcOperationMock;

    @InjectMocks
    CalculatorSvcImpl calculatorSvcImpl;

    List<String> values;
    List<Double> doubleValue;

    @Before
    public void before () {
        values = Arrays.asList ( "1", "2", "3", "4" );
        doubleValue = new ArrayList<> ( Arrays.asList ( new Double ( 1.0 ), new Double ( 2.0 ), new Double ( 3.0 ), new Double ( 4.0 ) ) );
    }

    @Test
    public void testSum () throws CalculatorException {
        when ( commonUtilsMock.convert ( values ) ).thenReturn ( doubleValue );
        when ( calcOperationMock.sum ( doubleValue ) ).thenReturn ( 10.0 );
        Assert.assertEquals ( new Double ( 10.0 ), calculatorSvcImpl.sum ( values ) );
    }

    @Test
    public void testDifference () throws CalculatorException {
        when ( commonUtilsMock.convert ( values ) ).thenReturn ( doubleValue );
        when ( calcOperationMock.difference ( doubleValue ) ).thenReturn ( -8.0 );
        Assert.assertEquals ( new Double ( -8.0 ), calculatorSvcImpl.difference ( values ) );
    }

    @Test
    public void testMultiply () throws CalculatorException {
        when ( commonUtilsMock.convert ( values ) ).thenReturn ( doubleValue );
        when ( calcOperationMock.multiply ( doubleValue ) ).thenReturn ( 24.0 );
        Assert.assertEquals ( new Double ( 24.0 ), calculatorSvcImpl.multiply ( values ) );
    }

    @Test
    public void testDivide () throws CalculatorException {
        List<String> testValue = new ArrayList<> ( Arrays.asList ( "20", "10" ) );
        List<Double> doubleValues = new ArrayList<> ( Arrays.asList ( 20.0, 10.0 ) );
        when ( commonUtilsMock.convert ( testValue ) ).thenReturn ( doubleValues );
        when ( calcOperationMock.divide ( doubleValues ) ).thenReturn ( 2.0 );
        Assert.assertEquals ( new Double ( 2.0 ), calculatorSvcImpl.divide ( testValue ) );
    }

    @Test(expected = CalculatorException.class)
    public void testConvertWithExceptionForInvalidNumbers () throws CalculatorException {
        List<String> list = Arrays.asList ( "a", "b" );
        when ( commonUtilsMock.convert ( list ) ).thenThrow ( new NumberFormatException () );
        calculatorSvcImpl.sum ( list );
    }
}
