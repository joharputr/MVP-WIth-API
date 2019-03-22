package com.example.binarmvp.UI.Home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.binarmvp.R
import com.example.binarmvp.UI.NewStudent.FormStudentActivity
import com.example.binarmvp.common.Constant
import com.example.binarmvp.common.toast
import com.example.binarmvp.model.Student
import kotlinx.android.synthetic.main.activity_main.*

//manggil kelas interface(MainView)
class MainActivity : AppCompatActivity(), MainView {

    //biaasanya  1 class 1 presneter / 1 fragment 1 presenter
    private val presenter = MainPresenter(this) //this artinya main view
    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList, this::onCLick, this::onItemLongClick) //pake reference function

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    //refresh page yang sudah terjadi perubahan
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
        if (item?.itemId == R.id.newStudents) {
            startActivity(Intent(this, FormStudentActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


    private fun setupView() {
        this.title = "MVP"
        rvStudent.run {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }

        swipeRefresh.setOnRefreshListener {
            presenter.getStudents()
            swipeRefresh.isRefreshing = false
        }
    }


    //long click
    private fun onItemLongClick(student: Student) {
        val options: Array<String> = arrayOf("Edit", "Hapus")
        AlertDialog.Builder(this)
            // whcih = index dar pilihan
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> {
                        //edit
                        editStudent(student)

                    }
                    1 -> {
                        //hapus
                        askForDelete(student)

                    }
                }//menghilangkan dialog
                dialog.dismiss()
            }
            .show()
    }

    private fun editStudent(student: Student) {
        val intent = Intent(this, FormStudentActivity::class.java)
        intent.putExtra(Constant.STUDENT, student)
        startActivity(intent)
    }

    private fun askForDelete(student: Student) {
        AlertDialog.Builder(this)
            .setTitle("hapus siswa")
            .setMessage("Anda akan menghapus siswa bernama${student.name}?")
            .setPositiveButton("tidak") { dialog, which ->
            }
            .setNegativeButton("Ya") { dialog, which ->
                presenter.deleteStudent(student)
            }
            .show()
    }

    private fun onCLick(it: Student) {

    }



    override fun showStudent(results: List<Student>) {
        studentList.clear()
        studentList.addAll(results.sortedByDescending { it.id })
        studentAdapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        toast(message)
    }

    override fun showdeleteStudent(student: Student, status: Boolean, message: String) {

        if (status) {
            studentList.remove(student)
            studentAdapter.notifyDataSetChanged()
        }
        toast(message)
    }

    override fun showProgress(show: Boolean) {
        if (show){
            progress.visibility = View.VISIBLE
        }
        else
            progress.visibility = View.GONE
    }


}
