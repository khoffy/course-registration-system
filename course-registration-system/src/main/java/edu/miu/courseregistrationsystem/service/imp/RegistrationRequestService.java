package edu.miu.courseregistrationsystem.service.imp;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationRequestDto;
import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import edu.miu.courseregistrationsystem.entity.RegistrationRequest;
import edu.miu.courseregistrationsystem.entity.Student;
import edu.miu.courseregistrationsystem.exception.ApplicationException;
import edu.miu.courseregistrationsystem.mapper.RegistrationRequestMapper;
import edu.miu.courseregistrationsystem.repository.RegistrationRequestRepository;
import edu.miu.courseregistrationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class RegistrationRequestService {

    private RegistrationRequestRepository registrationRequestRepository;

    private StudentRepository studentRepository;

    private RegistrationRequestMapper registrationRequestMapper;

    private RegistrationEventServiceImp registrationEventService;

//    public RegistrationRequestDto createRegistrationRequest(RegistrationRequestDto registrationRequestDto) throws ApplicationException {
//        List<RegistrationEventDto> registrationEventList = registrationEventService.getLatestRegistrationEvent();
//        RegistrationEventDto registrationEvent = registrationEventList.get(0);
//
//        if (Objects.isNull(registrationEvent)
//                || (LocalDateTime.now().isBefore(registrationEvent.getStartDate())
//                || LocalDateTime.now().isAfter(registrationEvent.getEndDate()))) {
//            throw new ApplicationException("Registration period not opened or closed!");
//        } else {
//            //
//            RegistrationRequest request =
//                    registrationRequestMapper.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
//            request.getCourseOffering().initial();
//        }
//    }

    public RegistrationRequestDto createRegistrationRequest(long studentId, RegistrationRequestDto registrationRequestDto) throws ApplicationException {
        RegistrationRequestDto responseDto = new RegistrationRequestDto();
        List<RegistrationEventDto> registrationEventList = registrationEventService.getLatestRegistrationEvent();
        if(registrationEventList.isEmpty()) {
            throw new ApplicationException("Registration period not opened or closed!");
        }
        RegistrationEventDto event = registrationEventList.get(0);
        if(LocalDateTime.now().isBefore(event.getStartDate())
                || (LocalDateTime.now().isAfter(event.getEndDate()))) {
            throw new ApplicationException("Registration period not opened or closed!");
        } else if((event.getStartDate().isBefore(LocalDateTime.now())
                && event.getEndDate().isAfter(LocalDateTime.now()))) {
            RegistrationRequest request =
                    registrationRequestMapper.registrationRequestDtoToRegistrationRequest(registrationRequestDto);
            //request.getCourseOffering().initial();

            RegistrationRequest response = registrationRequestRepository.save(request);
            Student student = studentRepository.findById(studentId).get();
            student.addRegistrationRequest(response);
            studentRepository.save(student);

            responseDto = registrationRequestMapper
                    .registrationRequestToRegistrationRequestDto(registrationRequestRepository.save(request));
        }
        return responseDto;
    }


    public List<RegistrationRequestDto> getAllRegistrationRequest() {
        List<RegistrationRequest> list = registrationRequestRepository.findAll();
        return registrationRequestMapper.registrationRequestsToRegistrationRequestDtos(list);
    }

    public RegistrationRequestDto getOneRegistrationRequest(Long id) {
        return registrationRequestMapper
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.findById(id).get());
    }

    public void deleteRegistrationRequest(Long id) {
        registrationRequestRepository.deleteById(id);
    }

    public RegistrationRequestDto updateRegistrationRequest(RegistrationRequestDto requestDto) {
        //RegistrationRequest request = RegistrationRequestAdapter.registrationRequestDtoToRegistrationRequest(requestDto);
        RegistrationRequest request = registrationRequestMapper.registrationRequestDtoToRegistrationRequest(requestDto);
        RegistrationRequest requestFromDb = registrationRequestRepository.findById(requestDto.getId()).get();

        requestFromDb.setStatus(request.getStatus());
        requestFromDb.setCourseOffering(request.getCourseOffering());
        requestFromDb.setPriority(request.getPriority());
        return registrationRequestMapper
                .registrationRequestToRegistrationRequestDto(registrationRequestRepository.saveAndFlush(requestFromDb));
    }


    @Autowired
    public void setRegistrationRequestRepository(RegistrationRequestRepository registrationRequestRepository) {
        this.registrationRequestRepository = registrationRequestRepository;
    }

    @Autowired
    public void setRegistrationRequestMapper(RegistrationRequestMapper registrationRequestMapper) {
        this.registrationRequestMapper = registrationRequestMapper;
    }

    @Autowired
    public void setRegistrationEventService(RegistrationEventServiceImp registrationEventService) {
        this.registrationEventService = registrationEventService;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
