package main_package;

public class Course {
	private String courseName;
	private String courseCode;
	private int duration;
	private String courseDes;
	private Professor professor;
	private Classroom classroom;
	
	public Course(Professor professor, Classroom classroom, String courseName, String courseCode, int duration, String courseDes) {
		this.setProfessor(professor);
		this.setClassroom(classroom);
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.duration = duration;
		this.courseDes = courseDes;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
