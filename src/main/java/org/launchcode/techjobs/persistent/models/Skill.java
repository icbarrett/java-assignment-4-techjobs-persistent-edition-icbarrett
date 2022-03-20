package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;

@Entity
public class Skill extends AbstractEntity {

    @Max(100)
    private String skill;

    public Skill(String description) {
        this.skill = description;
    }

    public Skill() {

    }

    public String getDescription() {
        return skill;
    }

    public void setDescription(String description) {
        this.skill = description;
    }
}