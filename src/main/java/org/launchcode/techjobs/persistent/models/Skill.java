package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Max;

@Entity
public class Skill extends AbstractEntity {

    @Max(255)
    private String skill;

    public Skill(String skill) {
        this.skill = skill;
    }

    public Skill() { }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}