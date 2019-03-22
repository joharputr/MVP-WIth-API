package com.example.binarmvp.UI.Home

import com.example.binarmvp.model.Student

//penghubung dari presenter dan view
interface MainView {
    //dipanggil i presenter
    fun showStudent(results:List<Student>)
    fun onError(message: String)
    fun showdeleteStudent(student: Student,status : Boolean, message: String= "")
    fun showProgress(show: Boolean)
}