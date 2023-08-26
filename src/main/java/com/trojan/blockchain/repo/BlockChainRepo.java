package com.trojan.blockchain.repo;

import com.trojan.blockchain.model.Block;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BlockChainRepo extends MongoRepository<Block, String> {
    // Custom method to save a block and set createdOn and updatedOn
    @Override
    <S extends Block> S save(S entity);

    // Custom method to update a block and set updatedOn
    @Override
    <S extends Block> S insert(S entity);
}

// Callback to set createdOn and updatedOn before saving or updating
class BlockBeforeConvertCallback implements BeforeConvertCallback<Block> {
    @Override
    public Block onBeforeConvert(Block block, String collection) {
        LocalDateTime now = LocalDateTime.now();
        if (block.getId() == null) { // New entity, set createdOn
            block.setCreatedOn(now);
        }
        block.setUpdatedOn(now); // Set updatedOn for new or existing entity
        return block;
    }
}

@Configuration
class MongoConfig {
    @Bean
    public BeforeConvertCallback<Block> blockBeforeConvertCallback() {
        return new BlockBeforeConvertCallback();
    }
}
