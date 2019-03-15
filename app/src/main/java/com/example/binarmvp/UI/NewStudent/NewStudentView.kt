package com.example.binarmvp.UI.NewStudent

interface NewStudentView {
    abstract fun onStudentSave(status: Boolean, message: String = "")

}