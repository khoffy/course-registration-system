package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findAllByStudentId(long studentId);
}
