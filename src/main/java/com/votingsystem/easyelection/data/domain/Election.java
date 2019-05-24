package com.votingsystem.easyelection.data.domain;


import com.votingsystem.easyelection.utils.DateTimeUtils;
import com.votingsystem.easyelection.web.model.ElectionModel;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "election")
public class Election extends AuditableEntity {

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Set<Candidate> candidates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "election")
    private Set<Voter> voters;

    public Election() {
        super();
    }

    public Election(ElectionModel electionModel) {
        super();
        this.setName(electionModel.getName());
        this.setCategory(electionModel.getCategory());
        this.setDescription(electionModel.getDescription());
        this.setImage(electionModel.getImage());
        this.setStartDate(DateTimeUtils.instantFromDateString(electionModel.getStartDate()));
        this.setEndDate(DateTimeUtils.instantFromDateString(electionModel.getEndDate()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Voter> getVoters() {
        return voters;
    }

    public void setVoters(Set<Voter> voters) {
        this.voters = voters;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }
}
