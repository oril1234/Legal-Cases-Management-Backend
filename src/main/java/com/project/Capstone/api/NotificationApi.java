package com.project.Capstone.api;

import com.project.Capstone.model.Notification;
import com.project.Capstone.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/notification")
@RestController
public class NotificationApi {

    private final NotificationService notificationService;

    @Autowired
    public NotificationApi(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public List<String> insertNotification(@RequestBody Notification notification){
        return Arrays.asList(notificationService.insertNotification(notification));
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Notification getNotificationById(@PathVariable("id") String id) {
        return notificationService.getNotificationById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteNotificationById(@PathVariable("id") String id) {
        return notificationService.deleteNotification(id);
    }
}
