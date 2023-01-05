package com.example.landapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.landapp.R
import com.example.landapp.datas.Room

class RoomAdapter(
    val mCOntext : Context,
    val resId : Int,
    val mList : ArrayList<Room>) : ArrayAdapter<Room>(mCOntext,resId,mList) {

    val inflater = LayoutInflater.from(mCOntext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = inflater.inflate(R.layout.room_list_item, null)
        }
         val row = tempRow!!

        val roomData = mList[position]

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriprionTxt = row.findViewById<TextView>(R.id.descriprionTxt)

        descriprionTxt.text = roomData.description
        addressAndFloorTxt.text = "${roomData.address}, ${roomData.getFormattedFloor()}"

        return row


    }
}