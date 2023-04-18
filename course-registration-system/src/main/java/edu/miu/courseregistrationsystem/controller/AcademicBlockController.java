package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.AcademicBlockDto;
import edu.miu.courseregistrationsystem.dto.AcademicBlockStudentDto;
import edu.miu.courseregistrationsystem.service.AcademicBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/academic-blocks")
public class AcademicBlockController {
    @Autowired
    private AcademicBlockService academicBlockCService;

    @GetMapping
    public List<AcademicBlockDto> getAllAcademicBlocks() {
        List<AcademicBlockDto> academicBlockDtos = academicBlockCService.getAllAcademicBlocks();
        return academicBlockDtos;
    }

    @PostMapping
    public ResponseEntity<?> addAcademicBlock(@RequestBody AcademicBlockDto academicBlockDto) {
        academicBlockCService.createAcademicBlock(academicBlockDto);
        return new ResponseEntity<>(academicBlockDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAcademicBlock(@PathVariable long id) {
        AcademicBlockDto academicBlockDto = academicBlockCService.getAcademicBlock(id);
        return new ResponseEntity<AcademicBlockDto>(academicBlockDto, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcademicBlock(@PathVariable long id, @RequestBody AcademicBlockDto academicBlockDto) {
        academicBlockCService.updateAcademicBlock(id, academicBlockDto);
        return new ResponseEntity<AcademicBlockDto>(academicBlockDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> dropAcademicBlock(@PathVariable long id) {
        academicBlockCService.deleteAcademicBlock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * @author REDIET
     * student can view all academic blocks he is registered
     *
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<?> getAcademicBlocksByStudent(@PathVariable long id) {
        List<AcademicBlockStudentDto> academicBlockDtos = academicBlockCService.getAcademicBlocksByStudent(id);
        return new ResponseEntity<List<AcademicBlockStudentDto>>(academicBlockDtos, HttpStatus.OK);
    }
}
