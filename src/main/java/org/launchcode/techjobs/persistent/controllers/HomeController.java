package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
// section 3: Updating HomeController - #1
    @Autowired
    private EmployerRepository employerRepository;

    //
    @Autowired
    private JobRepository jobRepository;
    //Section 4: Updating HomeController, Again (paragraph #1)
//    @Autowired
//    private SkillRepository skillRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        // Section 3: Updating HomeController - #2
        model.addAttribute("employers", employerRepository.findAll());
//        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors, Model model,
                                    @RequestParam int employerId/*,
                                    @RequestParam List<Integer> skills*/) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            //add error repositories
            return "add";
        }
        //section 3: Updating HomeController #4
        else {
            Optional optEmployer = employerRepository.findById(employerId);
            Employer employer = (Employer) optEmployer.get();
            newJob.setEmployer(employer);

//        }

        /*  In processAddJobForm, add code inside of this method to select
            the employer object that has been chosen to be affiliated with
            the new job. You will need to select the employer using the
            request parameter you’ve added to the method.
         */

            //Section 4: Updating HomeController: paragraph 3?
//            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//            newJob.setSkills(skillObjs);
            jobRepository.save(newJob);

        }
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        Optional optJob = jobRepository.findById(jobId);

        if (optJob.isPresent()) {
            Job job = (Job) optJob.get();
            model.addAttribute("job", job);
            return "view";
        } else {
            return "redirect:";
        }

    }
}
