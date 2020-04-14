package edu.aks.mcrsvc.calculator.operate;

import edu.aks.mcrsvc.calculator.exception.*;
import org.junit.*;

import java.util.*;

public class CalcOperationTest {

    CalcOperation calcOperation;


    @Before
    public void before () {
        calcOperation = new CalcOperation ();
    }

    @Test
    public void testSum () {
        List<Double> numberList = Arrays.asList ( new Double ( 1.0 ), new Double ( 2.0 ), new Double ( 3.0 ), new Double ( 4.0 ) );
        Assert.assertEquals ( new Double ( 10.0 ), calcOperation.sum ( numberList ) );
    }

    @Test
    public void testDifference () {
        List<Double> numberList = new ArrayList<> ( Arrays.asList ( new Double ( 1.0 ), new Double ( 2.0 ), new Double ( 3.0 ), new Double ( 4.0 ) ) );
        Assert.assertEquals ( new Double ( 24.0 ), calcOperation.difference ( numberList ) );
    }

    @Test
    public void testMultiply () {
        List<Double> numberList = new ArrayList<> ( Arrays.asList ( new Double ( 1.0 ), new Double ( 2.0 ), new Double ( 3.0 ), new Double ( 4.0 ) ) );
        Assert.assertEquals ( new Double ( 24.0 ), calcOperation.multiply ( numberList ) );
    }

    @Test
    public void testDivide () throws CalculatorException{
        List<Double> numberList = new ArrayList<> ( Arrays.asList (  new Double ( 4.0 ), new Double ( 2.0 ) ) );
        Assert.assertEquals ( new Double ( 2.0 ), calcOperation.divide ( numberList ) );
    }

    @Test(expected = CalculatorException.class)
    public void testDivideWithZero () throws CalculatorException {
        List<Double> numberList = new ArrayList<> ( Arrays.asList ( new Double ( 1.0 ), new Double ( 0.0 ) ) );
        calcOperation.divide ( numberList );
    }
}
