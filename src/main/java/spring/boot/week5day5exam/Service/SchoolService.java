package spring.boot.week5day5exam.Service;

import org.springframework.stereotype.Service;
import spring.boot.week5day5exam.Model.School;

import java.util.ArrayList;

@Service
public class SchoolService {

    ArrayList<School> schools = new ArrayList<>();

    //Get
    public ArrayList<School> getSchools() {
        return schools;
    }
    //post
    public void addSchool(School school) {
        schools.add(school);
    }
    //update
    public boolean updateSchool(School school, int id) {
        for (int i = 0; i < schools.size(); i++) {
            if (schools.get(i).getId() == id) {
                schools.set(i, school);
                return true;
            }
        }
        return false;
    }
    //delete
    public boolean deleteSchool(int id) {
        for (int i = 0; i < schools.size(); i++) {
            if (schools.get(i).getId() == id) {
                schools.remove(i);
                return true;
            }
        }
        return false;
    }

    //Create an endpoint that takes a student name and returns one student .
    public School getSchoolByName(String name){
        ArrayList<School> schools = this.getSchools();
        for (School school : schools) {
            if(school.getName().equals(name)){
                return school;
            }
        }
        return null;
    }
    //Create an endpoint that takes a major and returns all students who have this major.
    public ArrayList<School> getSchoolByMajor(String major){
        ArrayList<School> schools = this.getSchools();
        for (School school : schools) {
            if(school.getMajor().equals(major)){
                return schools;
            }
        }
        return schools;
    }
}

