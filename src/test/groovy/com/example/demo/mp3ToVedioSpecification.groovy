package com.example.demo

import com.example.demo.service.Mp3tovidioService
import spock.lang.Specification

class mp3ToVedioSpecification extends Specification {

    def mp3tovedio = new Mp3tovidioService()

    def "在图片上增加文字"(){

    }

    def "获取mp3时间长度"(){

    }

    def "通过图片调用ffmpeg生成视频"(){
        def args =["page1.jpg","D://files//source","D://files//dist//","mp3"]
        println(args)
    }

    def "调用ffmpeg将mp3音频与视频进行合并"(){

    }

}
