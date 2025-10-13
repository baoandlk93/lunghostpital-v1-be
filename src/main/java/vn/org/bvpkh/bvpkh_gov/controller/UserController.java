package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;
import vn.org.bvpkh.bvpkh_gov.services.IUserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    private final IUserService userService;


    @RequestMapping
    public ResponseEntity<Page<User>> findAll(@RequestParam(defaultValue = "") String name,
                                              @PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(userService.findByUsernameContaining(name, pageable), HttpStatus.OK);
    }

}
