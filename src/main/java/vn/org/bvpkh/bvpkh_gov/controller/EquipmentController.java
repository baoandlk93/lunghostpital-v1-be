package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/equipments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {
}
