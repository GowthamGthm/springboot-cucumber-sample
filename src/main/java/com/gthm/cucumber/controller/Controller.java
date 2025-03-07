package com.gthm.cucumber.controller;

import com.gthm.cucumber.model.onestream.Packet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gthm.cucumber.model.Account;
import com.gthm.cucumber.service.AccountService;

import java.util.Optional;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private AccountService accountService;

    @Value(value = "${app.version}")
    private String APPLICATION_VERSION;

    @GetMapping("/version")
    public String getVersion() {
        return Optional.ofNullable(APPLICATION_VERSION).orElse("N/A");
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/onestream")
    public ResponseEntity<String> onestream(@RequestBody Packet packet) {
        log.info("======== controller received : {}" , packet.toString());
        return ResponseEntity.status(200).body("SUCCESSFUL");
    }
    
}