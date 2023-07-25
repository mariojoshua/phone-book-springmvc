package com.uttara.phone_book_springmvc.phoneBookMaster;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneBookController {

        final PhoneBookMasterService phoneBookMasterService;

        public PhoneBookController (PhoneBookMasterService phoneBookMasterService) {
            this.phoneBookMasterService = phoneBookMasterService;
        }

        @GetMapping("/phoneBookMasters")
        public String phoneBookMasters(Model model) {
        model.addAttribute("phoneBooks", phoneBookMasterService.getAll());
        return "home/phonebooks";
    }
}
