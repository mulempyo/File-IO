package org.techtown.fileio

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FileRead {
    fun readTextFile(fullPath:String):String{
        val file = File(fullPath) //실제 파일이 있는지 검사
        if(!file.exists()) return " " //파일이 존재하지 않으면 공백 리턴

        val reader = FileReader(file) //FileReader로 file읽기
        val buffer = BufferedReader(reader)//읽을 것을 BufferedReader에 담아 속도향상
        var temp = "" //buffer를 통해 한줄 씩 읽은 내용 임시 저장
        val result = StringBuffer() //모든 내용 저장
        while(true){  // while문을 반복하면서 buffer에서 할 줄을 꺼내 temp변수에 담고 그 값이 null이면 반복문을 빠져나갑니다.
            temp = buffer.readLine() // 값이 있다면(null이 아니라면) result변수에 append()합니다.
            if(temp == null) break;
            else result.append(buffer)
        }
        buffer.close()
        return result.toString()
    }
}
//openFileInput으로 코드 축약
/* var contents = ""
context.openFileInput("파일 경로").bufferedReader().useLines{lines->
       contents = lines.joinToString("\n")
       }
* */