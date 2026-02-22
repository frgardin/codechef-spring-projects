package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {
    

    public final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody MemberDTO memberDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(memberService.registerMember(memberDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

        // TODO: Handle HTTP DELETE requests. Map it so it expects an ID in the URL path (e.g., /api/1)
    @DeleteMapping("/{id}")
    // TODO: Extract the 'id' value from the URL path and bind it to the method parameter
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            // TODO: Call the deleteMember method from the service with the extracted ID
            memberService.deleteMember(id);

            // If successful, return a success message with a 200 OK status
            return ResponseEntity.ok("Member deleted successfully.");
        } catch (RuntimeException e) {
            // TODO: If the member is not found, return a 404 Not Found HTTP status
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // TODO: Handle HTTP GET requests to fetch the list of active members
    @GetMapping
    public ResponseEntity<List<Member>> getActiveMembers() {
        // TODO: Call the correct method from memberService and wrap it in a 200 OK response
        return ResponseEntity.ok(memberService.getAllActiveMembers());
    }
}