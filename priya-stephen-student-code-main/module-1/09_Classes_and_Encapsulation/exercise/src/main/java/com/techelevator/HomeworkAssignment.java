package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;


    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade(){
        double percentage = ( (double)earnedMarks/ (double)possibleMarks) ;
        if (percentage >=.9){
            return "A";
        } else if (percentage >=.8) {

            return "B";
        } else if (percentage >=.7) {
            return "C";
        } else if (percentage >=.6) {
            return "D";
        } else {

            return "F";
        }

   }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }
}
