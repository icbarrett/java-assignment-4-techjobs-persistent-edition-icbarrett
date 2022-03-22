package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// Section 3: Update Job Model - #1
public class Job extends AbstractEntity{

    // Section 3: Update Job Model - #2,3
    @ManyToOne
    private Employer employer;

//    private String skills;

    // section 4: refactor Job.skill
    @ManyToMany
    private final List<Skill> skills = new ArrayList<>();

    public Job() { }

    public Job(Employer anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
//        this.skills = someSkills;
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

    // section 4: refactor Job.skill

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
}
