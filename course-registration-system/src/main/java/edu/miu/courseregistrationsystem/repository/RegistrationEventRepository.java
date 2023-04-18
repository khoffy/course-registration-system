package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Rediet
 *  @version 1.0
 *  @created 17-Dec-2022 5:00 PM
 */
@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long> {

    List<RegistrationEvent> findByRegistrationGroupsStudentsId(long studentId);

}
