package com.example.binarmvp.Home

import com.example.binarmvp.model.Student
//extend kelas interface untuk manggil method nya
class MainPresenter(private val view: MainView) {
    //kelas prensenter manggil kelas interface
    fun saySomething(){
        view.sayHello("sdsd")
    }

    fun getStudents() {
        //sumber data dari API
        val studentList = mutableListOf<Student>()
        studentList.add(Student("john", "john@gmail.com"))
        studentList.add(Student("john", "john@gmail.com"))
        studentList.add(Student("john", "john@gmail.com"))
        studentList.add(Student("john", "john@gmail.com"))
        //manggil method di kelas interface
        view.showStudent(studentList)
    }

}