/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.truffle.sl.test;

import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.vm.PolyglotEngine;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SLPowTest {

    private PolyglotEngine engine;
    private PolyglotEngine.Value pow;

    @Before
    public void initEngine() throws Exception {
        engine = PolyglotEngine.newBuilder().build();
        engine.eval(
            Source.newBuilder("\n"
                    + "function pow(a, b) {\n"
                    + "  return a ^ b;\n"
                    + "}\n").
            name("pow.sl").
            mimeType("application/x-sl").
            build()
        );
        pow = engine.findGlobalSymbol("pow");
    }

    @After
    public void dispose() {
        engine.dispose();
    }

    @Test
    public void powOf2And2() throws Exception {
        Number ret = pow.execute(2, 2).as(Number.class);
        assertEquals(4, ret.intValue());
    }

    @Test
    public void pow2And3() throws Exception {
        Number ret = pow.execute(2, 3).as(Number.class);
        assertEquals(8, ret.intValue());
    }

    @Test
    public void powBigIntegers() throws Exception {
        Number ret = pow.execute(Long.MAX_VALUE, 2).as(Number.class);
        assertEquals(new BigDecimal(Math.pow(Long.MAX_VALUE, 2)).toBigIntegerExact(), ret);
    }

    @Test
    public void pow2AndString() throws Exception {
        Exception exc = null;
        try {
            pow.execute(2, "test");
            Assert.fail("should not get here");
        } catch (RuntimeException ex) {
            Throwable cause = ex.getCause();
            Assert.assertTrue(cause.getClass().getName(), cause instanceof UnsupportedTypeException);
            exc = ex;
        }
        Assert.assertNotNull(exc);
    }

}
