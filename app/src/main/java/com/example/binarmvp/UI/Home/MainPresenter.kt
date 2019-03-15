package com.example.binarmvp.UI.Home

import com.example.binarmvp.BinarMvp
import com.example.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//jangan panggil android disini seperti context
//extend kelas interface untuk manggil method nya
class MainPresenter(private val view: MainView) {
    //kelas prensenter manggil kelas interface
    private val apiService by lazy {
        BinarMvp.api
    }

    fun getStudents() {
        apiService.getAllStudents().enqueue(object : Callback<StudentResponse> {
            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                view.onError(t.localizedMessage)
            }

            override fun onResponse(call: Call<StudentResponse>, response: Response<StudentResponse>) {
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

}