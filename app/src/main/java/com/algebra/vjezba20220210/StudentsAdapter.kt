package com.algebra.vjezba20220210


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter( val items : List< Student >, val context : Context ) : RecyclerView.Adapter< StudentsViewHolder >( ) {
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) : StudentsViewHolder {
        return StudentsViewHolder(
            LayoutInflater
                .from( context )
                .inflate( R.layout.student, parent, false )
        )
    }

    override fun onBindViewHolder( holder: StudentsViewHolder, position : Int ) {
        val s = items[ position ]
        holder.tvName.text   = s.name
        holder.tvYear.text   = s.year.toString( )
        holder.tvGender.text = s.gender.toString( )
    }

    override fun getItemCount( ) = items.size
}

class StudentsViewHolder( view : View ) : RecyclerView.ViewHolder( view ) {
    val tvName   : TextView = view.findViewById( R.id.tvName )
    val tvYear   : TextView = view.findViewById( R.id.tvYear )
    val tvGender : TextView = view.findViewById( R.id.tvGender )
}