package StudentManagementSystem.Management;

import StudentManagementSystem.CourseResult;

public class GradingForCourse {

    public void setMark(CourseResult courseResult, float middtermTest, float finalTest) {
            courseResult.setMarkOfMiddterm(middtermTest);
            courseResult.setMarkOfFinalTerm(finalTest);
            courseResult.setResult();
            courseResult.setClassify();
    }
}
