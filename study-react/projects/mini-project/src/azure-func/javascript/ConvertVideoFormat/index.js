const ffmpeg = require("fluent-ffmpeg")
const fs = require("fs")
const toReadableStream = require('to-readable-stream');
const readAllStream = require('read-all-stream')
const ffmpegPath = "D:/home/site/wwwroot/ffmpeg-4.1-win64-static/bin/ffmpeg.exe"
ffmpeg.setFfmpegPath(ffmpegPath)

// I have no method to solve it by stream,
// so this silly method just a test, convert all video to a file
// then pass the file data to next blob storage

module.exports = function (context, videoBlob) {
    context.log("--- start process video --- ")
    context.log(`video: ${context.bindingData.name}`)
    context.log(`size: ${videoBlob.length}`)

    context.log("--- context property ---")
    Object.keys(context).forEach(k=>context.log(k))
    context.log("--- context.bindings property ---")
    Object.keys(context.bindings).forEach(k=>context.log(k))
    context.log("--- context.bindingData property ---")
    Object.keys(context.bindingData).forEach(k=>context.log(k))
};