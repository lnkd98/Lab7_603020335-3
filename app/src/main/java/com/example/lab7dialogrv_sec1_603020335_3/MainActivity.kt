package com.example.lab7dialogrv_sec1_603020335_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val studentList : ArrayList<Student> = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycle_view.adapter= StudentsAdapter(this.studentList,applicationContext)
        recycle_view.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
        recycle_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

    }

    fun addStudent(view: View) {

        val mDialogView  = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()
        mDialogView.btnAdd.setOnClickListener {
            studentList.add ( Student(mDialogView.edt_id.text.toString
                (),mDialogView.edt_name.text.toString(),
                mDialogView.edt_age.text.toString().toInt()))
            recycle_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"The Student is added successfully",Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()

        }

        mDialogView.btnCancel.setOnClickListener() {
            mAlertDialog.dismiss()

        }

    }



    fun testStudentData() {
        studentList.add(Student("6031234567-8","Studen 1 ", 20))
        studentList.add(Student("6031234567-8","Studen 2 ", 21))

    }
}
