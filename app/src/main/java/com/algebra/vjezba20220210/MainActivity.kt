package com.algebra.vjezba20220210

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity( ) {

    private val TAG = "MainActivity"

    private val students = mutableListOf< Student >( )

    private lateinit var etName     : EditText
    private lateinit var sYear      : Spinner
    private lateinit var rgGender   : RadioGroup
    private lateinit var rbM        : RadioButton
    private lateinit var rbF        : RadioButton
    private lateinit var bSave      : Button
    private lateinit var rvStudents : RecyclerView

    override fun onCreate( savedInstanceState : Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        Log.i( TAG, "View created" )

        initWidgets( )
        Log.i( TAG, "Widgets initialized" )
        setupListeners( )
        Log.i( TAG, "Listeners done" )
    }

    fun initWidgets( ) {
        etName     = findViewById( R.id.etName )
        sYear      = findViewById( R.id.sYear )
        rgGender   = findViewById( R.id.rgGender )
        rbM        = findViewById( R.id.rbM )
        rbF        = findViewById( R.id.rbF )
        bSave      = findViewById( R.id.bSave )
        rvStudents = findViewById( R.id.rvStudents )
        rvStudents.layoutManager = LinearLayoutManager( this )
        rvStudents.adapter = StudentsAdapter( students, this )
    }

    fun setupListeners( ) {
        bSave.setOnClickListener {
            val name   = etName.text.toString( ).trim( )
            val year   = sYear.selectedItem.toString( )
            val gender = if( rbM.isChecked ) "M" else if( rbF.isChecked ) "F" else ""
            if( name=="" || gender=="" || year=="year" ) {
                Toast
                    .makeText( this, "You have to provide all the data", Toast.LENGTH_SHORT )
                    .show( )
            } else {
                val student = Student( name, year.toInt( ), gender.get( 0 ) )
                students.add( student )
                clearFields( )
                refreshStudentsList( )
            }
        }
    }

    private fun refreshStudentsList( ) {
        rvStudents.adapter?.notifyDataSetChanged( )
    }

    private fun clearFields( ) {
        etName.setText( "" )
        sYear.setSelection( 0 )
        rgGender.clearCheck( )
    }
}

class Student( val name : String, val year : Int, val gender : Char ) {
    override fun toString( ): String {
        return "$name - $year ($gender)"
    }
}