package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rediet
 *  @version 1.0
 *  @created 17-Dec-2022 5:00 PM
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
