package priv.guochun.psmc.system.activiti.test6;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParamModel implements Serializable {

	private boolean next;
	private int step;
	private int inclusiveStep;
	
	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getInclusiveStep() {
		return inclusiveStep;
	}

	public void setInclusiveStep(int inclusiveStep) {
		this.inclusiveStep = inclusiveStep;
	}
	
	
}
