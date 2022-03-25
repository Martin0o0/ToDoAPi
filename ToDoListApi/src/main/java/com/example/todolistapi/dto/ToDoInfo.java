package com.example.todolistapi.dto;

public class ToDoInfo {
    private int no;
    private String title;
    private String wantToDo;
    private boolean isStart;
    private boolean isFinished;
    private int totalTime;


    @Override
    public String toString() {
        return "ToDoInfo{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", wantTodDo='" + wantToDo + '\'' +
                ", isStart=" + isStart +
                ", isFinished=" + isFinished +
                ", totalTime=" + totalTime +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWantToDo() {
        return wantToDo;
    }

    public void setWantToDo(String wantToDo) {
        this.wantToDo = wantToDo;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
