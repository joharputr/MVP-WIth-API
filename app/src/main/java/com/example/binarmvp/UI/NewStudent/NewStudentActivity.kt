package com.example.binarmvp.UI.NewStudent

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.binarmvp.R
import com.example.binarmvp.common.toast
import kotlinx.android.synthetic.main.activity_new_student.*

class NewStudentActivity :AppCompatActivity(), NewStudentView {


    private val presenter = NewStudentPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)
        setupView()

    }

    private fun setupView() {
        btnSaveStudent.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val nama = edtStudentName.text.toString()
        val email = edtStudentEmail.text.toString()

        if (nama.isBlank() || email.isBlank()) {
            toast("TIdk boleh kososng")
            return //memotong eksekusi di tengah jalan
        }
        val map = mutableMapOf<String, String>()
        map["name"] = nama
        map["email"] = email

        presenter.newStudent(map)
    }

    override fun onStudentSave(status: Boolean, message: String) {
        toast(message)
        if (status) {
            finish()
        }
    }
}