package com.example.landapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.landapp.datas.Room
import kotlinx.android.synthetic.main.activity_view_room_detail.*

class ViewRoomDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_room_detail)

        // 메인액티비티에서  myIntent.putExtra("room", clickedRoom) 이름을 room으로 보내서 받는 이름도 room으로 받는다.
        // Intent를 Serializable로 보냈기 때문에 받을때도 getSerializableExtra로 받아준다.
        // getSerializableExtra로 받은 데이터를 as를 통해 형변화 시켜준다.
        val roomData = intent.getSerializableExtra("room") as Room

        priceTxt.text = roomData.getFormmatedPrice()
        descriprionTxt.text = roomData.description
        addressTxt.text = roomData.address
        floorTxt.text = roomData.getFormattedFloor()
    }
}