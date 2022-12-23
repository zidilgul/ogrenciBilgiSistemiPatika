public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int matSinav, int matSozlu, int fizikSinav, int fizikSozlu, int kimyaSinav, int kimyaSozlu) {

        if (matSinav >= 0 && matSinav <= 100 && matSozlu >= 0 && matSozlu <= 100) {
            this.mat.note = matSinav;
            this.mat.noteSozlu = matSozlu;
            this.mat.avg =  (matSinav * (100 - this.mat.noteSozlu) /100) + (matSozlu * this.mat.noteSozlu /100);

        }

        if (fizikSinav >= 0 && fizikSinav <= 100 && fizikSozlu >= 0 && fizikSozlu <= 100) {
            this.fizik.note = fizikSinav;
            this.fizik.noteSozlu = fizikSozlu;
            this.fizik.avg = (fizikSinav * (100 - this.fizik.noteSozlu) /100) + (fizikSozlu * this.fizik.noteSozlu /100);

        }

        if (kimyaSinav >= 0 && kimyaSinav <= 100 && kimyaSozlu >= 0 && kimyaSozlu <= 100) {
            this.kimya.note = kimyaSinav;
            this.kimya.noteSozlu = kimyaSozlu;
            this.kimya.avg = (kimyaSozlu * this.kimya.noteSozlu /100) + (kimyaSinav * (100 - this.kimya.noteSozlu) /100);
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0 ||this.mat.noteSozlu == 0 || this.fizik.noteSozlu == 0 || this.kimya.noteSozlu == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.fizik.avg + this.kimya.avg + this.mat.avg) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}