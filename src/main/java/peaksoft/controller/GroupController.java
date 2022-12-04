package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.model.Group;
import peaksoft.model.Instructor;
import peaksoft.model.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.io.IOException;

@Controller
public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;


    @Autowired
    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/groups/{id}")
    public String getAllGroups(@PathVariable Long id, Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("groups", groupService.getAllGroups(id));
        model.addAttribute("courseId", id);
        model.addAttribute("students",studentService.getStudentList());
        return "/group/groups";
    }

    @GetMapping("/groups/{id}/addGroup")
    public String addGroup(@PathVariable Long id, Model model) {
        model.addAttribute("group", new Group());
        model.addAttribute("courseId", id);
        return "/group/addGroup";
    }

    @PostMapping("/{id}/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group,
                            @PathVariable Long id) {
        groupService.addGroup(group, id);
        return "redirect:/groups/" + id;
    }

    @GetMapping("/updateGroup/{id}/{courseId}")
    public String updateGroup(@PathVariable("id") Long id, Model model,@PathVariable("courseId") Long courseId) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("group", group);
        model.addAttribute("groupId", courseId);
        return "/group/updateGroup";
    }
    @PostMapping("/{courseId}/{id}/saveUpdateGroup")
    public String saveUpdateGroup(@PathVariable("courseId") Long courseId,
                                  @PathVariable("id") Long id,
                                  @ModelAttribute("group") Group group) {
        groupService.updateGroup(group, id);
        return "redirect:/groups/" + courseId;
    }

    @GetMapping("/{courseId}/{id}/deleteGroup")
    public String deleteGroup(@PathVariable("id") Long id, @PathVariable("courseId") Long courseId) {
        groupService.deleteGroup(id);
        return "redirect:/groups/" + courseId;
    }
    @PostMapping("{groupId}/assignStudent")
    private String assignStudent(@PathVariable("groupId")Long groupId,
                                    @ModelAttribute("student") Student student)throws IOException {
        System.out.println(student);
        Long id = student.getId();
        studentService.assignStudent(groupId, id);
        return "redirect:/students/"+groupId;
    }
}