package com.phanlop.khoahoc.Repository;

import com.phanlop.khoahoc.Entity.Course;
import com.phanlop.khoahoc.Entity.User;
import com.phanlop.khoahoc.Entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "courses", path = "user-course-api")
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    Set<UserCourse> findByUser(User user);
    Set<UserCourse> findByCourse(Course course);
}
