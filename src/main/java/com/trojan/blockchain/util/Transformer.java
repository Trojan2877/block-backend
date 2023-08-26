package com.trojan.blockchain.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.model.Block;

public class Transformer {

	public static Block toBlockEntity(CreateBlockDto createBlockDto) {
		Block block = new Block(UUID.randomUUID().toString(), createBlockDto.getThisBlock().hashCode(), createBlockDto.getNextBlock().hashCode());
		/*ZoneId zone = ZoneId.of("Europe/Dublin");
		LocalDateTime today = LocalDateTime.now(zone);
		block.setCreatedOn(today);*/
		return block;
	}
	
	public static List<GetBlockDto> toRetrieveBlock(List<Block> blocks) {
		ModelMapper modelMapper = new ModelMapper();
		return blocks.stream().map(block -> modelMapper.map(block, GetBlockDto.class)).collect(Collectors.toList());
	}
}
