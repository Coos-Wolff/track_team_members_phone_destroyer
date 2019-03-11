package com.wolffsoft.phonedestroyer.resources;

import com.wolffsoft.phonedestroyer.model.member.Member;
import com.wolffsoft.phonedestroyer.model.member.MemberName;
import com.wolffsoft.phonedestroyer.service.MemberService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController("/member")
public class MemberResource {

    private MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/showmembers")
    public ModelAndView showMembers() {
        ModelAndView modelAndView = new ModelAndView("member/show-members");
        modelAndView.addObject("members", memberService.getMembers());

        return modelAndView;
    }

    @GetMapping("/addmembers")
    public ModelAndView addMembers() {
        ModelAndView modelAndView = new ModelAndView("member/add-member");

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveMember(MemberName memberName, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return addMembers();
        }
        Member member = Member.builder()
                .name(memberName.getName())
                .build();

        memberService.addMember(member);

        return showMembers();
    }

    @GetMapping("/deletemember")
    public ModelAndView deleteMember() {
        ModelAndView deleteModelAndView = new ModelAndView("member/delete-member");
        deleteModelAndView.addObject("members", memberService.getMembers());

        return deleteModelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") int id) {
        memberService.deleteMemberById(id);

        return deleteMember();
    }
}
