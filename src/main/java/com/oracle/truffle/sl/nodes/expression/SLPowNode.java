/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.BranchProfile;
import com.oracle.truffle.sl.nodes.SLBinaryNode;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Performs the "^" operation - returns the value of the first argument
 * raised to the power of the second argument.
 */
@NodeInfo(shortName = "^")
public abstract class SLPowNode extends SLBinaryNode {

    private final BranchProfile bigNumbers = BranchProfile.create();


    @Specialization(rewriteOn = ArithmeticException.class)
    protected long pow(long left, long right) {
        double pow = Math.pow(left, right);
        if (pow > Long.MAX_VALUE) {
            bigNumbers.enter();
            throw new ArithmeticException();
        }
        return (long) pow;
    }

    @Specialization
    @CompilerDirectives.TruffleBoundary
    protected BigInteger pow(BigInteger left, BigInteger right) {
        return new BigDecimal(Math.pow(left.doubleValue(), right.doubleValue())).toBigIntegerExact();
    }

}
