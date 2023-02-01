package com.rosenfeld;

import com.rosenfeld.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class MyController {

    @Autowired
    private MentorRepository mentorRepository;

    @RequestMapping ("/check")
    @ResponseBody
    public String getAnswer() {
        return mentorRepository.findById(3).get().getName();
    }
}
