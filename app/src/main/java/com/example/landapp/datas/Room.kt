package com.example.landapp.datas

// 리스트 한줄에 표현할 하위정보, 가격,주소,층수,설명
class Room(val price : Int, val address : String, val floor : Int, val description : String) {
    
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