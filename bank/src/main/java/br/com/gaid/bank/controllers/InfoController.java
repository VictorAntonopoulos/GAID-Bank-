package br.com.gaid.bank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class InfoController {

    @GetMapping
    public Map<String, String> getProjectInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("project", "GAID Bank API");
        info.put("author", "Victor Martins Antonopoulos"); 
        return info;
    }
}
