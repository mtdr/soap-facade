package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.service.ISoapClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UnitTests {
    @Autowired
    private ISoapClientService soapClientService;

    @Test
    public void testAdd() {
        assertEquals(soapClientService.getAdditionResult(5, 1).getAddResult(), 6);
    }

    @Test
    public void testSubtract() {
        assertEquals(soapClientService.getSubtractResult(5, 1).getSubtractResult(), 4);
    }

    @Test
    public void testMultiply() {
        assertEquals(soapClientService.getMultiplyResult(5, 100).getMultiplyResult(), 500);
    }

    @Test
    public void testDivide() {
        assertEquals(soapClientService.getDivideResult(100, 5).getDivideResult(), 20);
    }

}
