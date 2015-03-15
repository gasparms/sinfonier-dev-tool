package com.sinfonier.bolts;

public class MultiplyBolt extends BaseSinfonierBolt {

    private String operator;
    private String op1, op2;
    private String outField;

    public MultiplyBolt(String path) {
        super(path);
    }

    @Override
    public void userprepare() {
        operator = this.getParam("operator");
        op1 = this.getParam("op1");
        op2 = this.getParam("op2");
        outField = this.getParam("outField");
    }

    @Override
    public void userexecute() {
        int oper1 = Integer.parseInt(op1);
        int oper2 = Integer.parseInt(op2);
        if (operator.equals("*")) {
            addField(outField, oper1 * oper2);
        }
        emit();
    }

    @Override
    public void usercleanup() {

    }

    @Override
    public void tickTupleCase() {
        super.tickTupleCase();
    }
}
