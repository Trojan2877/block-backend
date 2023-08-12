package com.trojan.blockchain.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trojan.blockchain.dao.BlockDao;
import com.trojan.blockchain.dto.CreateBlockDto;
import com.trojan.blockchain.dto.GetBlockDto;
import com.trojan.blockchain.model.Block;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockDao dao;
	
	@Override
	public Block saveBlock(CreateBlockDto createBlockDto) {
		return dao.saveBlock(createBlockDto);
	}

	@Override
	public List<GetBlockDto> retrieveBlocks() {
		return dao.getBlocks();
	}

	@Override
	public boolean updateBlock(String oldBlock, String newBlock) {
		if(dao.update(oldBlock, newBlock))
			return true;
		return false;
	}

	@Override
	public boolean deleteBlock(String block) {
		return dao.deleteBlock(block);
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
            int number = i;
            calculateFactorial(number);
        }
		for (int i = 1; i <= 20; i++) {
            System.out.println("Factorial of Executed by thread : " + Thread.currentThread().getName());
        }
	}
	
	 public static BigInteger calculateFactorial(int number) {
	        BigInteger factorial = BigInteger.ONE;
	        for (int i = 2; i <= number; i++) {
	            factorial = factorial.multiply(BigInteger.valueOf(i));
	        }
	        return factorial;
	    }
	
}
