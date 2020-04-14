package edu.aks.mcrsvc.calculator.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CommonUtilsTest {

    CommonUtils commonUtils;
    List<String> values;

    @Before
    public void before () {
        commonUtils = new CommonUtils ();
        values = Arrays.asList ( "1", "2", "3", "4" );
    }

    @Test
    public void testConvert () {
        List<Double> actualResult = commonUtils.convert ( values );
        //expected output calculation
        List<Double> expectedResult = new ArrayList<> ();
        for (String s : values) {
            expectedResult.add ( Double.parseDouble ( s ) );
        }
        Assert.assertEquals ( expectedResult, actualResult );
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertWithExceptionForInvalidNumbers () {
        commonUtils.convert ( Arrays.asList ( "a", "b" ) );
    }
}
