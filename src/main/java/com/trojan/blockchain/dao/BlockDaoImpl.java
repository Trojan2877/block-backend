package com.trojan.blockchain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.model.Block;
import com.trojan.blockchain.repo.BlockChainRepo;
import com.trojan.blockchain.util.Transformer;

@Repository
public class BlockDaoImpl implements BlockDao {

	@Autowired
	private BlockChainRepo blockRepo;
	
	@Override
	public Block saveBlock(CreateBlockDto createBlockDto) {
		Block block = Transformer.toBlockEntity(createBlockDto);
		return blockRepo.save(block);
	}

	@Override
	public List<GetBlockDto> getBlocks() {
		List<Block> blockList = blockRepo.findAll();
		return Transformer.toRetrieveBlock(blockList);
	}

	@Override
	public boolean update(String oldBlock, String newBlock) {
		List<Block> blockList = blockRepo.findAll();
		if(blockList.isEmpty())
			return false;
		for(Block block : blockList) {
			if(String.valueOf(block.getBlock()).equals(oldBlock)) {
				block.setBlock(Integer.valueOf(newBlock));
				blockRepo.save(block);
				return true;
			}
			else if(String.valueOf(block.getNextBlock()).equals(oldBlock)) {
				block.setBlock(Integer.valueOf(newBlock));
				blockRepo.save(block);
				return true;
			}
		} 
		return false;
	}

	@Override
	public boolean deleteBlock(String block) {
		try {
		blockRepo.delete(blockRepo.findById(block).orElseThrow(() ->  new RuntimeException()));
		}
		catch(RuntimeException e) {
		return false;
		}
		return true;
	}
	
}
