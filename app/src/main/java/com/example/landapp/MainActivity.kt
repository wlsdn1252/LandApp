package com.example.landapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.landapp.adapters.RoomAdapter
import com.example.landapp.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<Room>()

    lateinit var mRoomAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomList.add( Room( 24500, "서울시 서대문구", 0, "서대문구의 반지하 2억 4500만원 방 입니다." ) )
        mRoomList.add( Room( 8500, "서울시 동작구", 0, " 동작구의 반지하 8500만원 방 입니다." ) )
        mRoomList.add( Room( 4500, "서울시 은평구", -2, " 은평구의 지하 2층 4500만원 방 입니다." ) )
        mRoomList.add( Room( 182500, "서울시 중랑구", 5, " 중랑구의 5층 1억 18억 2500만원 방 입니다." ) )
        mRoomList.add( Room( 235000, "서울시 도봉구", 7, " 도봉구의 7층 1억 23억 5000만원 방 입니다." ) )
        mRoomList.add( Room( 24000, "서울시 강남구", 19, " 강남구의 19층 2억 4000만원 방 입니다." ) )
        mRoomList.add( Room( 3700, "서울시 서초구", -1, " 서초구의 지하 1층 3700만원 방 입니다." ) )

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter

        //리스트의 한 줄을 클릭했을때
        roomListView.setOnItemClickListener { parent, view, position, id ->
            val clickedRoom = mRoomList[position]   // 해당 줄에 위치한 포지션값을 넣어라

            // Intent에 담아서 줄에 해당하는 정보를 넘긴다.(출발지, 도착지)
            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)
            
            // myIntent에서 정보를 넘기는데 이름은 room으로 하고 clickedRoom에 담긴 모든 정보를 putExtra(담아서 넘겨라)
            // Room.kt파일에서 생정자 옆에  : Serializable을 적어줘야 함
            myIntent.putExtra("room", clickedRoom)

            startActivity(myIntent)
        }


    }
}