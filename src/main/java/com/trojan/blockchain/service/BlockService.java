package com.trojan.blockchain.service;

import java.util.List;

import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.model.Block;

public interface BlockService {

	Block saveBlock(CreateBlockDto createBlockDto);

	List<GetBlockDto> retrieveBlocks();

	boolean updateBlock(String oldBlock, String newBlock);

	boolean deleteBlock(String block);

}
