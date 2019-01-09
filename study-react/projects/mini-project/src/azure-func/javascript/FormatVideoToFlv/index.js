const ffmpeg = require("fluent-ffmpeg")
const fs = require("fs")
const toReadableStream = require('to-readable-stream');
const readAllStream = require('read-all-stream')
const ffmpegPath = "D:/home/site/wwwroot/ffmpeg-4.1-win64-static/bin/ffmpeg.exe"
ffmpeg.setFfmpegPath(ffmpegPath)

module.exports = function (context, videoBlob) {
    context.log(`start format video:${context.bindingData.name}\nfile size:${videoBlob.length} Bytes`)
    context.log(`extension:${context.bindingData.extension}`)
    context.log("--- context property ---")
    Object.keys(context).forEach(k=>context.log(k))
    context.log("--- context.bindings property ---")
    Object.keys(context.bindings).forEach(k=>context.log(k))
    context.log("--- context.bindingData property ---")
    Object.keys(context.bindingData).forEach(k=>context.log(k))
    context.log(typeof videoBlob)
    context.log(videoBlob instanceof Uint8Array)
    let cmd = ffmpeg(toReadableStream(videoBlob))
      .format("mp4")
      .outputOptions("-movflags faststart")
      .on("start", (cmd)=>{
          context.log("--- ffmpeg start process")
          context.log(`spawn ffmpeg with cmd: ${cmd}`)
      })
      .on("codecData",(data)=>{
          context.log("--- codecData ---")
          context.log(`format:${data.format}`)
          context.log(`duration:${data.duration}`)
          context.log(`audio:${data.audio}`)
          context.log(`audio_details:${data.audio_details}`)
          context.log(`video:${data.video}`)
          context.log(`video_details:${data.video_details}`)
      })
      .on("error",(err)=>{
          context.log("--- ffmpeg meets some error ---")
          context.log(err)
          context.done()
      })
      .on("end", ()=>{
          context.log("--- ffmpeg process end ---")
          context.done();
      })
      
      let ffstream = cmd.pipe()

      readAllStream(ffstream, {encoding: null})
        .then((data)=>{
            context.log(data.length)
            context.log(typeof data)
            context.log(data instanceof Uint8Array)
            context.bindings.formatedVideo = data
        })

};