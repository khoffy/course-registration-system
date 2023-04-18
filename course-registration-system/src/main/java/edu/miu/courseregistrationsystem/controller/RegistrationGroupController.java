package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupStudentDto;
import edu.miu.courseregistrationsystem.service.RegistrationGroupService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registration-groups")
public class RegistrationGroupController {
    @Autowired
    private RegistrationGroupService registrationGroupService;

    @GetMapping
    public ResponseEntity<?> getAllRegistrationGroups() {
        List<RegistrationGroupDto> registrationGroupDtos = registrationGroupService.getAllRegistrationGroups();
        return new ResponseEntity<>(registrationGroupDtos, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> addRegistrationGroup(@RequestBody RegistrationGroupDto registrationGroupDto) {
        registrationGroupService.creatRegistrationGroup(registrationGroupDto);
        return new ResponseEntity<RegistrationEventDto>(HttpStatus.OK);
    }
    /**
     * admin can update registration group
     * @param "registrationGroupId"
     * @param "studentIds"
     * @param "academicBlockId"
     * admin can update registration group and add students to the registration group, add academic block to the registration group
     */
    @PutMapping("/{registrationGroupId}")
    public ResponseEntity<?> updateRegistrationGroup(@PathVariable long registrationGroupId,
                                                     @RequestParam(value = "studentIds", required = false) List<Long> studentIds,
                                                     @RequestParam(value = "academicBlockId", required = false) Long academicBlockId) {
        registrationGroupService.updateRegistrationGroup(registrationGroupId, studentIds, academicBlockId);
        return new ResponseEntity<RegistrationEventDto>(HttpStatus.OK);
    }
    /**
     * @author Rediet
     * student can get registration group he is part of by student id
     */
    @GetMapping ("/{studentId}")
    public ResponseEntity<?> getRegistrationGroupByStudentIds(@PathVariable long studentId) {
        List<RegistrationGroupStudentDto> registrationGroupDtos = registrationGroupService.getRegistrationGroupByStudentIds(studentId);
        return new ResponseEntity<List<RegistrationGroupStudentDto>>(registrationGroupDtos, HttpStatus.OK);
    }

}
