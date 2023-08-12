package com.trojan.blockchain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trojan.blockchain.model.Block;

public interface BlockChainRepo extends MongoRepository<Block, String>{

}
