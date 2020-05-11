package com.wildapi.api.services.solution;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wildapi.api.services.algo.Algo;
import com.wildapi.api.services.battle.Battle;
import com.wildapi.api.services.user.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"creator_id", "algo_id", "battle_id"})
})
public class Solution {

    @Id
    @GeneratedValue()
    private Long id;

    private String code;


    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @CreatedBy
    private User creator;

    @CreatedDate
    private Date postedAt;

    @JsonBackReference("algo-solutions")
    @ManyToOne
    @JoinColumn(name = "algo_id")
    private Algo algo;


    @JsonBackReference("solution-battle")
    @ManyToOne
    @JoinColumn(name = "battle_id")
    private Battle battle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Algo getAlgo() {
        return algo;
    }

    public void setAlgo(Algo algo) {
        this.algo = algo;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }
}
