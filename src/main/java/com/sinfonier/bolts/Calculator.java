package com.sinfonier.bolts;

import java.math.BigDecimal;

/**
 * Given an operator and operands do an operations and write the result in a field.
 */
public class Calculator extends BaseSinfonierBolt {

    private String operator;
    private String op1Src, op2Src;
    private String outField;

    public Calculator(String path) {
        super(path);
    }

    @Override
    public void userprepare() {
        operator = this.getParam("operator");
        op1Src = this.getParam("op1");
        op2Src = this.getParam("op2");
        outField = this.getParam("outField");
    }

    @Override
    public void userexecute() {

        BigDecimal op1BD, op2BD = null;
        if(existsField(op1Src)){
            op1BD = new BigDecimal(String.valueOf(getField(op1Src)));
        } else {
            op1BD = new BigDecimal(op1Src);
        }

        if(null != op2Src && !op2Src.isEmpty()) {
            if (existsField(op2Src)) {
                op2BD = new BigDecimal(String.valueOf(getField(op2Src)));
            } else {
                op2BD = new BigDecimal(op2Src);
            }
        }

        doOperation(op1BD, op2BD);

        emit();
    }

    @Override
    public void usercleanup() {

    }

    @Override
    public void tickTupleCase() {
        super.tickTupleCase();
    }

    /**
     *
     * @param opLeft Operand 1
     * @param opRight Operand 2 or null if is a unary operation.
     */
    public void doOperation(BigDecimal opLeft, BigDecimal opRight){

        Object result = null;

        if("+".equals(operator)){
            result = opLeft.add(opRight);
        } else if("-".equals(operator)){
            result = opLeft.subtract(opRight);
        } else if("*".equals(operator)) {
            result = opLeft.multiply(opRight);
        } else if("/".equals(operator)) {
            result = opRight.compareTo(BigDecimal.ZERO) == 0 ? 0 : opLeft.divide(opRight, BigDecimal.ROUND_CEILING);
        } else if("^".equals(operator)){
            result = opLeft.pow(opRight.intValue());
        } else if("sqrt".equals(operator)){
            result = new BigDecimal(Math.sqrt(opLeft.doubleValue()));
        } else if("%".equals(operator)){
            result = opLeft.remainder(opRight);
        } else {
            LOG.error("Incorrect operator " + operator);
        }

        addField(outField, result);
    }
}
