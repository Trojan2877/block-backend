package com.trojan.blockchain.dao;

import java.util.List;

import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.model.Block;

public interface BlockDao {

	Block saveBlock(CreateBlockDto createBlockDto);

	List<GetBlockDto> getBlocks();

	boolean update(String oldBlock, String newBlock);

	boolean deleteBlock(String block);

}
