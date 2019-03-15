package com.example.binarmvp.UI.NewStudent

import com.example.binarmvp.BinarMvp
import com.example.binarmvp.model.NewStudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewStudentPresenter(private val view: NewStudentView) {
    fun newStudent(map: Map<String, String>) {
        BinarMvp.api.newStudent(map)
            .enqueue(object :Callback<NewStudentResponse>{
                override fun onFailure(call: Call<NewStudentResponse>, t: Throwable) {
                    view.onStudentSave(false, t.localizedMessage)
                }

                override fun onResponse(call: Call<NewStudentResponse>, response: Response<NewStudentResponse>) {
                 val isSuccess = response.body()?.status == "OK"
                    if (isSuccess)
                    view.onStudentSave(isSuccess, "sukses menyimpan siswa")
                    else
                        view.onStudentSave(isSuccess, "gagal menyimpan")
                }

            })
    }


}