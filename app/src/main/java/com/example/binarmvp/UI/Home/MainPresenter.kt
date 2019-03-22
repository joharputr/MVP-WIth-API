package com.example.binarmvp.UI.Home

import com.example.binarmvp.BinarMvp
import com.example.binarmvp.model.NewStudentResponse
import com.example.binarmvp.model.Student
import com.example.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//jangan panggil android disini seperti context untuk clean code

class MainPresenter(private val view: MainView) {
    //kelas prensenter manggil kelas interface
    private val apiService by lazy {
        BinarMvp.api
    }

    //dipanggil di main activity
    fun getStudents() {
        view.showProgress(true)
        apiService.getAllStudents().enqueue(object : Callback<StudentResponse> {
            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                view.onError(t.localizedMessage)
                view.showProgress(false)
            }

            override fun onResponse(call: Call<StudentResponse>, response: Response<StudentResponse>) {
                view.showProgress(false)
                val body: StudentResponse? = response.body()
                if (body != null) {
                    body.data?.let {
                        view.showStudent(it)
                    }
                } else {
                    view.onError("Error : gagal memuat data")
                }
            }
        })
    }

    fun deleteStudent(student: Student) {
        view.showProgress(true)
        apiService.deleteStudent(student.id).enqueue(object : Callback<NewStudentResponse> {
            override fun onFailure(call: Call<NewStudentResponse>, t: Throwable) {
                view.onError(t.localizedMessage)
                view.showProgress(false)
            }

            override fun onResponse(call: Call<NewStudentResponse>, response: Response<NewStudentResponse>) {
               // val body = response.body()?.status == "OK"
                view.showProgress(false)
                if (response.body()?.status == "OK") {
                    view.showdeleteStudent(student,true, "sukses delete data siswa ${student.name}")
                } else {
                    view.showdeleteStudent(student,false, "Gagal delete data siswa ${student.name}")
                }
            }
        })
    }
}