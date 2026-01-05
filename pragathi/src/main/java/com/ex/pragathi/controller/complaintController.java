package com.ex.pragathi.controller;

import com.ex.pragathi.entity.Complaint;
import com.ex.pragathi.service.complaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class complaintController {
    @Autowired
    public complaintService service;

    @PostMapping("/sendNotification")
    public Complaint sendNotification(@RequestBody Complaint complaint){
        return service.sendNotification(complaint);
    }




}
