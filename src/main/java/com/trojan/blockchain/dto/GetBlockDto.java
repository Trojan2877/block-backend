package com.trojan.blockchain.dto;

public class GetBlockDto {

	private String id;
	
	private String block;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	private String nextBlock;

	public String getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(String nextBlock) {
		this.nextBlock = nextBlock;
	}
	
	
}
