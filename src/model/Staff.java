package model;

public class Staff {
    private String name;
    private boolean type;
    private boolean status;
    private int salary;

    public Staff() {
    }

    public Staff(String name, boolean type, boolean status, int salary) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getType(){
        if (isType()){
            return "Đang làm";
        }
        return "Đã nghỉ";
    }

    public String getStatus(){
        if (isStatus()){
            return "FullTimne";
        }
        return "PartTime";
    }

    @Override
    public String toString() {
        return "Staff =>" +
                "Tên Nhân Viên : " + name +
                ", Trạng Thái : " + getType() +
                ", Hoạt Động : " + getStatus() +
                ", Lương : " + salary + "$"
                ;
    }
}
