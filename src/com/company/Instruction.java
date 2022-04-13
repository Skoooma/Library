package com.company;

public class Instruction {


    private String instruction;
    private int stepNum;

    public Instruction(String instuction, int stepNum){
        this.instruction = instuction;
        this.stepNum = stepNum;
    }

    public Instruction() {

    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }


    @Override
    public String toString() {
        return "person{" +
                "Instruction='" + instruction + '\'' +
                ", StepNum=" + stepNum +
                '}';
    }
}
