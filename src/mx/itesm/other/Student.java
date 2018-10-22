package mx.itesm.other;

public class Student implements Comparable<Student>{
	private String studentId;
	private String studentName;
	
	public Student(String id, String name) {
		studentId = id;
		studentName = name;
	}
	
	public int compareTo(Student other) {
		int len1 = studentId.length();
		int len2 = other.studentId.length();
		
		int limit = Math.min(len1, len2);
		
		for(int i = 0; i < limit; i++) {
			char c1 = studentId.charAt(i);
			char c2 = other.studentId.charAt(i);
			
			if (c1 != c2) {
				return c1-c2;
			}
		}
		return len1 - len2;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String toString() {
		return studentId + " - " + studentName;
	}
	
}
