package com.trojan.blockchain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.service.BlockService;

@CrossOrigin
@RestController
@RequestMapping("/block")
public class BlockChainController {

	@Autowired
	private BlockService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createBlock(@RequestBody CreateBlockDto blockInfoDto) {
		service.saveBlock(blockInfoDto);
		return ResponseEntity.ok("Block created successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<GetBlockDto>> getBlock(){
		return new ResponseEntity<>(service.retrieveBlocks(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{oldBlock}")
	public ResponseEntity<String> updateBlock(@Valid @PathVariable String oldBlock, @RequestParam String newBlock){
		if(service.updateBlock(oldBlock, newBlock))
			return new ResponseEntity<>("Block Updated Successfully", HttpStatus.OK);
		return new ResponseEntity<>("Block Doesn't exist", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteBlock(@Valid @RequestParam String block){
		if(service.deleteBlock(block))
			return new ResponseEntity<>("Deleted Block", HttpStatus.OK);
		return new ResponseEntity<>("Block Doesn't exist", HttpStatus.BAD_REQUEST);
	}
}