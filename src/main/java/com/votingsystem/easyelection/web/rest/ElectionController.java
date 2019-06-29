package com.votingsystem.easyelection.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.votingsystem.easyelection.service.ElectionService;
import com.votingsystem.easyelection.web.model.ElectionModel;
import com.votingsystem.easyelection.web.payloads.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Set;

@RestController
@RequestMapping("api/v1/election")
public class ElectionController {
    Logger logger = LoggerFactory.getLogger(ElectionController.class);

    @Autowired
    ElectionService electionService;

    @PostMapping(value = "/save", headers = ("content-type=multipart/*"))
    ResponseEntity<?> saveElection(@RequestParam("file") MultipartFile file, @RequestParam String election) throws IOException  {
        String uri = "data:image/jpeg;base64," + new String(Base64.getEncoder().encode(file.getBytes()));
        ObjectMapper mapper = new ObjectMapper();
        ElectionModel electionModel = mapper.readValue(election,ElectionModel.class);
        electionModel.setImage(uri);
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
        return ResponseEntity.ok(new ApiResponse(true, "Deleted Successfully"));
    }
}
