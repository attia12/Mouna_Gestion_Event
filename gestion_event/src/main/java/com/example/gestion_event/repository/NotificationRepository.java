package com.example.gestion_event.repository;


import com.example.gestion_event.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdAndSeenFalse(Long userId);
}
