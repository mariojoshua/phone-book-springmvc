package com.uttara.phone_book_springmvc.phoneBookMaster;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/phoneBookMasters")
public class PhoneBookController {

        final PhoneBookMasterService phoneBookMasterService;

        public PhoneBookController (PhoneBookMasterService phoneBookMasterService) {
            this.phoneBookMasterService = phoneBookMasterService;
        }

        @GetMapping
        public String phoneBookMasters(Model model) {
            model.addAttribute("phoneBookMasters", phoneBookMasterService.getAll());
            return "phoneBookMaster/list";
        }

        @GetMapping("/add")
        public String add (@ModelAttribute("phoneBookMaster") final PhoneBookMaster phoneBookMaster) {
            return "phoneBookMaster/add";
        }

        @PostMapping("/save")
        public String createPhoneBookMaster(@ModelAttribute PhoneBookMaster phoneBookMaster) {
        System.out.println(phoneBookMaster.getName() + "result");    
        final Long createdId = phoneBookMasterService.create(phoneBookMaster);
        return "phoneBookMaster/list";
    }
    
}
