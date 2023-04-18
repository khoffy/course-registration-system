package edu.miu.courseregistrationsystem.repository;

import edu.miu.courseregistrationsystem.entity.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rediet
 * @version 1.0
 * @created 18-Dec-2022 5:49 PM
 */
@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup, Long> {
}
