package application.controller;

import application.model.AdminAccount;
import application.model.Config;
import application.services.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generalConfig")
public class GeneralConfigController {
    private final ConfigService configService;
    @Autowired
    public GeneralConfigController(ConfigService configService) {
        this.configService = configService;
    }
    @GetMapping("/config/{id}")
    public String configById(@PathVariable("id") long id, Model model) {
        Config config = configService.prepareConfig(id);
        model.addAttribute("config", config);
        return "main-config";
    }
}