public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int note;
    int sozluYuzde;
    int noteSozlu;
    double avg;

    public Course(String name, String code, String prefix,int sozluYuzde) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.sozluYuzde = sozluYuzde;
        this.note = 0;
        this.noteSozlu=0;
        this.avg = 0;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }


}
