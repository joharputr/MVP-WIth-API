package com.example.binarmvp.Home

import com.example.binarmvp.model.Student

//penghubung dari presenter dan view
interface MainView {
    fun sayHello(hello:String)
    fun showStudent(results:List<Student>)
}