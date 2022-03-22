package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
//part 3: Skill.job #1
    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();

    @Size(min =1, max = 100)
    private String description;

    public Skill() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    //Don't think I need for section 4: skill.jobs, but not sure
    public List<Job> getJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }
}

