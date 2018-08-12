package pl.mps.kodilla.hibernate.tasklist.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mps.kodilla.hibernate.tasklist.TaskList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Example Name", "Example Description");
        taskListDao.save(taskList);
        String expected = "Example Description";

        //When
        List<TaskList> searchedTaskList = taskListDao.findByListName("Example Name");
        String actual = searchedTaskList.get(0).getDescription();

        //Than
        Assert.assertEquals(expected, actual);

        //Clean up
        taskListDao.delete(taskList);
    }
}