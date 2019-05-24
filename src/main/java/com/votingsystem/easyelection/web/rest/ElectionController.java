package com.votingsystem.easyelection.web.rest;

import com.votingsystem.easyelection.service.ElectionService;
import com.votingsystem.easyelection.web.model.ElectionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping("api/v1/election")
public class ElectionController {
    Logger logger = LoggerFactory.getLogger(ElectionController.class);

    @Autowired
    ElectionService electionService;

    @PostMapping(value = "/save", headers = ("content-type=multipart/*"))
    ResponseEntity<?> saveElection(@RequestParam("file") MultipartFile file, @RequestBody ElectionModel electionModel) throws IOException  {
        electionModel.setImage(file.getBytes());
        ElectionModel model = electionService.saveElection(electionModel);
        logger.info("Saving election.........");
        return ResponseEntity.ok(model);
    }

    @GetMapping("/electionList")
    ResponseEntity<?> getAllElection() {
        Set<ElectionModel> models = electionService.getElectionList();
        logger.info("Getting election list");
        return ResponseEntity.ok(models);
    }
    @GetMapping("/delete")
    ResponseEntity<?> deleteElection(@RequestParam(name = "id", required = true) Long id) {
        logger.info("Deleting election");
        electionService.deleteElection(id);
        return ResponseEntity.ok(null);
    }
}
