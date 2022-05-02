package sis.com.test;

import sis.com.Dao.StudentDao;
import sis.com.bo.Student;
import sis.com.factory.StudentFactory;

public class AddRecordTest {

	public static void main(String[] args) {
   StudentDao studentDao=StudentFactory.getStudentDao();
   Student st=new Student();
   
   st.setName("bab");
   st.setBranch("mca");
   st.setId(1);
   st.setCollege("Nitrr");
   st.setContact("67762378506");
   st.setEmailId("bablu@gmail01.com");
   st.setGender("male");
   boolean yes=studentDao.addRecord(st);
   System.out.println(yes);
  
	}

}
