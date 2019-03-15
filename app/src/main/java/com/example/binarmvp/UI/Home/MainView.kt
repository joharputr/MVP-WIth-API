package com.example.binarmvp.UI.Home

import com.example.binarmvp.model.Student

//penghubung dari presenter dan view
interface MainView {

    fun showStudent(results:List<Student>)
    fun onError(message: String){
    }
}