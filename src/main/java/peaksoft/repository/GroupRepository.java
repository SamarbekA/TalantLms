package peaksoft.repository;

import peaksoft.model.Company;
import peaksoft.model.Group;

import java.io.IOException;
import java.util.List;

public interface GroupRepository {
    List<Group> getAllListGroups();

    List<Group> getAllGroups(Long courseId);

    void addGroup(Group group, Long id);

    Group getGroupById(Long id);

    void updateGroup(Group group, Long id);

    void deleteGroup(Long id);

    void assignGroup(Long courseId, Long groupId) throws IOException;
}
