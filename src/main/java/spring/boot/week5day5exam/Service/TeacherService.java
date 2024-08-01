package spring.boot.week5day5exam.Service;

import org.springframework.stereotype.Service;
import spring.boot.week5day5exam.Model.Teacher;

import java.util.ArrayList;


@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(Teacher teacher, int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    //Create an endpoint that takes a teacher id and returns one teacher .
    public Teacher getTeacherById(int id) {
        ArrayList<Teacher> teachers = this.getTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }
}
