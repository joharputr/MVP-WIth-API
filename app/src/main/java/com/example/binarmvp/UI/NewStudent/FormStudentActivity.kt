package com.example.binarmvp.UI.NewStudent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.binarmvp.R
import com.example.binarmvp.common.Constant
import com.example.binarmvp.common.toast
import com.example.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_new_student.*

class FormStudentActivity : AppCompatActivity(), NewStudentView {
    private val presenter = FormStudentPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)
        setupView()
    }

    private fun setupView() {
        val student: Student? = intent.getParcelableExtra(Constant.STUDENT)
        btnSaveStudent.setOnClickListener {
            validateForm(student)
        }
        edtStudentName.setText(student?.name)
        edtStudentEmail.setText(student?.email)
    }

    private fun validateForm(student: Student?) {
        val nama = edtStudentName.text.toString()
        val email = edtStudentEmail.text.toString()

        if (nama.isBlank() || email.isBlank()) {
            toast("TIdk boleh kososng")
            return //memotong eksekusi di tengah jalan
        }
        val map = mutableMapOf<String, String>()
        map["name"] = nama
        map["email"] = email


        if (student == null) {
            presenter.newStudent(map)
        } else {
            presenter.editStudent(student.id, map)
        }
    }

    override fun onStudentSave(status: Boolean, message: String) {
        toast(message)
        if (status) {
            finish()
        }
    }
}