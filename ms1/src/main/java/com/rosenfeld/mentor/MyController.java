package com.rosenfeld.mentor;

import com.rosenfeld.mentor.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
