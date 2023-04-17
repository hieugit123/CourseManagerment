package com.phanlop.khoahoc.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignId;
    private String assignTitle;
    @Column(columnDefinition = "TEXT")
    private String assignDes;
    @CreatedDate
    private Instant createdDate;
    private Instant deadline;

    // Khóa ngoại courseID
    @ManyToOne @JoinColumn(name="course_id")
    @EqualsAndHashCode.Exclude @ToString.Exclude @JsonBackReference
    private Course course;

    // Khóa ngoại cho submit
    @OneToMany(mappedBy = "assign", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude @ToString.Exclude @JsonManagedReference
    private Set<Submit> listSubmits = new HashSet<>();

    // Tạo bảng AssignmentFile
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @JoinTable(name="assginment_file",
            joinColumns = @JoinColumn(name="assgin_id"),
            inverseJoinColumns = @JoinColumn(name="file_id")
    )
    private Set<File> listFiles = new HashSet<>();
}
