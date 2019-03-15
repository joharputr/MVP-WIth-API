package com.example.binarmvp.UI.Home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.binarmvp.R
import com.example.binarmvp.model.Student
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(private val studentList:List<Student>): RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    override fun onCreateViewHolder(group: ViewGroup, type: Int): StudentHolder {
        val inflater = LayoutInflater.from(group.context)
        return StudentHolder(inflater.inflate(R.layout.item_student, group, false))
    }

    override fun getItemCount(): Int {
     return studentList.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
    val student = studentList[position]
        //bind = nampilin data
        holder.bind(student)
    }

    //inner clas = clas dalam clas
    inner class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) = itemView.run {
            tvStudentName.text = student.name
            tvStudentEmail.text = student.email
        }
    }
}