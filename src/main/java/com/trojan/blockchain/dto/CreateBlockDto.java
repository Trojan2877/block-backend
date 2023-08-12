package com.trojan.blockchain.dto;

public class CreateBlockDto {

	private String thisBlock;
	
	private String nextBlock;

	public String getThisBlock() {
		return thisBlock;
	}

	public void setThisBlock(String thisBlock) {
		this.thisBlock = thisBlock;
	}

	public String getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(String nextBlock) {
		this.nextBlock = nextBlock;
	}
	
}
