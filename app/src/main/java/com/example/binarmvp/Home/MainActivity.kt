package com.example.binarmvp.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.binarmvp.R
import com.example.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_main.*

//manggil kelas interface(MainView)
class MainActivity : AppCompatActivity(), MainView {

    //biaasanya  1 class 1 presneter / 1 fragment 1 presenter
    private val presenter = MainPresenter(this)
    private val studentList= mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //manggil kelas presenter

        setupView()
        presenter.saySomething()
        presenter.getStudents()
    }

    private fun setupView() {
        this.title="MVP"
        rvStudent.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    //main activity sebagai View manggil kelas Presenter
    //overide dari MainView dari kelas interfiace
    override fun sayHello(hello: String) {
      print(hello)
    }

    override fun showStudent(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results)
        studentAdapter.notifyDataSetChanged()

    }
}
