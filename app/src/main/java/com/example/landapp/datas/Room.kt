package com.example.landapp.datas

import java.text.NumberFormat
import java.util.*

// 리스트 한줄에 표현할 하위정보, 가격,주소,층수,설명
class Room(val price : Int, val address : String, val floor : Int, val description : String) {

    fun getFormmatedPrice() : String{
        if(this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000

            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}만원"
        }else{
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}만원"
        }
    }

    fun getFormattedFloor() : String{
        
        if(this.floor >= 1){
            return "${this.floor}층"
        }else if(this.floor == 0){
            return "반지하"
        }else{
            return "지하${-this.floor}층"
        }
    }
}