package sis.com.test;

import sis.com.Dao.StudentDao;
import sis.com.bo.Student;
import sis.com.factory.StudentFactory;

public class UpdateTest {

	public static void main(String[] args) {
StudentDao studentDao=StudentFactory.getStudentDao();
      Student stu=new Student();
      stu.setId(1002);
      stu.setName("Kalpna");
      stu.setGender("female");
      stu.setContact("723499772");
      stu.setEmailId("kalpna@gmail.com");
      stu.setCollege("K.N.I");
      stu.setBranch("Bsc");
     boolean update=studentDao.updateRecord(stu);
     System.out.println(update);
	}

}
