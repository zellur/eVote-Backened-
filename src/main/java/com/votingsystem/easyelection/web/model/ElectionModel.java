package com.votingsystem.easyelection.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.votingsystem.easyelection.data.domain.Election;
import com.votingsystem.easyelection.utils.DateTimeUtils;

import java.util.Set;

public class ElectionModel extends AbstractModel {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String category;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String image;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String startDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String endDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<CandidateModel> candidates;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<VoterModel> voters;

    public ElectionModel() {
        super();
    }

    public ElectionModel(Election election) {
       super();
       this.setId(election.getId());
       this.setCategory(election.getCategory());
       this.setDescription(election.getDescription());
       this.setImage(election.getImage());
       this.setStartDate(DateTimeUtils.stringFromInstant(election.getStartDate()));
       this.setEndDate(DateTimeUtils.stringFromInstant(election.getEndDate()));
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Set<CandidateModel> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<CandidateModel> candidates) {
        this.candidates = candidates;
    }

    public Set<VoterModel> getVoters() {
        return voters;
    }

    public void setVoters(Set<VoterModel> voters) {
        this.voters = voters;
    }
}
