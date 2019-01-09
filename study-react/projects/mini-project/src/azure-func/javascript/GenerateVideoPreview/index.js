const ffmpeg = require("fluent-ffmpeg")
const fs = require("fs")
const ffmpegPath = "D:/home/site/ffmpeg/ffmpeg-4.1-win64-static/bin/ffmpeg.exe"
const ffprobePath = "D/home/site/ffmpeg/ffmpeg-4.1-win64-static/bin/ffprobe.exe"
ffmpeg.setFfmpegPath(ffmpegPath)
ffmpeg.setFfprobePath(ffprobePath)

const ffmpegCmd = ffmpeg()

module.exports = function (context, videoBlob) {
    context.log(`\nstart format video:${context.bindingData.name}\nfile size:${videoBlob.length} Bytes`)
    ffmpegCmd.input(fs.createReadStream(videoBlob))
        .output(context.bindings.formatedVideo)
        .format("flv")
        .on("end", ()=>{
            context.log("end process video")
        })
        .run()
    context.done();
};