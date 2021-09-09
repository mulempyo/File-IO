package org.techtown.fileio

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class FileWrite {
    fun writeTextFile(directory:String, filename:String,content:String ){
        val dir = File(directory)
        if(!dir.exists()){  //디렉터리가 존재하는지 검사하고 없으면 생성.파일처럼 디렉터리도 File객체에 경로를 전달하면 상태를 체크할 수 있습니다.
            dir.mkdirs() //디렉토리 생성
        }
        val writer = FileWriter(directory + "/" + filename) //디렉터리가 생성되면 디렉터리에 파일명을 합해서 FileWriter로 생성.
        val buffer = BufferedWriter(writer) //생성된 FileWriter를 buffer에 담으면 쓰기 속도가 향상됨.
        buffer.write(content)//buffer로 내용을 쓰고 close()로 닫습니다.
        buffer.close()
    }
}

//openFileOutput으로 코드 축약
/*   val contents = "Hello\nworld!"
context.openFileOutput("파일명" , Context.MODE_PRIVATE).use{stream ->
        stream.write(contents.toByteArray())
        }
* */