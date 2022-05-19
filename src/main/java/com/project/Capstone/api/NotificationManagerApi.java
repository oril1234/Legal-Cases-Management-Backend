package com.project.Capstone.api;

import com.project.Capstone.model.LegalCase;
import com.project.Capstone.model.Notification;
import com.project.Capstone.model.NotificationManager;
import com.project.Capstone.service.NotificationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/notificationManager")
@RestController
public class NotificationManagerApi {

    private final NotificationManagerService notificationManagerService;

    @Autowired
    public NotificationManagerApi(NotificationManagerService notificationManagerService) {
        this.notificationManagerService = notificationManagerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertNotification(@RequestBody NotificationManager notificationManager){
        notificationManagerService.insertNotificationManager(notificationManager);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public List<Notification> selectNotificationsForPersonId(@PathVariable("id") int id) {
        return notificationManagerService.selectNotificationsForPersonId(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/all")
    public List<Notification> selectAllNotificationsFromNotificationManager() {
        return notificationManagerService.selectAllNotificationsFromNotificationManager();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/allNotificationManagers")
    public List<NotificationManager> selectAllNotificationManagers() {
        return notificationManagerService.selectAllNotificationManagers();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteNotificationManagerById(@PathVariable("id") String id) {
        return notificationManagerService.deleteNotificationManagerById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}/{receiverId}")
    public int deleteNotificationManagerByIdAndReceiverId(@PathVariable("id") String id, @PathVariable("receiverId") int receiverId) {
        return notificationManagerService.deleteNotificationManagerByNotificationIdAndReceiverId(id,receiverId);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/markAsRead")
    public int updateNotificationsOfPersonToRead(@RequestBody String receiverId) {
        return notificationManagerService.updateNotificationsOfPersonToRead(Integer.parseInt(receiverId));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total/{receiverId}")
    public int numberOfUnreadNotificationsPerPerson(@PathVariable("receiverId") int receiverId) {
        return notificationManagerService.numberOfUnreadNotificationPerPerson(receiverId);
    }
}
