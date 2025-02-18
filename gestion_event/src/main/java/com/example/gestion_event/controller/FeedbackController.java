package com.example.gestion_event.controller;

import com.example.gestion_event.entities.Feedback;
import com.example.gestion_event.request.FeedbackRequest;
import com.example.gestion_event.response.FeedbackResponse;
import com.example.gestion_event.services.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback( @Valid @RequestBody FeedbackRequest feedbackRequest) {
        return ResponseEntity.ok(feedbackService.submitFeedback(feedbackRequest));
    }


    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<FeedbackResponse>> getFeedbackForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(feedbackService.getFeedbackForEvent(eventId));
    }
    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
        return ResponseEntity.noContent().build();
    }
}
