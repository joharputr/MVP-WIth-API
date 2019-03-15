package com.example.binarmvp.UI.Home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.binarmvp.R
import com.example.binarmvp.UI.NewStudent.NewStudentActivity
import com.example.binarmvp.common.toast
import com.example.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_main.*

//manggil kelas interface(MainView)
class MainActivity : AppCompatActivity(), MainView {

    //biaasanya  1 class 1 presneter / 1 fragment 1 presenter
    private val presenter = MainPresenter(this) //this artinya main view
    private val studentList= mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //manggil kelas presenter
        setupView()

    }

    override fun onResume() {
        super.onResume()
        presenter.getStudents()
    }

    //menampilkan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_new_students, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.newStudents){
            startActivity(Intent(this,NewStudentActivity::class.java))
        }
        return super.onOptionsItemSelected(item)

    }

    private fun setupView() {
        this.title="MVP"
        rvStudent.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    override fun showStudent(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results.sortedByDescending { it.id })
        studentAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        toast(message)
    }
}
