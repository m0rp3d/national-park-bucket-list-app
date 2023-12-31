package com.nationalparkbucketlist.backend.userservices.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
public class DbSequence {

    @Id
    private String id;
    private Long seq;

    public DbSequence() {

    }

    public DbSequence(String id, Long seq) {
        this.id = id;
        this.seq = seq;
    }

    public DbSequence(Long seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeqNo(Long seq) {
        this.seq = seq;
    }
}
